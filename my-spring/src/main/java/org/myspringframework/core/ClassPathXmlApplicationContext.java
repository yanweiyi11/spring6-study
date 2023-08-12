package org.myspringframework.core;

import org.apache.logging.slf4j.Log4jLogger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 解析myspring的配置文件，初始化所有的bean对象
     *
     * @param configLocation myspring配置文件的路径
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            // 解析myspring.xml，实例化bean，将bean存放到singletonObjects集合当中。
            // 获取输入流，指向配置文件
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            // dom4j解析XML文件的核心对象
            SAXReader reader = new SAXReader();
            // 读文件
            Document document = reader.read(in);
            // 获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");
            // 遍历bean标签
            nodes.forEach(node -> {
                try {
                    // 向下转型是为了使用Element接口里更丰富的方法
                    Element beanEle = (Element) node;
                    // 获取id属性
                    String id = beanEle.attributeValue("id");
                    // 获取class属性
                    String clazzName = beanEle.attributeValue("class");
                    System.out.println("beanName=" + id + "，beanClassName=" + clazzName);
                    // 通过反射机制创建对象，将其放到map集合中提前曝光
                    // 1.获取Class
                    Class<?> clazz = Class.forName(clazzName);
                    // 2.获取无参构造
                    Constructor<?> defaultCon = clazz.getDeclaredConstructor();
                    // 3.调用无参构造创建对象
                    Object bean = defaultCon.newInstance();
                    // 将bean曝光，加入map集合
                    singletonObjects.put(id, bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            // 再次重新把所有的bean标签遍历一次，这一次主要是给对象的属性赋值
            nodes.forEach(node -> {
                Element beanEle = (Element) node;
                // 获取id
                String id = beanEle.attributeValue("id");
                // 获取clazzName
                String clazzName = beanEle.attributeValue("class");
                // 获取该bean标签下所有的properties标签
                List<Element> propertyList = beanEle.elements("property");
                propertyList.forEach(property -> {
                    try {
                        // 获取属性名
                        String propertyName = property.attributeValue("name");
                        // 获取set方法名
                        String methodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                        // 获取set方法
                        // 1.Class
                        Class<?> clazz = Class.forName(clazzName);
                        // 2.属性类型
                        Field field = clazz.getDeclaredField(propertyName);
                        // 3.方法
                        Method setMethod = clazz.getDeclaredMethod(methodName, field.getType());
                        // 获取具体的值
                        String propertyValue = property.attributeValue("value");
                        String propertyRef = property.attributeValue("ref");
                        Object actualValue = null; // 真值
                        if (propertyValue != null) { // 值是简单类型
                            // 调用set方法
                            String propertyTypeSimpleName = field.getType().getSimpleName();
                            switch (propertyTypeSimpleName) {
                                case "byte":
                                    actualValue = Byte.parseByte(propertyValue);
                                    break;
                                case "short":
                                    actualValue = Short.parseShort(propertyValue);
                                    break;
                                case "int":
                                    actualValue = Integer.parseInt(propertyValue);
                                    break;
                                case "long":
                                    actualValue = Long.parseLong(propertyValue);
                                    break;
                                case "float":
                                    actualValue = Float.parseFloat(propertyValue);
                                    break;
                                case "double":
                                    actualValue = Double.parseDouble(propertyValue);
                                    break;
                                case "boolean":
                                    actualValue = Boolean.parseBoolean(propertyValue);
                                    break;
                                case "char":
                                    actualValue = propertyValue.charAt(0);
                                    break;
                                case "Byte":
                                    actualValue = Byte.valueOf(propertyValue);
                                    break;
                                case "Short":
                                    actualValue = Short.valueOf(propertyValue);
                                    break;
                                case "Integer":
                                    actualValue = Integer.valueOf(propertyValue);
                                    break;
                                case "Long":
                                    actualValue = Long.valueOf(propertyValue);
                                    break;
                                case "Float":
                                    actualValue = Float.valueOf(propertyValue);
                                    break;
                                case "Double":
                                    actualValue = Double.valueOf(propertyValue);
                                    break;
                                case "Boolean":
                                    actualValue = Boolean.valueOf(propertyValue);
                                    break;
                                case "Character":
                                    actualValue = Character.valueOf(propertyValue.charAt(0));
                                    break;
                                default:
                                    actualValue = propertyValue;
                            }
                            setMethod.invoke(singletonObjects.get(id), actualValue);
                        }
                        if (propertyRef != null) { // 值是非简单类型
                            setMethod.invoke(singletonObjects.get(id), singletonObjects.get(propertyRef));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            });

            System.out.println(singletonObjects);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}

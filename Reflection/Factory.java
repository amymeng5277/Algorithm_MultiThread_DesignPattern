package test.Reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by mengdongqi on 17-10-28.
 */
public class Factory {
  private static Factory factory = new Factory();
  private Factory(){}
  public Factory getFactory(){
    return factory;
  }
  private static Properties properties = new Properties();
  public synchronized static Properties getProperties(String fileName) throws FileNotFoundException {
    try {
      properties.load(new FileInputStream(fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties;
  }
  public static void main(String args[]){
    try {
      Factory.getProperties(Factory.class.getResource("test.property").getPath());
      String classInfo = Factory.properties.getProperty("test");
      try {
        Class c = Class.forName(classInfo);
        try {
          Object o = c.newInstance();
          TestInterface t = (TestInterface)(o);
          t.print();
        } catch (InstantiationException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}

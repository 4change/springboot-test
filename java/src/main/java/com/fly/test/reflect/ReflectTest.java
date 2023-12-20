package com.fly.test.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

public class ReflectTest {

    @Test
    public void test() {
        Hero hero = new Hero();
        hero.setGender("男");
        hero.setName("\\N");
        readAttributeValue(hero);
        System.out.println(hero);
    }

    /**
     * 得到属性值
     *
     * @param obj
     */
    public static void readAttributeValue(Object obj) {
        String nameVlues = "\\N";
        //得到class
        Class<? extends Object> cls = obj.getClass();
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                //得到属性
                Field field = fields[i];
                //打开私有访问
                field.setAccessible(true);
                //获取属性
                String name = field.getName();
                //获取属性值
                Object value = field.get(obj);

                String valueStr = "";
                if (value instanceof String) {
                    valueStr = (String)value;
                }


                if (name.equalsIgnoreCase("id")) {
                    System.out.println("--------------------------------");
                    field.set(obj, 1000);
                }

                if (valueStr.equalsIgnoreCase("\\N")) {
                    field.set(obj, "");
                }

                //一个个赋值
                nameVlues += field.getName() + ":" + value + ",";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //获取最后一个逗号的位置
        int lastIndex = nameVlues.lastIndexOf(",");
        //不要最后一个逗号","
        String result = nameVlues.substring(0, lastIndex);
        System.out.println(result);
    }

}

class Hero {
    public int id;
    public String name;
    public String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Hero [id = " + id + ", name = " + name + ", gender = " + gender + "]";
    }
}

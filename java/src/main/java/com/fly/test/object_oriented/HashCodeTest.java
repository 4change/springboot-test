package com.fly.test.object_oriented;

import java.util.HashSet;

/**
 * 参考：https://www.cnblogs.com/skywang12345/p/3324958.html
 *
 * @author java栈长
 * @desc 比较equals() 返回true 或 false时， hashCode()的值。
 * <p>
 * debug时，注释Person类的hashCode(),查看输出结果：
 * <p>
 * 一、不覆写hashCode(): //debug时注释hashCode()即可
 * 输出
 * p1.equals(p2) : true; p1(1174361318) p2(589873731)
 * set:[(eee, 100), (eee, 100), (aaa, 200)]  //hashSet中出现重复元素，因为p1和p2的hashCode()不相同
 * <p>
 * 二、覆写Person类的hashCode() ------>正确姿势
 * 输出：
 * p1.equals(p2) : true; p1(37) p2(37)
 * set:[(a, 100), (b, 200)]  //hashSet中没有重复元素，p1和p2的hashCode相同了，equals()也生效了。
 */
public class HashCodeTest {

    public static void main(String[] args) {
        // 新建Person对象，
        Person p1 = new Person("a", 100);
        Person p2 = new Person("a", 100);
        Person p3 = new Person("b", 200);

        // 新建HashSet对象
        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        // 比较p1 和 p2， 并打印它们的hashCode()
        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());

        // 打印set
        System.out.printf("set:%s\n", set);
    }

    /**
     * @desc Person类。
     */
    private static class Person {
        int age;
        String name;

        @Override
        public int hashCode() {
            int nameHash = name.toUpperCase().hashCode();
            return nameHash ^ age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return "(" + name + ", " + age + ")";
        }

        /**
         * @desc 覆盖equals方法
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            //如果是同一个对象返回true，反之返回false
            if (this == obj) {
                return true;
            }

            //判断是否类型相同
            if (this.getClass() != obj.getClass()) {
                return false;
            }

            Person person = (Person) obj;
            return name.equals(person.name) && age == person.age;
        }
    }
}

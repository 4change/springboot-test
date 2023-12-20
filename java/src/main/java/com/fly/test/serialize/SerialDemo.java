package com.fly.test.serialize;

import java.io.*;

public class SerialDemo {

    /**
     * 序列化和反序列化的底层实现原理是什么？ https://blog.csdn.net/xlgen157387/article/details/79840134
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.out"));
        User user1 = new User("xuliugen", "123456", "male");
            // 通过writeObject()方法进行对象序列化
        oos.writeObject(user1);
        oos.flush();
        oos.close();

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.out"));
            // 通过readObject()方法进行反序列化
        User user2 = (User) ois.readObject();
        System.err.println(user2.getUserName()+ " " + user2.getPassword() + " " + user2.getSex());
        ois.close();
    }

}

class User implements Serializable {

	private static final long serialVersionUID = -7464833453381125914L;
	
	private String userName;
    private String password;
    private String sex;

    public User() {
    }

    public User(String userName, String password, String sex) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

package com.fly.test.io.csv;

import java.io.*;

public class WriteCSV {

    public static void main(String[] args) {
        try {
            File csv = new File("writers.csv"); // CSV数据文件

            BufferedWriter bw = new BufferedWriter(new FileWriter(csv,true)); // 附加
            // 添加新的数据行
            bw.write("李四" + "," + "1988" + "," + "1992 \r\n");
            bw.write("adfas, sdf, 432 \r\n");
            bw.newLine();
            bw.close();

        } catch (FileNotFoundException e) {
            // File对象的创建过程中的异常捕获
            e.printStackTrace();
        } catch (IOException e) {
            // BufferedWriter在关闭对象捕捉异常
            e.printStackTrace();
        }
    }

}

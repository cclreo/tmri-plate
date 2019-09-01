package com.tmri;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Upload {

    String floder = "/Users/micro/Downloads/python/";

    public void run(String fileName) throws IOException, InterruptedException {

        String exe = "python3";
        String command = "/Users/micro/Downloads/python/deploy-jar.py";
        String num1 = floder;
        String num2 = floder;
        String num3 = floder+fileName;
        String[] cmdArr = new String[] {exe,command,num1,num2,num3};
        Process process = Runtime.getRuntime().exec(cmdArr);
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readLine();
        process.waitFor();
        System.out.println(str);

    }

    public static void main(String[] args) {
        try {
            new Upload().run("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}

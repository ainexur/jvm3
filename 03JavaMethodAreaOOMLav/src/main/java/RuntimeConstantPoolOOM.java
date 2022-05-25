package main.java;

import java.util.HashSet;
import java.util.Set;

public class RuntimeConstantPoolOOM {

    /***
     * Jdk 6
     * vm option: -XX:PermSize=1m -XX:MaxPermSize=2m
     * 测试永久代实现的方法区
     */
    static void main(    String[] args) {

        Set<String> st = new HashSet<>();

        short i = 0;
        while (true) {
            st.add(String.valueOf(i++).intern());
        }
    }
}

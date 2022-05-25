package main.java;

/**
 * @Classname StringInternLab
 * @Description String.intern()在JDK6和JDK8返回引用的测试
 * @Date 2022/5/4 13:39
 * @Created by coco
 */
public class test {

    /**
     * JDK6: false false false：intern需要将永久代没出现过的字符串复制到永久代的常量池返回引用
     * JDK8: true false true: intern的常量池在堆上不需要复制；“java”字符串本来就存在常量池中，所以和str2对象引用不一样。
     * @param args
     */
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("ja").append("va1").toString();
        System.out.println(str3.intern() == str3);

    }
}


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname JavaMethodAreaOOM
 * @Description JDK7及之前当类信息很多时，方法区溢出。JDK8用元空间取代方法区，该代码很难溢出。
 * @Date 2022/5/4 13:54
 * @Created by coco
 */
public class JavaMethodAreaOOM {

    static class OOMObject{}
    public static void main(String[] args) {
        while (true) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, args));
            enhancer.create();
        }
    }
}

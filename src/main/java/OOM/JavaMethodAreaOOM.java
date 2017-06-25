package OOM;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * Created by Charley on 2017/6/24.
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {

        while (true) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(HeapOOM.OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                    return methodProxy.invoke(o, objects);
                }
            });
            enhancer.create();
        }
    }
}
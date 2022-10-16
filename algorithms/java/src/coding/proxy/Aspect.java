package coding.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author zzf
 * @date 2022/10/15 4:38 下午
 */
public interface Aspect {
    void before();

    void after();

    static <T> T getProxy(Class<T> cls, String ... aspects) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        T t = cls.getConstructor().newInstance();
        return (T) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(t);
                    }
                });
    }
}

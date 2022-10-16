package coding.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;

/**
 * @author zzf
 * @date 2022/10/15 4:39 下午
 */
public class ObjectFactory {

    public static <T> T newInstance(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Annotation[] annotations = clazz.getAnnotations();
        LinkedList<IAspect> aspects = new LinkedList<>();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Aspect) {
                Class type = ((Aspect) annotation).type();
                IAspect iAspect = (IAspect) (type.getConstructor().newInstance());
                aspects.push(iAspect);
            }
        }
        T t = clazz.getConstructor().newInstance();
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aspects.forEach(IAspect::before);
                        Object result = method.invoke(t);
                        aspects.forEach(IAspect::after);
                        return result;
                    }
                });

    }

    @Test
    public void test() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
        IOrder order = ObjectFactory.newInstance(Order.class);
        order.pay();
        order.show();
    }
}

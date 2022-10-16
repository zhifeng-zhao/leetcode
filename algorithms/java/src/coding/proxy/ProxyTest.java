package coding.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zzf
 * @date 2022/10/15 4:41 下午
 */
public class ProxyTest {
    @Test
    public void test() throws InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        IOrder order = (IOrder) Aspect.getProxy(Order.class, "coding.proxy.TimeUsageAspect");
        order.pay();
        order.show();
    }
}

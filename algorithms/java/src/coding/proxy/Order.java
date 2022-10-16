package coding.proxy;

import coding.annotation.IOrder;

/**
 * @author zzf
 * @date 2022/10/15 4:39 下午
 */
public class Order implements IOrder {
    int status = 0;
    @Override
    public void pay() throws InterruptedException {
        Thread.sleep(50);
        this.status = 1;
    }

    @Override
    public void show() {
        System.out.println("Order Status:" + this.status);
    }
}

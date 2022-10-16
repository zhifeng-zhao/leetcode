package coding.proxy;

/**
 * @author zzf
 * @date 2022/10/15 4:38 下午
 */
public interface IOrder {
    void pay() throws InterruptedException;

    void show();
}

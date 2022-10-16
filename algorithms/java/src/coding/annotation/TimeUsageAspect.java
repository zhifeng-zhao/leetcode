package coding.annotation;

/**
 * @author zzf
 * @date 2022/10/15 4:39 下午
 */
public class TimeUsageAspect implements IAspect {
    long start;

    @Override
    public void before() {
        start = System.currentTimeMillis();
    }

    @Override
    public void after() {
        long usage = System.currentTimeMillis() - start;
        System.out.format("time usage: %dms\n", usage);
    }
}

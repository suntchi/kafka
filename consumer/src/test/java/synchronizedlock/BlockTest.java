package synchronizedlock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.stc.kafka.locks.synchronizedlock.Block;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * <p>
 * 代码块测试
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/29
 */
public class BlockTest {
    /**
     *  测试代码块同一个对象互斥
     *
     * @since :  2020/9/29
     *
     */
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,0L,TimeUnit.SECONDS,new ArrayBlockingQueue<>(1),new ThreadFactoryBuilder().setNameFormat("代码块测试-%d").build());

    @Test
    public void test() throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        Block block = new Block(countDownLatch);


        threadPoolExecutor.execute(block);
        threadPoolExecutor.execute(block);
        countDownLatch.await();

    }
}

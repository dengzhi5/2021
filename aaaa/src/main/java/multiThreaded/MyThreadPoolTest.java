package multiThreaded;

import javax.annotation.Resource;
import java.util.concurrent.*;

public class MyThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService newSinglePool= Executors.newFixedThreadPool(3);
        ExecutorService myThreadPool = new ThreadPoolExecutor(3,5,1000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        //my.execute();
        myThreadPool.execute(()->{
            a();
        });
        myThreadPool.execute(()->{
            b();
        });
    }

    private static void b() {
        for(int i=0;i<10;i++){
            System.out.println(i+""+Thread.currentThread());
        }
    }

    private static void a() {
        for(int i=0;i<10;i++){
            System.out.println(i+""+Thread.currentThread());
        }
    }

}

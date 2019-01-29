package cn.xmjbq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;

/**
 * @author howinfun
 * @version 1.0
 * @desc
 * @date 2019/1/23
 * @company XMJBQ
 */
@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner, DisposableBean {

    private static Logger logger = LoggerFactory.getLogger(UserServiceApplication.class);

    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    public static void main(String[] args){
        ApplicationContext ctx = new SpringApplicationBuilder().sources(UserServiceApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
        try {
            closeLatch.await();
        }catch (Exception e){
            logger.error("服务启动异常",e);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("服务启动中。。。。。");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("服务关闭。。。。");
        closeLatch().countDown();
    }
}

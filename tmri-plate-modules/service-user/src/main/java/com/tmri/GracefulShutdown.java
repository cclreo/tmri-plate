package com.tmri;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * 测试web容器优雅停机
 */
@Slf4j
@Component
public class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {


    private volatile Connector connector;

    private final int waitTime = 60;

    @Override
    public void customize(Connector connector) {
        log.info("TomcatConnectorCustomizer");
        this.connector = connector;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {

        log.info("准备关闭容器，先关闭线程!");
        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("关闭容器，先关闭线程!");
        this.connector.pause();
        Executor executor = this.connector.getProtocolHandler().getExecutor();

        if (executor instanceof ThreadPoolExecutor) {
            try {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                threadPoolExecutor.shutdown();

                if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {

                    log.error("Tomcat thread pool did not shut down gracefully within " + waitTime
                            + " seconds. Proceeding with forceful shutdown");
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
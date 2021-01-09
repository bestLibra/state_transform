/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * <p>
 *
 * @author 谭森
 * @version 1.0.0
 * @date 2021/1/7
 */
@SpringBootApplication(scanBasePackages = {"com.tansen.study"})
public class AppApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppApplication.class);

    /**
     * 程序入口
     *
     * @param args 命令行参数数组
     */
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
        LOGGER.info("AppApplication application start success......");
    }

}

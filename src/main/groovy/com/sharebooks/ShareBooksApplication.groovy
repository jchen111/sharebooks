package com.sharebooks

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

/**
 * Created by z001ktb on 3/17/16.
 */
@SpringBootApplication
@EnableWebMvc
class ShareBooksApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShareBooksApplication.class, args);
    }
}

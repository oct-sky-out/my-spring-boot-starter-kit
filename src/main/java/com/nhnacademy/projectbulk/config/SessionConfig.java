package com.nhnacademy.projectbulk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * 레디스 커스텀 세션 설정입니다.
 *
 * @author 김민수
 * @since 1.0
 */
@Configuration
public class SessionConfig {
    private static final Integer THIRTEEN_MINUTES_SECONDS = 1800;

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("MY_SESSIONID");
        serializer.setUseHttpOnlyCookie(true);
        serializer.setCookieMaxAge(THIRTEEN_MINUTES_SECONDS);   // 3일
        serializer.setCookiePath("/");

        return serializer;
    }
}

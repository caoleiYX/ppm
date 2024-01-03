package com.example.demo.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Feign拦截器
 *
 * @author fenglin
 * @since 2023-01-11 20:14:53
 */
@Configuration
@Slf4j
public class FeignOAuth2RequestInterceptor implements RequestInterceptor {
    private static String APP_ID = "erdp";
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String accessToken = request == null ? StringUtils.EMPTY : request.getHeader(HttpHeaders.AUTHORIZATION);
        String appId = request == null ? StringUtils.EMPTY : request.getHeader("appId");
        if(StringUtils.isEmpty(appId)){
            appId = APP_ID;
        }
        if (log.isInfoEnabled()) {
            log.info("Feign Interceptor AccessToken:{} , appId:{}",accessToken,appId);
        }
        requestTemplate.header(HttpHeaders.AUTHORIZATION, accessToken);
        requestTemplate.header("appId",appId);
    }
}

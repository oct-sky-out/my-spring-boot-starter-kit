package com.nhnacademy.projectbulk.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 세션시간을 유지하기 위한 필터
 *
 * @author 김민수
 * @since 1.0
 */
public class SessionTimeResetFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpSession session = httpRequest.getSession(false);
        session.setMaxInactiveInterval(1800);

        super.doFilter(request, response, chain);
    }
}

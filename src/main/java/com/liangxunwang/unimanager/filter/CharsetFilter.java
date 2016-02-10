package com.liangxunwang.unimanager.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-4-4
 * Time: 下午3:15
 * To change this template use File | Settings | File Templates.
 */
public class CharsetFilter implements Filter {

    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String charset = filterConfig.getInitParameter("charset");
        servletRequest.setCharacterEncoding(charset);
        servletResponse.setCharacterEncoding(charset);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}

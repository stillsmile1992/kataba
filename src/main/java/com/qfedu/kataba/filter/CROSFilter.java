package com.qfedu.kataba.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 徐天麒
 * @version 1.0
 * @project kataba
 * @description 处理跨域
 * @createTime 2020/10/19 17:28
 */
@WebFilter("/*")
public class CROSFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}

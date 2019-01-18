package com.jiangfengliu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
  @Override
  public void destroy() {
    System.out.println("过滤器销毁");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    System.out.println("执行过滤操作begin");
    chain.doFilter(request, response);
    System.out.println("执行过滤操作over");
  }

  @Override
  public void init(FilterConfig config) throws ServletException {
    System.out.println("过滤器初始化");
  }
} 
package com.lhh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lai.huihui on 2020/8/24.
 */
//继承zuulFilter，在zuul框架运行时拦截请求
@Component
public class MyFilter extends ZuulFilter {
//    pre - 路由前
//    routing - 路由时
//    post - 路由后
//    error - 错误
    @Override
    public String filterType() {
        return "pre";   //路由前执行
    }

    @Override
    public int filterOrder() {
        return 1;   //执行顺序，越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true;   //true,开启
    }
    //拦截逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("access-token");
        if (token == null || !("laihuihui").equals(token)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
        }
        return null;
    }
}

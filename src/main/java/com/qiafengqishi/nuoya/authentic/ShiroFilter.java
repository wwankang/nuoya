package com.qiafengqishi.nuoya.authentic;

import com.qiafengqishi.nuoya.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ShiroFilter extends AuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse response1) throws Exception {
        HttpServletResponse response = (HttpServletResponse) response1;
        HttpServletRequest request = (HttpServletRequest) servletRequest;


        //获取当前请求的路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"  + request.getServerPort()+request.getContextPath();

        response.setContentType("text/html;charset=utf-8");
        response.setHeader("REDIRECT", "REDIRECT");
        //需要重定向的路径
        response.setHeader("CONTENTPATH", "/login");

//        response.setStatus(302);
        response.setHeader("Location",basePath + "/login"); //fixme 这个页面怎么转过去？ 后端转的不是页面，而是接口直接调用了

        response.getWriter().write( AjaxResult.failAlert("请重新登陆!"));

        return false;
    }
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse response, Object mappedValue) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(TokenUtil.tokenHeard);

        /*if (null == token||"".equals(token)) {
            log.info("[ShiroFilter] token:{} 为null！", token);
            return false;
        }

        //验证token的真实性
        try {
            TokenUtil.getTokenBody(token);
        } catch (Exception e) {
            log.info("[ShiroFilter]token:{}校验异常！", token, e);
            return false;
        }*/
        //fixme 过期时间

        return true;
    }

}

package org.guet.exam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.guet.exam.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import me.chanjar.weixin.mp.api.WxMpService;

/**
 * 拦截用户所有请求 验证当前用户身份
 * 
 * @author cx
 *
 */
@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {
	private final Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);
	public static final String LAST_PAGE = "org.guet.exam.interceptor";
	@Autowired
	private WxMpService service;

	/*
	 * 利用正则映射到需要拦截的路径
	 * 
	 * private String mappingURL;
	 * 
	 * public void setMappingURL(String mappingURL) { this.mappingURL =
	 * mappingURL; }
	 */
	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("==============执行顺序: 1、preHandle================");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		String queryString = request.getQueryString();

		log.info("requestUri:" + requestUri);
		log.info("contextPath:" + contextPath);
		log.info("url:" + url);
		log.info("queryString:" + queryString);

		if (url.startsWith("/s/user/certified")) {
			String openId = (String) request.getSession().getAttribute("openid");
			if(openId==null||"".equals(openId)){
				
				String redirectURI = request.getScheme() + "://" + request.getServerName() + contextPath + "/s/getopenid";
				String state = url + "?" + queryString;
				String scope = "snsapi_userinfo";
				
				String authorizationUrl = service.oauth2buildAuthorizationUrl(redirectURI, scope, state);// 构建授权url
				
				log.info("redirectURI:" + redirectURI);
				log.info("state:" + state);
				log.info("authorizationUrl:" + authorizationUrl);
				
				response.sendRedirect(authorizationUrl);
				return false;
			}else{
				return true;
			}
		}
		else if (url.startsWith("/s/in")) {
			// 判断是系统内功能性请求
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				// 说明已授权判断用户角色
				if (user.getRole() == 1) {
					// TODO
				}
				if (user.getRole() == 0) {
					// TODO
				}
			} else {
				// 若没有user标识 需要转向授权页面
				String redirectURI = request.getScheme() + "://" + request.getServerName() + contextPath
						+ "/s/authorize";
				String state = url + "?" + queryString;
				String scope = "snsapi_userinfo";

				String authorizationUrl = service.oauth2buildAuthorizationUrl(redirectURI, scope, state);// 构建授权url

				log.info("redirectURI:" + redirectURI);
				log.info("state:" + state);
				log.info("authorizationUrl:" + authorizationUrl);

				response.sendRedirect(authorizationUrl);
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 可在modelAndView中加入数据，比如当前时间
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("==============执行顺序: 2、postHandle================");
		if (modelAndView != null) { // 加入当前时间
			modelAndView.addObject("var", "测试postHandle");
		}
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
	 * 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("==============执行顺序: 3、afterCompletion================");
	}

}

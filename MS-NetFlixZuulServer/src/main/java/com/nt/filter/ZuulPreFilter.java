package com.nt.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component

public class ZuulPreFilter extends ZuulFilter {
	
	private Logger logger=LoggerFactory.getLogger(ZuulPreFilter.class);

	@Override
	public boolean shouldFilter() {

		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		//get request context object(it contains access to multiple other objects
		
		RequestContext context=RequestContext.getCurrentContext();
		
		// get HttpServletRequest objects from this 
		HttpServletRequest req=context.getRequest();
		System.out.println("ZuulPreFilter.run()::from pre filter");
		
		//write log message about currnet  request
		
		logger.info("======from pre filter=======");
		logger.info("request context type"+req.getContentType());
		logger.info("request mode"+req.getMethod());
		logger.info("request path"+req.getServletPath());
		logger.info("request url"+req.getRequestURL());
		
		
		
		return null;
	}

	@Override
	public String filterType() {
		
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {

		return 0;
	}

}

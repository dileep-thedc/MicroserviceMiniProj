package com.nt.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPostFilter extends ZuulFilter {
	
	private Logger logger=LoggerFactory.getLogger(ZuulPostFilter.class);
	

	@Override
	public boolean shouldFilter() {

		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//get request object (it contains access to multiple object)
		RequestContext context=RequestContext.getCurrentContext();
		
		//get HttpServeletResponse object from this
		HttpServletResponse res=context.getResponse();
		System.out.println("ZuulPostFilter.run()::  from posst filter()");
		
		//write log message abou current request
		
		logger.info("=======from post filtr====");
		logger.info("resonse content type"+res.getContentType());
		logger.info("response status"+res.getStatus());
		logger.info("response status code "+res.getHeaders("host"));
		
		
		
		

		return null;
	}

	@Override
	public String filterType() {

		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {

		return 0;
	}

}

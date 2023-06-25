package com.nt.filter;

//import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulRouteFilter extends ZuulFilter {
	
	private Logger logger=LoggerFactory.getLogger(ZuulRouteFilter.class);

	@Override
	public boolean shouldFilter() {

		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		//get request context object(it contains access to multiple other objects
		
				RequestContext context=RequestContext.getCurrentContext();
				
				// get HttpServletRequest objects from this 
				//HttpServletRequest req=context.getRequest();
				System.out.println("ZuulRouteFilter.run()::From ZuulRoute Filter");
				
				//write log message about current request
				
				logger.info("=======from route filter=======");
				logger.info("route host"+context.getRouteHost());
		
		
		return null;
	}

	@Override
	public String filterType() {

		return FilterConstants.ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {

		return 0;
	}

}

package com.nt.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class ZuulErrorFilter extends ZuulFilter {
	private Logger logger=LoggerFactory.getLogger(ZuulErrorFilter.class);

	@Override
	public boolean shouldFilter() {

		return true;
	}

	@Override
	public Object run() throws ZuulException {
        // get requestcontext object (it contains  access to multiple object )
		RequestContext context=RequestContext.getCurrentContext();
		System.out.println("ZuulErrorFilter.run()::from error filter()");
		//get throwable object
		Throwable th=context.getThrowable();
		//write log message about current request
		
		logger.info("=====From Error Filter=======");
		logger.error("Exception message"+th.getMessage()+"class name:"+th);
		return null;
	}

	@Override
	public String filterType() {

		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {

		return 0;
	}

}

package com.sfeir.server.crawler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;

public class CrawlerFilter implements Filter {


	private static final String FRAGMENT = "#!";
	private static final String ESCAPED_FRAGMENT = "_escaped_fragment_";
	private static final Logger logger = Logger.getLogger(CrawlerFilter.class.getName());

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) arg0; 
		HttpServletResponse resp = (HttpServletResponse) arg1;

		try {
			String queryString = req.getQueryString();
			if ((queryString != null) && (queryString.contains(ESCAPED_FRAGMENT))) {
						
				ServletOutputStream out = resp.getOutputStream();
				WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3_6);
				webClient.setThrowExceptionOnScriptError(false);
				webClient.setJavaScriptEnabled(true);
				String pageName = rewritePageName(req);
				TextPage page = webClient.getPage(pageName);
				out.println(page.getContent());
				webClient.closeAllWindows();
				out.close();
				
			}
			else {
				arg2.doFilter(arg0, arg1);
			}
		}
		catch(Throwable t) {
			t.printStackTrace();
		}
		
	}

	private String rewritePageName(HttpServletRequest req) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		sb.append("http://");
		sb.append(req.getServerName());
		if (req.getServerPort() != 0)  {
			sb.append(":").append(req.getServerPort());
		}
		sb.append(req.getRequestURI());
		sb.append(rewriteQueryString(req.getQueryString()));
		String crawlerService = "http://crawlservice.appspot.com/?key=123456&url=";
		return crawlerService + URLEncoder.encode(sb.toString());
	}

	private String rewriteQueryString(String queryString) throws UnsupportedEncodingException {
		int index = queryString.indexOf("&" + ESCAPED_FRAGMENT + "=");
		int length = 20;
		if (index == -1) {
			index = queryString.indexOf(ESCAPED_FRAGMENT + "=");
			length = 19;
		}
		StringBuilder queryStringBuilder = new StringBuilder();
		if (index > 0) {
			queryStringBuilder.append("?").append(queryString.subSequence(0, index));	
		}
		queryStringBuilder.append(FRAGMENT).append(URLDecoder.decode(queryString.substring(index+length, queryString.length()), "UTF-8"));
		return queryStringBuilder.toString();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}

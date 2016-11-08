package org.tools.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FilterEncoding implements Filter {
	String encoding = null;
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getMethod().equals("GET")) {
			ChineseCodeErrorRequest ccer = new ChineseCodeErrorRequest(req,
					encoding);
			req = ccer;
		}
		chain.doFilter(req, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		encoding = arg0.getInitParameter("encoding");
		encoding = encoding == null ? "UTF-8" : encoding;
	}
}

class ChineseCodeErrorRequest extends HttpServletRequestWrapper {
	private String encoding = null;

	public ChineseCodeErrorRequest(HttpServletRequest request, String encoding) {
		super(request);
		this.encoding = encoding;
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (value != null) {
			value = changeValue(value, encoding);
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				values[i] = changeValue(values[i], encoding);
			}
			return values;
		}else{
			return null;
		}
	}

	private String changeValue(String value, String encoding) {
		try {
			value = new String(value.getBytes("ISO-8859-1"), encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}
}

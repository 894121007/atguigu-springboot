package com.atguigu.crud.config.webMvc.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 */
@Qualifier
public class MyLocaleResolve implements LocaleResolver {
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Locale locale = Locale.getDefault();
		String language = request.getParameter("language");
		if(!StringUtils.isEmpty(language)) {
			String[] split = language.split("_");
			locale = new Locale(split[0],split[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

	}


}

package com.sample.reservationSys.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@ComponentScan(basePackages="com.sample.reservationSys.config")
public class MvcConfig implements WebMvcConfigurer {
	
	@Bean  
	public ResourceBundleMessageSource bundleMessageSource()  
	{  
	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();  
	messageSource.setBasename("messages");  
	return messageSource;  
	}  
	
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver clr = new CookieLocaleResolver();
        clr.setDefaultLocale(Locale.US);
        return clr;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	    // Defaults to "locale" if not set
	    localeChangeInterceptor.setParamName("localeData");
	    return localeChangeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
	    interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}
}

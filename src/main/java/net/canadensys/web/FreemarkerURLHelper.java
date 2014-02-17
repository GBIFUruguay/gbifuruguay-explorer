package net.canadensys.web;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import freemarker.ext.servlet.HttpRequestHashModel;

/**
 * Candidate for future canadensys-web-core library
 * Helper class to manage URL from Freemarker HttpRequestHashModel in Servlet environment.
 * Wrap the class with freemarker.ext.beans.BeansWrapper
 * In your template use something like : ${URLHelper.getURL(Request,"lang","en")}
 * @author canadensys
 *
 */
public class FreemarkerURLHelper {
	
	public static final String LANG_PARAM = "lang";
	
	/**
	 * Get absolute URL from HttpRequestHashModel and add or change a query string parameter.
	 * @param hr HttpRequestHashModel from Freemarker template
	 * @param name query string parameter to add or change
	 * @param value Value of the query string parameter
	 * @return absolute URL as String
	 */
	public static String getURL(HttpRequestHashModel hr, String name, String value){
		UriComponentsBuilder bldr = ServletUriComponentsBuilder.fromRequest(hr.getRequest());
		bldr.replaceQueryParam(name,value);
		return bldr.build().toUriString();
	}
	
	/**
	 * Replace or add a query parameter in the current request and return the new query part of the request.
	 * @param hr
	 * @param name
	 * @param value query part only e.g. view=table&filter=auto
	 * @return
	 */
	public static String replaceCurrentQueryParam(HttpRequestHashModel hr, String name, String value){
		UriComponentsBuilder bldr = ServletUriComponentsBuilder.fromRequest(hr.getRequest());
		bldr.replaceQueryParam(name,value);
		return bldr.build().getQuery();
	}
	
	public static String resourceToI18nString(String lang, String resourceName){
		if(resourceName.startsWith("/")){
			resourceName = resourceName.replaceAll("/", "");
		}
		InMemoryResourceBundle rb = InMemoryResourceBundle.getBundle("urlResource", new Locale(LANG_PARAM));
		String t = rb.inverseLookup(resourceName);
		return t;
	}
	
	/**
	 * Build a i18n resource path from a resource name and parameters.
	 * @param lang
	 * @param resourceName
	 * @param params
	 * @return
	 */
	public static String toI18nResource(String lang, String resourceName, String ... params){
		InMemoryResourceBundle rb = InMemoryResourceBundle.getBundle("urlResource", new Locale(LANG_PARAM));
		
		StringBuilder url = new StringBuilder();
		String translationFormat = I18NTranslationHandler.getTranslationFormat(resourceName);
		String[] pathParts = translationFormat.split("/");
		
		int paramId = 0;
		for(String currPathPart : pathParts){
			if(StringUtils.isNotBlank(currPathPart)){
				url.append("/");
				if("{}".equals(currPathPart)){
					url.append(params[paramId]);
					paramId++;
				}
				else{
					url.append(rb.inverseLookup(currPathPart));
				}
			}
		}
		return url.toString();
	}
	
	/**
	 * Replace or add a query parameter to the provided uri.
	 * @param uri
	 * @param name
	 * @param value
	 * @return
	 */
	public static String replaceQueryParameter(String uri, String name, String value){
		UriComponentsBuilder bldr = UriComponentsBuilder.fromUriString(uri);
		bldr.replaceQueryParam(name, value);
		return bldr.build().toUriString();
	}
	
	/**
	 * Get an URI with a provided language as query parameter.
	 * Then parameter will be added or replaced.
	 * e.g. 
	 * -getUriWithLanguage("/search?q=cal","fr") will produce /search?q=cal&lang=fr
	 * -getUriWithLanguage("/search?q=cal&lang=en","fr") will produce /search?q=cal&lang=fr
	 * 
	 * @param uri
	 * @param lang
	 * @return
	 */
	public static String getUriWithLanguage(String uri, String lang){
		UriComponentsBuilder bldr = UriComponentsBuilder.fromUriString(uri);
		bldr.replaceQueryParam(LANG_PARAM,lang);
		return bldr.build().toUriString();
	}
	
	/**
	 * Get the mime type (e.g. image/x-png) of a file designed by a url(or not).
	 * @param url
	 * @return mime type image/jpeg text/html
	 */
	public static String getMimeFileType(String url){
		ConfigurableMimeFileTypeMap cmft = new ConfigurableMimeFileTypeMap();
		return cmft.getContentType(url);
	}
}

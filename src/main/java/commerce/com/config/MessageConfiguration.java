package commerce.com.config;


import net.rakugakibox.util.YamlResourceBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Slf4j
@Configuration
public class MessageConfiguration   implements WebMvcConfigurer {


    @Bean // 세션에 지역설정.
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.KOREAN);
        return slr;
    }

    @Bean // 지역설정을 변경하는 인터셉터. 요청시 파라미터에 lang 정보를 지정하면 언어가 변경됨.
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override // 인터셉터를 시스템 레지스트리에 등록
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean // yml 파일을 참조하는 MessageSource 선언
    public MessageSource messageSource(   @Value("${spring.messages.basename}") String basename,
                                          @Value("${spring.messages.encoding}") String encoding    ) {

		log.debug(" ****  [MessageSource ] basename :  " + basename + "  /  encoding :  " + encoding );

        YamlMessageSource ms = new YamlMessageSource();
        ms.setBasename(basename);
        ms.setDefaultEncoding(encoding);
        ms.setAlwaysUseMessageFormat(true);
        ms.setUseCodeAsDefaultMessage(true);
        ms.setFallbackToSystemLocale(true);
        return ms;
    }

    // locale 정보에 따라 다른 yml 파일을 읽도록 처리
    private static class YamlMessageSource extends ResourceBundleMessageSource {
        /*
    	@Override
        protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
            return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
        }
        */

        @Override
        protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
        	log.debug(" ****  [ResourceBundle ] basename :  " + basename + "  /  locale :  " + locale.getCountry() );
        	log.debug(" ****  locale.getCountry :  " + locale.getCountry() );
        	log.debug(" ****  locale.getDisplayLanguage :  " + locale.getDisplayLanguage() );
        	log.debug(" ****  locale.getLanguage :  " + locale.getLanguage() );

    		// =======================================================

        	log.debug("  :::::::::::::::::::::::::::::::::::::::::::::::::::::::::: " );

    	    List<Locale> localeList = new ArrayList<>();

            for (Locale locales : Locale.getAvailableLocales())
            {
                if ( (!locales.getLanguage().isEmpty())  && (!locales.getCountry().isEmpty()))
                {
                	localeList.add(locales);
                	log.debug("getLanguage : " + locales.getLanguage());
                	log.debug("getCountry : " + locales.getCountry());
                	log.debug("getDisplayName : " + locales.getDisplayName());
                	log.debug("getDisplayLanguage : " + locales.getDisplayLanguage());
                	log.debug("getDisplayCountry : " + locales.getDisplayCountry());
                	log.debug("------------------------");
                }
            }
            log.debug("locales total : " + Locale.getAvailableLocales().length + " / real locales size : " + localeList.size());
            log.debug(" ****   locales.getDefault() :  " + Locale.getDefault() );
            log.debug("  :::::::::::::::::::::::::::::::::::::::::::::::::::::::::: " );

    		// =======================================================


            return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
        }
    }



    /*
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**");
        //registry.addMapping("/").allowedOrigins("http://www.kma.go.kr").allowedMethods(HttpMethod.GET.name()).allowCredentials(false).allowedHeaders("Content-Type", "x-xsrf-token").maxAge(200);

    }
    */

}
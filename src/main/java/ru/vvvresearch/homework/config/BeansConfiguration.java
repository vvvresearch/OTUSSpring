package ru.vvvresearch.homework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.vvvresearch.homework.util.SimpleMessageSource;

import java.util.Locale;


@ComponentScan(basePackages = "ru.vvvresearch.homework")
@Configuration
@PropertySource("classpath:application.properties")
public class BeansConfiguration {

    @Bean
    @Autowired
    public MessageSource messageSource(Locale locale) {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/locales/messages");
        ms.setDefaultEncoding("UTF-8");
        SimpleMessageSource simpleMessageSrc = new SimpleMessageSource(ms, locale);
        return simpleMessageSrc;
    }

    @Bean
    Locale getLocale(@Value("${locale.key}")String localeKey, @Value("${country.key}") String countryKey) {
        return new Locale(localeKey, countryKey);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
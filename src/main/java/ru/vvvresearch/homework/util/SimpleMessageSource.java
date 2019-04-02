package ru.vvvresearch.homework.util;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

public class SimpleMessageSource implements MessageSource {
    private MessageSource messageSource;
    private Locale locale;

    public SimpleMessageSource(MessageSource source, Locale locale) {
        this.messageSource = source;
        this.locale = locale;
    }

    @Override
    public String getMessage(String s, Object[] objects, String s1, Locale locale) {
        if (s != null && locale == null)
            return messageSource.getMessage(s, objects, s1, this.locale);
        else
            return messageSource.getMessage(s, objects, s1, locale);
    }

    @Override
    public String getMessage(String s, Object[] objects, Locale locale) throws NoSuchMessageException {
        if (s != null && locale == null)
            return messageSource.getMessage(s, objects, this.locale);
        else
            return messageSource.getMessage(s, objects, locale);
    }

    @Override
    public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale) throws NoSuchMessageException {
        if (locale == null)
            return messageSource.getMessage(messageSourceResolvable, this.locale);
        else
            return messageSource.getMessage(messageSourceResolvable, locale);
    }
}

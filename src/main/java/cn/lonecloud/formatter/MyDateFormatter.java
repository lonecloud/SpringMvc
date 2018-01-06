package cn.lonecloud.formatter;

import cn.lonecloud.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.datetime.DateFormatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @author lonecloud
 * @version v1.0
 * @date 下午9:58 2018/1/5
 */
public class MyDateFormatter extends DateFormatter {

    private Logger logger = LoggerFactory.getLogger(DateFormatter.class);

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        Date date = DateUtils.Str2Date(text);
        return date;
    }
}

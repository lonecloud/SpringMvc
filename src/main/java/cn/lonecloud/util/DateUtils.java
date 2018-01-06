package cn.lonecloud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 日期转换工具类
 * @author lonecloud
 * @version v1.0
 * @date 下午10:06 2018/1/5
 */
public class DateUtils {

    private static Pattern DatePattern = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}.*");
    private static Pattern DatePattern2 = Pattern.compile("^[0-9]{4}-[0-9]{1}-[0-9]+.*||^[0-9]{4}-[0-9]+-[0-9]{1}.*");
    private static Pattern ShortDatePattern = Pattern.compile("^[0-9]{2}-[0-9]{2}-[0-9]{2}.*");
    private static Pattern ShortDatePattern2 = Pattern.compile("^[0-9]{2}-[0-9]{1}-[0-9]+.*||^[0-9]{2}-[0-9]+-[0-9]{1}.*");

    private static Pattern HourPattern = Pattern.compile(".*[ ][0-9]{2}");

    private static Pattern minutePattern = Pattern.compile(".*[ ][0-9]{2}:[0-9]{2}");

    private static Pattern secondPattern = Pattern.compile(".*[ ][0-9]{2}:[0-9]{2}:[0-9]{2}");

    private static Pattern smallSecondPattern = Pattern.compile(".*[ ][0-9]{2}:[0-9]{2}:[0-9]{2}:[0-9]{0,3}");

    /**
     * 将字符串转换成时间
     * @param dateStr
     * @return
     */
    public static Date Str2Date(String dateStr) {
        Date date = null;
        //缓存原始数据
        String temp = dateStr;

        if (!(null == dateStr || "".equals(dateStr))) {


            //判断是不是日期字符串，如Wed May 28 08:00:00 CST 2014

            if (dateStr.contains("CST")) {

                date = new Date(dateStr);

            } else {

                dateStr = dateStr.replace("年", "-").replace("月", "-").replace("日", "").replaceAll("/", "-").replaceAll("\\.", "-").trim();

                String fm = "";


                //确定日期格式

                if (DatePattern.matcher(dateStr).matches()) {

                    fm = "yyyy-MM-dd";

                } else if (DatePattern2.matcher(dateStr).matches()) {

                    fm = "yyyy-M-d";

                } else if (ShortDatePattern.matcher(dateStr).matches()) {

                    fm = "yy-MM-dd";

                } else if (ShortDatePattern2.matcher(dateStr).matches()) {

                    fm = "yy-M-d";

                }


                //确定时间格式

                if (HourPattern.matcher(dateStr).matches()) {

                    fm += " HH";

                } else if (minutePattern.matcher(dateStr).matches()) {

                    fm += " HH:mm";

                } else if (secondPattern.matcher(dateStr).matches()) {

                    fm += " HH:mm:ss";

                } else if (smallSecondPattern.matcher(dateStr).matches()) {

                    fm += " HH:mm:ss:sss";

                }


                if (!"".equals(fm)) {

                    try {

                        date = new SimpleDateFormat(fm).parse(dateStr);

                    } catch (ParseException e) {
                        throw new RuntimeException("参数字符串" + dateStr + "无法被转换为日期格式！");

                    }

                }

            }
        }
        return date;
    }
}

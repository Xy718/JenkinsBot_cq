package xyz.xy718.jenkinsbot.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONException;

public class JenkinsUtil {
    public static String getLastJob() throws JSONException, IOException, ParseException{
        String xml=HttpUtil.get("https://jenkins.xy718.xyz/job/CatislandWeb/view/default/rssLatest");
        Document docResult=XmlUtil.readXML(xml);
        String ret="最近的一次构建：";
        ret+="构建标题:"+ XmlUtil.getByXPath("//feed/entry/title", docResult, XPathConstants.STRING)+"\r\n";
        ret+="构建ID:"+ XmlUtil.getByXPath("//feed/id", docResult, XPathConstants.STRING)+"\r\n";
        ret+="构建详情:"+ XmlUtil.getElementByXPath("//feed/entry/link", docResult).getAttribute("href")+"\r\n";
        ret+="构建完成时间:"+ UTCToCST(XmlUtil.getByXPath("//feed/updated", docResult, XPathConstants.STRING).toString())+"\r\n";
        return ret;
    }
    public static String UTCToCST(String UTCStr) throws ParseException {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = sdf.parse(UTCStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        //calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳
        return sdf2.format(calendar.getTime());
    }
}
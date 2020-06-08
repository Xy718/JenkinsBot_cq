package xyz.xy718.jenkinsbot;

import java.io.IOException;
import java.text.ParseException;

import cc.moecraft.icq.event.Event;
import cc.moecraft.icq.event.EventHandler;
import cc.moecraft.icq.event.IcqListener;
import cc.moecraft.icq.event.events.message.EventGroupMessage;
import cc.moecraft.icq.sender.IcqHttpApi;
import cn.hutool.json.JSONException;
import xyz.xy718.jenkinsbot.util.JenkinsUtil;

public class TestListener extends IcqListener {
	@EventHandler // 这个注解必须加, 用于反射时判断哪些方法是事件方法的, 不用 @Override
    public void test(EventGroupMessage event) throws JSONException, IOException, ParseException{
		if(event.message.equals("#Last")) {
	        event.getHttpApi().sendGroupMsg(289617290, JenkinsUtil.getLastJob());
		}
    }

}

package xyz.xy718.jenkinsbot;

import cc.moecraft.icq.event.Event;
import cc.moecraft.icq.event.EventHandler;
import cc.moecraft.icq.event.IcqListener;
import cc.moecraft.icq.event.events.message.EventGroupMessage;
import cc.moecraft.icq.sender.IcqHttpApi;

public class TestListener extends IcqListener {
	@EventHandler // 这个注解必须加, 用于反射时判断哪些方法是事件方法的, 不用 @Override
    public void test(EventGroupMessage event) // 想监听什么事件就写在事件类名这里, 一个方法只能有一个事件参数
    {
        event.getHttpApi().sendGroupMsg(289617290, event.toString());
    }

}

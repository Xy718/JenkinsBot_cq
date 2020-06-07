package xyz.xy718.jenkinsbot;

import cc.moecraft.icq.PicqBotX;
import cc.moecraft.icq.PicqConfig;

public class JenkinsBot {
	
	public static void main(String[] args)
    {
		
        // 创建机器人对象 ( 传入配置 )
        PicqBotX bot = new PicqBotX(new PicqConfig(5701).setDebug(true));

        // 添加一个机器人账户 ( 名字, 发送URL, 发送端口 )
        bot.addAccount("Bot01", "127.0.0.1", 5700);

        // 注册事件监听器, 可以注册多个监听器
//        bot.getEventManager().registerListeners(
//                new TestListener()
//        );

        // 启动机器人, 不会占用主线程
        bot.startBot();
    }
}

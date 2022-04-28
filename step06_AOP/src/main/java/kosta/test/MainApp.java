package kosta.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.test.audio.AudioImpl;
import kosta.test.service.Player;
import kosta.test.tv.TvImpl;
import kosta.test.vedio.VedioImpl;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("kosta/test/applicationContext.xml");
		Player player = context.getBean("tv", Player.class);
		player.start(10);
		player.pause();
		player.stop();
		System.out.println("------------------");
		
		player = context.getBean("audio", Player.class);
		player.start(3);
		player.pause();
		player.stop();
		System.out.println("------------------");
		
		player = context.getBean("vedio", Player.class);
		player.start(5);
		player.pause();
		player.stop();
	}

}

package kosta.test.audio;

import kosta.test.service.Player;

public class AudioImpl implements Player {

	public void start(int volumn) {
		System.out.println(super.getClass().getName()+"의 start(int volumn) 호출");
	}

	public String pause() {
		System.out.println(super.getClass().getName()+"의 pause() 호출");
		return "안녕";
	}

	public void stop() {
		System.out.println(super.getClass().getName()+"의 stop() 호출");
	}

}

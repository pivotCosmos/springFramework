package kosta.test.audio;

import org.springframework.stereotype.Service;

import kosta.test.service.Player;

@Service("audio")
public class AudioImpl implements Player {

	public void start(int volumn) {
		System.out.println("AudioImpl start(int volumn) 호출");
	}

	public String pause() {
		System.out.println("AudioImpl pause() 호출");
		return "Audio pause리턴!!";
	}

	public void stop() {
		System.out.println("AudioImpl stop() 호출");
	}

}

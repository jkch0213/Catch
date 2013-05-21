package Client;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public enum SoundEffect {
	BGM("BGM.wav"),       // 기본 배경음악
	ROOM("Room.wav");		// 방에 입장했을대 배경음악


	public static enum Volume {
		MUTE, LOW, MEDIUM, HIGH
	}

	public static Volume volume = Volume.LOW;
	private Clip clip;

	SoundEffect(String soundFileName) {
		try {
			URL url = this.getClass().getClassLoader().getResource(soundFileName);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	public void play() {
		if (volume != Volume.MUTE) {
			if (clip.isRunning())
				clip.stop(); 
			clip.setFramePosition(0);
			clip.start();
			clip.loop(100);
		}
	}
	public static void init() {
		values();
	}
	public void stop() {
		clip.stop();
	}
}



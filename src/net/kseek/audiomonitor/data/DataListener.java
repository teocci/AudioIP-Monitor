package net.kseek.audiomonitor.data;

import java.awt.image.BufferedImage;

public interface DataListener {
	void onDirtyVideo(BufferedImage bufferedImage);
	void onDirtyAudio(BufferedImage bufferedImage);
}

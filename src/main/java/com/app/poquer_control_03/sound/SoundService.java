package com.app.poquer_control_03.sound;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

@Service
public class SoundService {

    @Value("${sound-filename}")
    String soundFilename;

    public void play() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        final File file = new ClassPathResource(soundFilename).getFile();
        final AudioInputStream input = AudioSystem.getAudioInputStream(file);
        final AudioFormat baseFormat = input.getFormat();
        final int channels = baseFormat.getChannels();
        final float sampleRate = baseFormat.getSampleRate();

        final AudioFormat decodedFormat = new AudioFormat(PCM_SIGNED, sampleRate, 16, channels, channels * 2,
                sampleRate, false);

        final AudioInputStream din = AudioSystem.getAudioInputStream(decodedFormat, input);
        final DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);
        final SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        line.open(decodedFormat);
        byte[] data = new byte[4096];
        line.start();
        int nBytesRead;

        while ((nBytesRead = din.read(data, 0, data.length)) != -1) {
            line.write(data, 0, nBytesRead);
        }

        line.drain();
        line.stop();
        line.close();
        din.close();
    }
}

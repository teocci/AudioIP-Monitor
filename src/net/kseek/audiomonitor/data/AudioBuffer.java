package net.kseek.audiomonitor.data;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

public class AudioBuffer {

    private int totalLength = 0;
    private final int frameLength;
    private ByteArrayOutputStream byteArrayOutputStream;

    public AudioBuffer(int frameLgth) {
        byteArrayOutputStream = new ByteArrayOutputStream();
        frameLength = frameLgth;
        //System.out.println("AudioBuffer: Width x Height --> " + w + "x" + h);
    }
    
    public int fillBuffer(byte[] data, int off, int len, LinkedList<byte[]> WAVQueue) {
        totalLength += len;
        byteArrayOutputStream.write(data, off, len);
        
        if (totalLength == frameLength) {
            
            synchronized (WAVQueue) {
                WAVQueue.add(byteArrayOutputStream.toByteArray());
            	byteArrayOutputStream.reset();
            }
            
            totalLength = 0;
            System.out.println("received file");
        }
        
        return 0;
    }
}

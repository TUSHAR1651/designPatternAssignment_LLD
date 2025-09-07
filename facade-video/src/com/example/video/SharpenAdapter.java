package com.example.video;

import java.util.Arrays;
public class SharpenAdapter {
    private final LegacySharpen legacy = new LegacySharpen();
    // Here we will be returning the same frames but the applySharpen must return the Frame[]
    public Frame[] sharpen(Frame[] frames, int strength) {
        String handle = Arrays.toString(frames);
        String newHandle = legacy.applySharpen(handle, strength);
        System.out.println("Sharpen applied via legacy: " + newHandle);
        return frames;
    }
}   

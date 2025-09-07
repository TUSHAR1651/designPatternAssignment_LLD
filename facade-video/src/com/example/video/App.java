package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VideoPipelineFacade facade = new VideoPipelineFacade(
                new Decoder(),
                new FilterEngine(),
                new Encoder(),
                new SharpenAdapter()
        );

        Path out = facade.process(
                Path.of("in.mp4"),
                Path.of("out.mp4"),
                true,
                0.5,
                3
        );

        System.out.println("DONE " + out);
    }
}

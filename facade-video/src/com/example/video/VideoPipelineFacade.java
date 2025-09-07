package com.example.video;
import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {

    private final Decoder decoder;
    private final FilterEngine filter;
    private final Encoder encoder;
    private final SharpenAdapter sharpenAdapter;


    public VideoPipelineFacade(Decoder decoder, FilterEngine filter, Encoder encoder, SharpenAdapter sharpenAdapter) {
        this.decoder = decoder;
        this.filter = filter;
        this.encoder = encoder;
        this.sharpenAdapter = Objects.requireNonNull(sharpenAdapter);
    }

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");

        Frame[] frames = decoder.decode(src);
        System.out.println("Decoded " + frames.length + " frames");

        if (gray) {
            frames = filter.grayscale(frames);
            System.out.println("Applied grayscale");
        }
        if (scale != null) {
            frames = filter.scale(frames, scale);
            System.out.println("Applied scale " + scale);
        }
        if (sharpenStrength != null) {
            frames = sharpenAdapter.sharpen(frames, sharpenStrength);
        }

        Path result = encoder.encode(frames, out);
        System.out.println("Wrote " + result);
        return result;
    }

}

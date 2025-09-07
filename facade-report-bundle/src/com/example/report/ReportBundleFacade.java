package com.example.report;

import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private final JsonWriter jsonWriter;
    private final Zipper zipper;
    private final AuditLog auditLog;

    public ReportBundleFacade(JsonWriter jsonWriter, Zipper zipper, AuditLog auditLog) {
        this.jsonWriter = Objects.requireNonNull(jsonWriter, "jsonWriter");
        this.zipper = Objects.requireNonNull(zipper, "zipper");
        this.auditLog = Objects.requireNonNull(auditLog, "auditLog");
    }

    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");

        try {
            Path jsonFile = jsonWriter.write(data, outDir, baseName);

            Path zipFile = zipper.zip(jsonFile, outDir.resolve(baseName + ".zip"));

            auditLog.log("exported " + zipFile);

            return zipFile;
        } catch (UncheckedIOException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error in export", e);
        }
    }
}

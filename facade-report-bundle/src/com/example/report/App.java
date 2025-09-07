package com.example.report;

import java.nio.file.Path;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ReportBundleFacade facade = new ReportBundleFacade(
            new JsonWriter(),
            new Zipper(),
            new AuditLog()
        );
        Path outDir = Path.of("out");
        Path zip = facade.export(
            Map.of("hello", "world", "foo", 42),
            outDir,
            "report1"
        );
        System.out.println("Bundle created at: " + zip);
    }
}

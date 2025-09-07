package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader reader;
    private final ProfileService service;

    public CsvProfileImporter(NaiveCsvReader reader, ProfileService service) {
        this.reader = reader;
        this.service = service;
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = reader.read(csvFile);
        int count = 0;

        // Expect header row: id,email,displayName
        boolean first = true;
        for (String[] row : rows) {
            if (first) { 
                first = false; 
                continue; 
            }

            if (row.length < 2) {
                System.out.println("Skipping row (not enough columns): " + String.join(",", row));
                continue;
            }

            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row.length > 2 ? row[2].trim() : "";

            if (id.isEmpty()) {
                System.out.println("Skipping row (missing id): " + String.join(",", row));
                continue;
            }
            if (email.isEmpty() || !email.contains("@")) {
                System.out.println("Skipping row (invalid email): " + String.join(",", row));
                continue;
            }

            try {
                service.createProfile(id, email, displayName);
                count++;
            } catch (Exception e) {
                System.out.println("Skipping row (error: " + e.getMessage() + "): " + String.join(",", row));
            }
        }

        return count;
    }
}

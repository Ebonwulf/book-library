package com.nology.booklibrary;
import java.io.*;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


public class CsvConverter extends BookLibraryApplication{
    public static void main(String[] args) {
    }

    public void convertToJSON() throws FileNotFoundException {
        File csvInput = new File("src/main/java/com/nology/booklibrary/books_data.csv");
        File jsonOutput = new File("src/main/java/com/nology/booklibrary/books_data.json");

        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();


        try {
            List<Map<?, ?>> list;
            try (MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader()
                    .forType(Map.class)
                    .with(csvSchema)
                    .readValues(csvInput)) {
                list = mappingIterator.readAll();
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(list);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



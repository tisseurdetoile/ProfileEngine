package net.tisseurdetoile.profileEngine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Hello World!");

        Reader in = new FileReader("./data/Teams.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        for (CSVRecord record : records) {
            System.out.println(record.toString());
        }

    }
}

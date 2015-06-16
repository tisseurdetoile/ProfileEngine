package net.tisseurdetoile.profileEngine;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Hello world!
 *
 */
public class ParseCSV {

    private static final Logger LOG = Logger.getLogger("App");

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Monitor mon = MonitorFactory.start("myFirstMonitor");
        Monitor monParse = MonitorFactory.start("parse");

        System.out.println("Hello World!");
        
        Reader in = new FileReader("./data/data.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').withHeader().parse(in);

        for (CSVRecord record : records) {
            monParse.start();
            System.out.println(record.toString());
            monParse.stop();
        }

        mon.stop();
        monParse.stop();
        System.out.println(mon);
        System.out.println(monParse);
    }
}

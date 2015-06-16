package net.tisseurdetoile.profileEngine;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import net.tisseurdetoile.profileEngine.engine.simple.AbstractHashSpecification;
import net.tisseurdetoile.profileEngine.engine.simple.specification.AttributeValueIs;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Hello world!
 *
 */
public class ParseCSVsimpleEngine {

    private static Map<String, AbstractHashSpecification> getSpecifications() {

        AbstractHashSpecification secteurPublic = new AttributeValueIs("SECTEUR", "PU");
        AbstractHashSpecification secteurPrive = new AttributeValueIs("SECTEUR", "PU");

        Map<String, AbstractHashSpecification> specs = new HashMap<String, AbstractHashSpecification>();

        return specs;

    }

    private static final Logger LOG = Logger.getLogger("App");

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Monitor mon = MonitorFactory.start("myFirstMonitor");
        Monitor monParse = MonitorFactory.start("parse");

        System.out.println("Hello World!");

        Reader in = new FileReader("./data/data.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').withHeader().parse(in);

        for (CSVRecord record : records) {
            monParse.start();

            Map<String, String> datas = new HashMap<String, String>();

            datas.put("ETAB", record.get("Etablissement"));
            datas.put("SECTEUR", record.get("Secteur Public=1 Prive=2"));
            datas.put("DEPT", record.get("Departement"));
            datas.put("TBRP", record.get("Taux Brut de Reussite Production"));
            datas.put("TBRS", record.get("Taux Brut de Reussite Services"));

            datas.put("EFF_S", record.get("Effectif de seconde"));
            datas.put("EFF_P", record.get("Effectif de premiere"));
            datas.put("COMMUNE", record.get("Commune"));

            datas.put("TBRSS", record.get("Taux Brut de Reussite Total secteurs"));
            
            System.out.println(datas.toString());
            monParse.stop();
        }

        mon.stop();
        monParse.stop();
        System.out.println(mon);
        System.out.println(monParse);
    }
}

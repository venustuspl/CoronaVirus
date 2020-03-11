package pl.venustus.CoronaVirus;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class Csv {

    public Map<String, Integer> downloadCsv() throws IOException {
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        System.out.println(day);
        InputStream input = new URL("https://www.ecdc.europa.eu/sites/default/files/documents/COVID-19-geographic-disbtribution-worldwide-2020-0" + month + "-" + day + ".xls").openStream();

        Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8);

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withSkipHeaderRecord().parse(reader);

        Map<String, Integer> countryMap = new HashMap<>();

        for (CSVRecord entry : records) {
            countryMap.put(entry.get(1), Integer.valueOf(entry.get(2)));
            day++;
        }
        System.out.println(day);
        return countryMap;

    }
}

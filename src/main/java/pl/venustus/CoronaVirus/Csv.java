package pl.venustus.CoronaVirus;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;

import static pl.venustus.CoronaVirus.ExcelDateReader.readFromCSV_4_COMS;

@Service
public class Csv {

    public static void main(String[] args) throws IOException {
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        System.out.println(day);
        InputStream input = new URL("https://www.ecdc.europa.eu/sites/default/files/documents/COVID-19-geographic-disbtribution-worldwide-2020-0" + month + "-" + day + ".xls").openStream();

        //   Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
//
//        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withSkipHeaderRecord().parse(reader);
//
//        Map<String, Integer> countryMap = new HashMap<>();

//        for (CSVRecord entry : records) {
//            countryMap.put(entry.get(1), Integer.valueOf(entry.get(2)));
//            day++;
//        }
//        System.out.println(day);
//        return countryMap;

        readFromCSV_4_COMS(input);

    }
}

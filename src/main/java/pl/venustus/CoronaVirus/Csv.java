package pl.venustus.CoronaVirus;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import static pl.venustus.CoronaVirus.ExcelDateReader.readFromCSV_4_COMS;
import static pl.venustus.CoronaVirus.ExcelDateReader.readPolandFromCSV_4_COMS;

@Service
public class Csv {

    public List<CountryDto> downloadCsv() throws IOException {
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        String monthString = month < 10 ? "0" + month : String.valueOf(month);
        String dayString = day < 10 ? "0" + day : String.valueOf(day);
        int year = LocalDate.now().getYear();
        System.out.println(year + " " + monthString + " " + dayString);
        InputStream input;
        try {
            input = new URL("https://www.ecdc.europa.eu/sites/default/files/documents/COVID-19-geographic-disbtribution-worldwide-" + year + "-" + monthString + "-" + dayString + ".xlsx").openStream();
        } catch (IOException e) {
            return null;
        }
        return readFromCSV_4_COMS(input);

    }

    public List<CountryDto> downloadArchiveCsv(String year, int month, int day) throws IOException {
        String monthString = month < 10 ? "0" + month : String.valueOf(month);
        String dayString = day < 10 ? "0" + day : String.valueOf(day);
        InputStream input;
        try {
            input = new URL("https://www.ecdc.europa.eu/sites/default/files/documents/COVID-19-geographic-disbtribution-worldwide-" + year + "-" + monthString + "-" + dayString + ".xlsx").openStream();
            //                        https://www.ecdc.europa.eu/sites/default/files/documents/COVID-19-geographic-disbtribution-worldwide-2020-03-23.xlsx
        } catch (IOException e) {
            return null;
        }
        return readFromCSV_4_COMS(input);

    }

    public CountryDto downloadArchivePolandCsv(String year, int month, int day) throws IOException {
        String monthString = month < 10 ? "0" + month : String.valueOf(month);
        String dayString = day < 10 ? "0" + day : String.valueOf(day);
        InputStream input;
        try {
            input = new URL("https://www.ecdc.europa.eu/sites/default/files/documents/COVID-19-geographic-disbtribution-worldwide-" + year + "-" + monthString + "-" + dayString + ".xlsx").openStream();
        } catch (IOException e) {
            return null;
        }
        return readPolandFromCSV_4_COMS(input);

    }
}

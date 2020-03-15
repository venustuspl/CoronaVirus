package pl.venustus.CoronaVirus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class CsvController {

    @Autowired
    Csv csv;

    @RequestMapping(method = RequestMethod.GET, value = "/alldata")
    public List<CountryDto> showRecords() throws IOException {

        return csv.downloadCsv();
    }

    //http://localhost:8080/archivedata?year=2020&month=03&day=14
    @RequestMapping(method = RequestMethod.GET, value = "/archivedata")
    public List<CountryDto> showArchiveRecords(@RequestParam(value = "year") String year, @RequestParam(value = "month") int month, @RequestParam(value = "day") int day) throws IOException {

        return csv.downloadArchiveCsv(year, month, day);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/archivepolanddata")
    public CountryDto showArchivePolandRecords(@RequestParam(value = "year") String year, @RequestParam(value = "month") int month, @RequestParam(value = "day") int day) throws IOException {

        return csv.downloadArchivePolandCsv(year, month, day);
    }
//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }
}

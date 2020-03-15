package pl.venustus.CoronaVirus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class CsvController {

    @Autowired
    Csv csv;

    @RequestMapping(method = RequestMethod.GET, value = "/alldata")
    public Map<String, Double> showRecords() throws IOException {

        return csv.downloadCsv();
    }

    //http://localhost:8080/archivedata?year=2020&month=03&day=14
    @RequestMapping(method = RequestMethod.GET, value = "/archivedata")
    public Map<String, Double> showArchiveRecords(@RequestParam(value = "year") String year, @RequestParam(value = "month") int month, @RequestParam(value = "day") int day) throws IOException {

        return csv.downloadArchiveCsv(year, month, day);
    }

//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }
}

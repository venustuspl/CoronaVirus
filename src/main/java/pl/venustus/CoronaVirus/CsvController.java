package pl.venustus.CoronaVirus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class CsvController {
    @Autowired
    Csv csv;


    @RequestMapping(method = RequestMethod.GET, value = "/alldata")
    public Map<String, Double> showRecords() throws IOException {

        return csv.downloadCsv();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/archivedata/{year}{month}{day}")
    public Map<String, Double> showArchiveRecords(@RequestParam String year, @RequestParam int month, @RequestParam int day) throws IOException {

        return csv.downloadArchiveCsv(year, month, day);
    }
}

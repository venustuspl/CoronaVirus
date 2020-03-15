package pl.venustus.CoronaVirus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}

package pl.venustus.CoronaVirus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class CsvController {
    @Autowired
    Csv csv;

    @GetMapping("/showRecords")
    public void showRecords() throws IOException {
       // csv.downloadCsv();
    }
}

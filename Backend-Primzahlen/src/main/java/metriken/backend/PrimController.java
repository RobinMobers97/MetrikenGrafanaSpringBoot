package metriken.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PrimController {

    @Autowired
    PrimService primService;

    @RequestMapping("/setPrim")
    public boolean setPrim(@RequestParam(value="limit") int limit){
        primService.setPrimList(limit);
        return true;
    }

    @RequestMapping("/getPrim")
    public ArrayList<Integer> getPrim() {
        return primService.getPrimList();
    }



}

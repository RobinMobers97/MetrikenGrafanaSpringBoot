package metriken.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FibonacciController {

    @Autowired
    FibonacciService fibonacciService;

    @RequestMapping("/setFibonacci")
    public boolean setFibonacci(@RequestParam(value="limit") int limit){
        fibonacciService.setFibonacciList(limit);
        return true;
    }

    @RequestMapping("/getFibonacci")
    public ArrayList<Integer> getFibonacci() {
        return fibonacciService.getFibonacciList();
    }



}

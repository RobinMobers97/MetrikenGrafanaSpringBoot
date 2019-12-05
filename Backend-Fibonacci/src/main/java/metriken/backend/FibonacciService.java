package metriken.backend;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FibonacciService {
    private ArrayList<Integer> fibonacciList = new ArrayList<>();
    private AtomicInteger listSizeFibonacci;

    private final MeterRegistry meterRegistry;

    private Counter setFibonacciLists;

    @Autowired
    public FibonacciService(final MeterRegistry meterRegistry){
        this.meterRegistry = meterRegistry;
        listSizeFibonacci = new AtomicInteger(0);
        this.setFibonacciLists = this.meterRegistry.counter("fibonacciService", "setFibonacciList", "Counter");
        this.meterRegistry.gauge("fibonacciListSize", listSizeFibonacci);
    }

    @Timed(description = "Time spend setFibonacciList")
    public void setFibonacciList(int limit){
        setFibonacciLists.increment();
        fibonacciList = new ArrayList<>();
        int a = 0;
        int b = 1;
        int n = 0;
        while(n <= limit){
            n = a + b;
            a = b;
            b = n;
            fibonacciList.add(n);
        }
        listSizeFibonacci.set(fibonacciList.size());
    }

    public ArrayList<Integer> getFibonacciList(){
        return fibonacciList;
    }
}

package metriken.backend;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PrimService {
    private ArrayList<Integer> primList = new ArrayList<>();
    private AtomicInteger listSizePrim;

    private final MeterRegistry meterRegistry;

    private Counter setPrimLists;

    @Autowired
    public PrimService(final MeterRegistry meterRegistry){
        this.meterRegistry = meterRegistry;
        listSizePrim = new AtomicInteger(0);
        this.setPrimLists = this.meterRegistry.counter("primService", "setPrimList", "Counter");
        this.meterRegistry.gauge("primListSize", listSizePrim);
    }

    @Timed(description = "Time spent setPrimList")
    public void setPrimList(int limit){
        setPrimLists.increment();
        primList = new ArrayList<>();
        primList.add(1);
        int zahl;
        int zaehler;
        boolean primzahl;

        for (zahl = 2; zahl <= limit; zahl++) {
            primzahl = true;
            for (zaehler = 2; zaehler < Math.sqrt(zahl) + 1; zaehler++) {
                if (zahl % zaehler == 0) {
                    primzahl = false;
                    break;
                }
            }
            if (primzahl) {
                primList.add(zahl);
            }
        }
        listSizePrim.set(primList.size());
    }

    public ArrayList<Integer> getPrimList(){
        return primList;
    }
}

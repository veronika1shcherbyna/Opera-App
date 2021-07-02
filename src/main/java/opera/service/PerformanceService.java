package opera.service;

import java.util.List;
import opera.model.Performance;

public interface PerformanceService {
    Performance add(Performance performance);

    Performance get(Long id);

    List<Performance> getAll();
}

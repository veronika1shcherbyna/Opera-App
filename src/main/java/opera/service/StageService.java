package opera.service;

import java.util.List;
import opera.model.Stage;

public interface StageService {
    Stage add(Stage stage);

    Stage get(Long id);

    List<Stage> getAll();
}

package opera.service.impl;

import java.util.List;
import opera.dao.StageDao;
import opera.exception.DataProcessingException;
import opera.model.Stage;
import opera.service.StageService;
import org.springframework.stereotype.Service;

@Service
public class StageServiceImpl implements StageService {
    private final StageDao stageDao;

    public StageServiceImpl(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageDao.add(stage);
    }

    @Override
    public Stage get(Long id) {
        return stageDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get stage by id " + id));
    }

    @Override
    public List<Stage> getAll() {
        return stageDao.getAll();
    }
}

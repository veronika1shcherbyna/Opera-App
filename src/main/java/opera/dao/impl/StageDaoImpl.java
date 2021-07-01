package opera.dao.impl;

import opera.dao.AbstractDao;
import opera.dao.StageDao;
import opera.model.Stage;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StageDaoImpl extends AbstractDao<Stage> implements StageDao {
    public StageDaoImpl(SessionFactory factory) {
        super(factory, Stage.class);
    }
}

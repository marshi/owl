package marshi.owl.datasource.rdb.repository;

import marshi.owl.datasource.rdb.mapper.SequenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by a13178 on 2017/04/21.
 *
 */
@Repository
public class SequenceRepository {

    @Autowired
    private SequenceMapper mapper;

    public Long nextId() {
        SequenceMapper.Property property = new SequenceMapper.Property();
        mapper.nextId(property);
        return property.getId();
    }

}

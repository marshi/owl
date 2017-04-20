package marshi.owl.datasource.rdb.mapper;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

/**
 * Created by a13178 on 2017/04/21.
 */
public interface SequenceMapper {

    @Update("update ticket_sequence set id = LAST_INSERT_ID(id+1)")
    @SelectKey(statement = "select LAST_INSERT_ID()", resultType = Long.class, keyProperty = "id", before = false)
    void nextId(Property property);

    @Getter
    @Setter
    public class Property {
        private Long id;
    }

}

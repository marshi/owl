package marshi.owl.datasource.graph.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * Created by a13178 on 2017/04/17.
 */
@NodeEntity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

    @GraphId
    public Long id;

    @Relationship(type = "path")
    public Set<Ticket> nextStepTickets;

    public Long projectId;

    public String title;

    public Integer assigneeId;

    public String content;

}

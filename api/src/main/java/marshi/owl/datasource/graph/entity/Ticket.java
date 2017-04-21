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
    private Long id;

    @Relationship(type = "path")
    private Set<Ticket> nextStepTickets;

    private Long projectId;

    private String title;

    private Integer assigneeId;

    private String content;

    public Ticket(Long id, Set<Ticket> nextStepTickets, Long projectId, String title, Integer assigneeId, String content) {
        this.id = id;
        this.nextStepTickets = nextStepTickets;
        this.projectId = projectId;
        this.title = title;
        this.assigneeId = assigneeId;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Set<Ticket> getNextStepTickets() {
        return nextStepTickets;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getAssigneeId() {
        return assigneeId;
    }

    public String getContent() {
        return content;
    }
}

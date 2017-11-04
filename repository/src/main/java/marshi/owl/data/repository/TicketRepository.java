package marshi.owl.data.repository;

import lombok.NoArgsConstructor;
import lombok.val;
import marshi.owl.data.rdb.entity.TicketExample;
import marshi.owl.data.rdb.mapper.TicketMapper;
import marshi.owl.domain.entity.Project;
import marshi.owl.domain.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by a13178 on 2017/04/15.
 */
@Repository
public class TicketRepository {

    private final TicketMapper ticketMapper;

    @Autowired
    public TicketRepository(TicketMapper ticketMapper) {
        this.ticketMapper = ticketMapper;
    }

    public void create(marshi.owl.domain.entity.Ticket ticket) {
        ticketMapper.insertSelective(convert(ticket));
    }

    public List<Ticket> list()  {
        val result = ticketMapper.selectByExample(new TicketExample());
        return result.stream().map(this::convertFrom).collect(Collectors.toList());
    }

    private static marshi.owl.data.rdb.entity.Ticket convert(marshi.owl.domain.entity.Ticket ticket) {
        marshi.owl.data.rdb.entity.Ticket ticketRecord = new marshi.owl.data.rdb.entity.Ticket();
        ticketRecord.setId(ticket.getId());
        ticketRecord.setAssigneeId(ticket.getAssigneeId());
        ticketRecord.setContent(ticket.getContent());
        ticketRecord.setTitle(ticket.getTitle());
        ticketRecord.setProjectId(ticket.getProjectId());
        return ticketRecord;
    }

    private Ticket convertFrom(marshi.owl.data.rdb.entity.Ticket t) {
        return new Ticket(
                t.getId(),
                t.getTitle(),
                t.getContent(),
                t.getProjectId(),
                t.getAssigneeId(),
                null
        );

    }
}


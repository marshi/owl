package marshi.owl.data.repository;

import lombok.val;
import marshi.owl.data.rdb.entity.TicketRecord;
import marshi.owl.data.rdb.entity.TicketRecordExample;
import marshi.owl.data.rdb.mapper.TicketRecordMapper;
import marshi.owl.domain.entity.Ticket;
import marshi.owl.domain.repository.TicketRepositoryInterface;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by a13178 on 2017/04/15.
 */
@Repository
public class TicketRepository implements TicketRepositoryInterface {

    private final TicketRecordMapper ticketMapper;

    @Autowired
    public TicketRepository(TicketRecordMapper ticketMapper) {
        this.ticketMapper = ticketMapper;
    }

    @Override
    public void create(@NotNull Ticket ticket) {
        ticketMapper.insertSelective(convert(ticket));
    }

    @NotNull
    @Override
    public List<Ticket> list()  {
        val result = ticketMapper.selectByExample(new TicketRecordExample());
        return result.stream().map(this::convertFrom).collect(Collectors.toList());
    }

    @NotNull
    @Override
    public Optional<Ticket> find(long id) {
        TicketRecord ticketRecord = ticketMapper.selectByPrimaryKey(id);
        return Optional.ofNullable(ticketRecord).map(this::convertFrom);
    }

    private static TicketRecord convert(Ticket ticket) {
        TicketRecord ticketRecord = new TicketRecord();
        ticketRecord.setId(ticket.getId());
        ticketRecord.setAssigneeId(ticket.getAssigneeId());
        ticketRecord.setContent(ticket.getContent());
        ticketRecord.setTitle(ticket.getTitle());
        ticketRecord.setProjectId(ticket.getProjectId());
        return ticketRecord;
    }

    private Ticket convertFrom(TicketRecord t) {
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


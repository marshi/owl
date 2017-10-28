package marshi.owl.datasource.rdb.repository

import marshi.owl.datasource.rdb.entity.TicketExample
import marshi.owl.entity.TicketModel
import marshi.owl.datasource.rdb.mapper.TicketMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.streams.toList

/**
 * Created by a13178 on 2017/04/15.
 */
@Repository
class TicketRepository(
        @Autowired val ticketMapper: TicketMapper
) {

    fun create(ticketModel: TicketModel) {
        val ticket = ticketModel.convertToRecord()
        ticketMapper.insertSelective(ticket)
    }

    fun list(): List<TicketModel> {
        val result = ticketMapper.selectByExample(TicketExample());
        return result.stream().map { t -> TicketModel.convertFromRecord(t) }.toList()
    }

}
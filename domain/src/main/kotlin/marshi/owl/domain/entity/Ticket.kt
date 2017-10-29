package marshi.owl.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.NoArgsConstructor
import lombok.Setter

/**
 * Created by a13178 on 2017/04/17.
 */
@NoArgsConstructor
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Ticket(
        var id: Long? = null,
        var title: String? = null,
        var content: String? = null,
        var projectId: Long? = null,
        var assigneeId: Int? = null,
        var nextStepTickets: Set<Ticket>? = mutableSetOf()
)




package marshi.owl.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
class Ticket(
    var id: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var projectId: Long? = null,
    var assigneeId: Int? = null,
    var deadline: Date? = null
)




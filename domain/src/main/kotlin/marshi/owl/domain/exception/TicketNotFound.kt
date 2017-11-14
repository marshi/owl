package marshi.owl.domain.exception

class TicketNotFound(message: String = "", cause: Throwable? = null) :
    DomainException(message, cause)

package marshi.owl.web.view.ticket.register

import marshi.owl.web.repository.project.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.servlet.ModelAndView

@Service
class TicketRegisterFacade(
    @Autowired private val projectRepository: ProjectRepository
) {

    fun registerForm(): ModelAndView {
        val modelAndView = ModelAndView("/ticket_register")
        val projects = projectRepository.list()
        modelAndView.addObject("projects", projects)
        return modelAndView
    }

}
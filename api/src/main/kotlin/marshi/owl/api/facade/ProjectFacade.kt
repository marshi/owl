package marshi.owl.api.facade

import marshi.owl.data.repository.ProjectRepository
import marshi.owl.domain.entity.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.servlet.ModelAndView

@Service
class ProjectFacade(
    @Autowired private val projectRepository: ProjectRepository
) {

    fun list(): List<Project> {
        return projectRepository.list()
    }

    fun create(project: Project) {
        projectRepository.create(project)
    }

}
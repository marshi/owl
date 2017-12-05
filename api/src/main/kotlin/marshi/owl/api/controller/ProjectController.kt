package marshi.owl.api.controller

import marshi.owl.api.facade.ProjectFacade
import marshi.owl.apiresponse.project.ProjectListResponse
import marshi.owl.domain.entity.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/projects")
class ProjectController(
    @Autowired private val projectFacade: ProjectFacade
) {

    @RequestMapping(method = [(RequestMethod.GET)])
    fun list(): ProjectListResponse {
        val list = projectFacade.list()
        return ProjectListResponse(list, null)
    }

    @RequestMapping(method = [(RequestMethod.POST)])
    fun create(
        @RequestBody project: Project
    ) {
        projectFacade.create(project)
    }

}
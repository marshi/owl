package marshi.owl.data.repository;

import marshi.owl.data.rdb.entity.ProjectExample;
import marshi.owl.data.rdb.mapper.ProjectMapper;
import marshi.owl.domain.entity.Project;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProjectRepository {

	private ProjectMapper projectMapper;

	ProjectRepository(@Autowired ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	public List<Project> list() {
		List<marshi.owl.data.rdb.entity.Project> list =
				projectMapper.selectByExample(new ProjectExample());
		return list.stream()
				.map(ProjectRepository::convertFrom)
				.collect(Collectors.toList());
	}

	public void create(@NotNull Project project) {
		projectMapper.insertSelective(convert(project));
	}

	private static Project convertFrom(marshi.owl.data.rdb.entity.Project p) {
		return new Project(
				p.getId(),
				p.getName()
		);
	}

	private static marshi.owl.data.rdb.entity.Project convert(Project p) {
		marshi.owl.data.rdb.entity.Project project = new marshi.owl.data.rdb.entity.Project();
		project.setId(p.getId());
		project.setName(p.getName());
		return project;
	}

}

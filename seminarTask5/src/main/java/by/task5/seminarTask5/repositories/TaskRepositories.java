package by.task5.seminarTask5.repositories;

import by.task5.seminarTask5.model.Task;
import by.task5.seminarTask5.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepositories extends JpaRepository<Task, Long> {
    public List<Task> findByStatus(Status status);
}

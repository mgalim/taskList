package TaskList.repository;

import TaskList.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ITaskRespository extends JpaRepository<Task,Long> {

    List<Task> findByEmployeeId(Long id);

    @Transactional
    void deleteByEmployeeId(Long Id);
}

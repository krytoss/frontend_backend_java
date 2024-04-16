package sk.krytoss.rest.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.krytoss.rest.todo.model.Task;
import sk.krytoss.rest.todo.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task updateTask(Long taskId, Task taskDetails) {
        Task task = taskRepository.findById(taskId).get();
        task.setTask(taskDetails.getTask());
        task.setCompleted(taskDetails.getCompleted());
        task.setDeleted(taskDetails.getDeleted());

        return taskRepository.save(task);
    }

}

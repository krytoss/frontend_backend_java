package sk.krytoss.rest.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.krytoss.rest.todo.model.Task;
import sk.krytoss.rest.todo.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value="/tasks", method=RequestMethod.POST)
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @RequestMapping(value="/tasks", method=RequestMethod.GET)
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @RequestMapping(value="/tasks/{taskId}", method=RequestMethod.PUT)
    public Task updateTask(@PathVariable(value = "id") Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @RequestMapping(value="/tasks/{taskId}", method=RequestMethod.DELETE)
    public void deleteTask(@PathVariable(value = "id") Long id) {
        taskService.deleteTask(id);
    }
}

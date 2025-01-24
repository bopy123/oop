package projectmanagement;
import java.util.ArrayList;
import java.util.List;

abstract class Task {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute();
}

class DevelopmentTask extends Task {
    public DevelopmentTask(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("Executing development task: " + getName());
    }
}

class TestingTask extends Task {
    public TestingTask(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("Executing testing task: " + getName());
    }
}

class DocumentationTask extends Task {
    public DocumentationTask(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("Executing documentation task: " + getName());
    }
}

interface TaskCreator {
    Task createTask(String name);
}

class DevelopmentTaskCreator implements TaskCreator {
    @Override
    public Task createTask(String name) {
        return new DevelopmentTask(name);
    }
}

class TestingTaskCreator implements TaskCreator {
    @Override
    public Task createTask(String name) {
        return new TestingTask(name);
    }
}

class DocumentationTaskCreator implements TaskCreator {
    @Override
    public Task createTask(String name) {
        return new DocumentationTask(name);
    }
}

// Клас Project (Creator Method)
class Project {
    private String name;
    private List<Task> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(TaskCreator creator, String taskName) {
        Task task = creator.createTask(taskName);
        tasks.add(task);
    }

    public void executeAllTasks() {
        System.out.println("Executing tasks for project: " + name);
        for (Task task : tasks) {
            task.execute();
        }
    }
}

public class ProjectManagementSystem {
    public static void main(String[] args) {
        Project project = new Project("New Project");

        TaskCreator devCreator = new DevelopmentTaskCreator();
        TaskCreator testCreator = new TestingTaskCreator();
        TaskCreator docCreator = new DocumentationTaskCreator();

        project.addTask(devCreator, "Develop feature A");
        project.addTask(testCreator, "Test feature A");
        project.addTask(docCreator, "Document feature A");

        project.executeAllTasks();
    }
}


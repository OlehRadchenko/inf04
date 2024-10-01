import { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form, InputGroup, Button } from "react-bootstrap";
import './TaskList.css';

const TaskList = () => {
    const [taskList, setTaskList] = useState([]);
    const [title, setTitle] = useState("");

    const addTask = ( task ) => {
        if(task.title !== ""){
            if(taskList.some(existingTask => existingTask.title === task.title)){
                alert("Takie zadanie juz istnieje, bądź kreatywny ;)");
            }else{
                if(task.id){
                    setTaskList([...taskList, task]);
                }else{
                    task.id = Date.now();
                    let dateString = new Date().toLocaleDateString() + " " + new Date().toLocaleTimeString();
                    task.date = dateString;
                    if(task.completed){
                        setTaskList([...taskList, task]);
                    }
                    task.completed = false;
                    setTaskList([...taskList, task]);
                }
            }
        }else{
            alert("Próbujesz dodac puste zadanie, wymyśl trudniejsze ;)");
        }
    }
    const deleteTask = (id) => {
        setTaskList(taskList.filter((task) => task.id !== id));
    }
    const completeTask = (id) => {
        setTaskList(
            taskList.map((task) =>
                task.id === id ? { ...task, completed: !task.completed } : task
            )
        );
    }
    return (
        <div>
            <h1>Lista Zadań</h1>
            <Form>
                <InputGroup className="mb-3">
                    <Form.Control
                        placeholder="Wpisz nowe zadanie"
                        onChange={e => setTitle(e.target.value)}
                        value={title}
                    />
                    <Button variant="outline-secondary" id="button-addon2" onClick={() => addTask({title})}>
                        Dodaj nowe zadanie
                    </Button>
                </InputGroup>
            </Form>
            {taskList.map((task) => (
                <div key={task.id} className={`task${task.completed ? " disabled" : ""} position-relative p-3 border mb-3`}>
                    <h4>{task.title}</h4>
                    <p className="position-absolute top-0 end-0 m-1 text-muted">{task.date}</p>
                    <Form.Check
                        type="checkbox"
                        className="d-flex align-items-center"
                        id={`completed-${task.id}`}
                        label="Wykonane"
                        onChange={() => completeTask(task.id)}
                    />
                    <Button onClick={() => deleteTask(task.id)}>Delete</Button>
                </div>
            ))}
            {
                taskList.length === 0 ? 
                <h2>Brak zadań</h2> :
                <h2>{taskList.filter((task) => task.completed).length} wykonanych zadań z {taskList.length}. To aż {Math.round((taskList.filter((task) => task.completed).length / taskList.length) * 100)}%</h2>
            }
        </div>
    )
}

export default TaskList;
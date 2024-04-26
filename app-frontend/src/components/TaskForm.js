import React, { useState } from "react";

const TaskForm = (props) => {
    const [title, setTitle] = useState('')

    const handleSubmit = (event) => {
        event.preventDefault()
        props.onSubmit(title)
        setTitle('')
    }

    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="title">Task title</label>
            <input 
                type="text"
                id="title"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
            />
            <button type="submit">Add Task</button>
        </form>
    )
}

export default TaskForm
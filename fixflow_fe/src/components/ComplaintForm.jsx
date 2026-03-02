import { useState } from 'react'

function ComplaintForm({ addComplaint }) {
  const [name, setName] = useState("")
  const [title, setTitle] = useState("")
  const [description, setDescription] = useState("")

  const handleSubmit = (eve) => {
    eve.preventDefault()
    if(!name || !title || !description) {
      alert("Please fill All Fields before submit!")
      return
    }
    const newComplaint = {
      name,
      title,
      description,
      status: "OPEN",
      assignedTechnician: null
    }
    addComplaint(newComplaint)
    setName("")
    setTitle("")
    setDescription("")
  }

  return (
    <div className="complaint-form">
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Your Name</label>
          <input
            type="text"
            placeholder="Enter Your Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label>Complaint Title</label>
          <input
            type="text"
            placeholder="Enter Complaint Title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label>Description</label>
          <textarea
            placeholder="Explain Your Complaint in detail"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
        </div>
        <button type="submit">
           Submit Complaint
        </button>
      </form>
    </div>
  )
}

export default ComplaintForm
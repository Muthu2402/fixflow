import { useState } from 'react'

function ComplaintItem({ complaint, updateStatus, 
                         assignTechnician, userRole }) {
  const [tech, setTech] = useState("")

  return (
    <div className={`complaint-item ${complaint.status}`}>

      {/* Header */}
      <div className="complaint-header">
        <h3> {complaint.name}</h3>
        <span className={`status-badge ${complaint.status}`}>
          {complaint.status === "IN_PROGRESS" 
            ? "IN PROGRESS" 
            : complaint.status}
        </span>
      </div>

      {/* Details */}
      <p className="complaint-title"> {complaint.title}</p>
      <p className="complaint-desc">{complaint.description}</p>

      {/* Technician Tag */}
      {complaint.assignedTechnician && (
        <span className="technician-tag">
           Technician: {complaint.assignedTechnician}
        </span>
      )}

      {/* ADMIN - Assign Technician */}
      {userRole === "ADMIN" && 
       complaint.status === "OPEN" && (
        <div className="assign-section">
          <input
            type="text"
            placeholder="Enter Technician Name"
            value={tech}
            onChange={(e) => setTech(e.target.value)}
          />
          <button
            className="btn-assign"
            onClick={() => {
              assignTechnician(complaint.id, tech)
              setTech("")
            }}>
            Assign
          </button>
        </div>
      )}

      {/* TECHNICIAN - Close Complaint */}
      {userRole === "TECHNICIAN" && 
       complaint.status === "IN_PROGRESS" && (
        <button
          className="btn-close"
          onClick={() => updateStatus(complaint.id)}>
           Close Complaint
        </button>
      )}

    </div>
  )
}

export default ComplaintItem
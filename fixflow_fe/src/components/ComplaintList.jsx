import ComplaintItem from "./ComplaintItem"

function ComplaintList({ complaints, updateStatus, 
                         assignTechnician, userRole }) {
  return (
    <div className="complaint-list">
      <h2> All Complaints</h2>

      {complaints.length === 0 ? (
        <div className="no-complaints">
          <p> No Complaints Found!</p>
        </div>
      ) : (
        complaints.map(c => (
          <ComplaintItem
            key={c.id}
            complaint={c}
            assignTechnician={assignTechnician}
            updateStatus={updateStatus}
            userRole={userRole}
          />
        ))
      )}
    </div>
  )
}

export default ComplaintList
import ComplaintList from '../components/ComplaintList'

function Dashboard({ complaints, userRole, 
                     assignTechnician, updateStatus }) {

  const totalCount = complaints.length
  const openCount = complaints.filter(c => c.status === "OPEN").length
  const inProgressCount = complaints.filter(
                          c => c.status === "IN_PROGRESS").length
  const closedCount = complaints.filter(c => c.status === "CLOSED").length

  return (
    <div className="page">

      {/* Summary Cards */}
      <div className="summary">
        <div className="summary-card total">
          <h4>Total</h4>
          <p>{totalCount}</p>
        </div>
        <div className="summary-card open">
          <h4>Open</h4>
          <p>{openCount}</p>
        </div>
        <div className="summary-card progress">
          <h4>In Progress</h4>
          <p>{inProgressCount}</p>
        </div>
        <div className="summary-card closed">
          <h4>Closed</h4>
          <p>{closedCount}</p>
        </div>
      </div>

      {/* Complaint List */}
      <ComplaintList
        complaints={complaints}
        updateStatus={updateStatus}
        assignTechnician={assignTechnician}
        userRole={userRole}/>
    </div>
  )
}

export default Dashboard
import ComplaintForm from '../components/ComplaintForm'

function ApplyComplaint({ addComplaint }) {
  return (
    <div className="page">
      <div className="apply-container">
        <h2 className="page-title"> Apply New Complaint</h2>
        <p className="page-subtitle">
          Fill the form below to submit your complaint
        </p>
        <ComplaintForm addComplaint={addComplaint}/>
      </div>
    </div>
  )
}

export default ApplyComplaint
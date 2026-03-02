import { useState, useEffect } from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'
import Dashboard from './pages/Dashboard'
import ApplyComplaint from './pages/ApplyComplaint'
import { getAllComplaints, createComplaint,
         assignTechnician, updateStatus } from './services/complaintService'
import './App.css'

function App() {
  const [complaints, setComplaints] = useState([])
  const [userRole, setUserRole] = useState("ADMIN")

  useEffect(() => {
    getAllComplaints()
      .then(res => setComplaints(res.data))
      .catch(err => console.error(err))
  }, [])

  const addComplaint = (newComplaint) => {
    createComplaint(newComplaint)
      .then(res => setComplaints(prev => [...prev, res.data]))
      .catch(err => console.error(err))
  }

  const assignTech = (id, techName) => {
    assignTechnician(id, techName)
      .then(res => setComplaints(prev =>
        prev.map(c => c.id === id ? res.data : c)))
      .catch(err => console.error(err))
  }

  const closeComplaint = (id) => {
    updateStatus(id, "CLOSED")
      .then(res => setComplaints(prev =>
        prev.map(c => c.id === id ? res.data : c)))
      .catch(err => console.error(err))
  }

  return (
    <BrowserRouter>
      {/* Navbar */}
      <nav className="navbar">
        <h1 className="nav-logo">🔧 FixFlow</h1>
        <div className="nav-links">
          <Link to="/">Dashboard</Link>
          <Link to="/apply">Apply Complaint</Link>
        </div>
        <select className="role-select"
                value={userRole}
                onChange={(e) => setUserRole(e.target.value)}>
          <option value="ADMIN">ADMIN</option>
          <option value="TECHNICIAN">TECHNICIAN</option>
          <option value="USER">USER</option>
        </select>
      </nav>

      {/* Pages */}
      <Routes>
        <Route path="/" element={
          <Dashboard
            complaints={complaints}
            userRole={userRole}
            assignTechnician={assignTech}
            updateStatus={closeComplaint}/>
        }/>
        <Route path="/apply" element={
          <ApplyComplaint addComplaint={addComplaint}/>
        }/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
import React from 'react'

const Profile = () => {
  return (
    <div >
        <h2 style={{textAlign:"center", marginTop: "40px"}}>Profile Page</h2>
        <div className="card" style={{width: "50rem", marginTop: "40px", padding:"10px 100px 10px 100px", textAlign:"center", margin:"auto"}}>
            <div style={{textAlign:"center"}}>
            <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" style={{width:"100px", height:"100px"}} className="card-img-top" alt="..." />
            </div>
  <div className="card-body">
    <h5 className="card-title">Your Name:</h5>
    <p className="card-text"></p>
  </div> 
  <ul className="list-group list-group-flush">
    <li className="list-group-item"></li>
    <li className="list-group-item">Your Addres:  </li>
  </ul>
  <div className="card-body">
    <a href="#" className="card-link">View Details</a>
    <a href="#" className="card-link">GO to Home Page</a>
  </div>
</div>
    </div>
  )
}

export default Profile
import React from 'react'
import { Link } from 'react-router-dom';

const Navbar = ({login, setLogin}) => {


  return (
    <div >
        <nav className="navbar bg-dark navbar-expand-lg navbar-dark">
  <div className="container-fluid">
    
    <div className="collapse navbar-collapse" id="navbarNav">
      <ul className="navbar-nav">
        <li className="nav-item">
          
        <Link className="nav-link active" to={"/"}>Register</Link>
        </li>
        <li className="nav-item">
        <Link className="nav-link active" to={"/login"}>Login</Link>
    
        </li>
        <li className="nav-item">
          <Link className="nav-link active" to={"/profile"}>Profile</Link>
        </li>

        {login && <li className="nav-item" onClick={()=>setLogin(false)}>
          <Link className="nav-link active" to={"/"} >Logout</Link>
        </li>}
        
        
      </ul>
    </div>
  </div>
</nav>
    </div>
  )
}

export default Navbar;
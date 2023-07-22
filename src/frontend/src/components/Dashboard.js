import React, { useState } from 'react'
import Navbar from './Navbar'
import { Outlet } from "react-router-dom";

const Dashboard = ({login, setLogin}) => {

  



  return (
    <div>
        <Navbar login={login} setLogin={setLogin}/>
        <Outlet />
    </div>
  )
}

export default Dashboard
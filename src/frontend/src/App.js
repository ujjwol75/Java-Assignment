import './App.css';
import Dashboard from './components/Dashboard';
import { Home } from './components/Home';
import Profile from './components/Profile';
import {SignIn} from './components/SignIn';
import SignUp from './components/SignUp';
import { Routes, Route, BrowserRouter } from "react-router-dom";
import React,{useState} from 'react'


function App() {

  const [login, setLogin] = useState(false);

  return (
    <div className="App">

      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<Dashboard login={login} setLogin={setLogin}/>}>
            <Route index element={<SignUp />} />

            <Route path="/login"  element={<SignIn setLogin={setLogin}/>} />
            <Route path="/home" element={<Home />} />
            <Route path="/profile" element={<Profile />} />

          </Route>
          
        </Routes>
      </BrowserRouter>

      {/* <BrowserRouter>
            <Routes>
              <Route path="/" element={<SignUp />} />
              <Route path="/login" element={<SignIn />} />
              <Route path="/home" element={<Home />} />
            </Routes>
          </BrowserRouter> */}
      {/* <Navbar />
      <SignIn />
      <SignUp /> */}
    </div>
  );
}

export default App;

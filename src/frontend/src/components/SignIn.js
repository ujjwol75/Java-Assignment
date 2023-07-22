import React, { useState } from 'react';
import axios from "axios";
import { useNavigate } from 'react-router'




export const SignIn = ({setLogin, login}) => {
    
    const [inputValues, setInputValue] = useState({
        email: "",
        password: ""
      });

      const navigate = useNavigate();

      function handleChange(event) {
        const { name, value } = event.target;
        setInputValue({ ...inputValues, [name]: value });
      }

      console.log("login", login)


      function handleSubmit(e){
        e.preventDefault()
        console.log("ivalues:" , inputValues)
        axios.post('http://localhost:8080/user/login', 
            inputValues
          )
          .then(function (response) {
            console.log(response);
            setLogin(true)
            navigate("/profile")
            

          })
          .catch(function (error) {
            console.log(error);
          });
        }



    return (    
        <div className='container'>
            <h1 className='text-center'>Sign In </h1>
            
            <div className='col-md-6  mx-auto'>
                <form action="" method="post" onSubmit={(e)=>handleSubmit(e)}>
                    <div className="mb-3">
                        <label className="form-label">Enter Your Email address</label>
                        <input type="email" className="form-control" id="email" onChange={handleChange} value={inputValues.email} name="email" />
                        
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Enter Your Password</label>
                        <input type="password" className="form-control"  id="password" onChange={handleChange} value={inputValues.password} name="password" />
                    </div>
                    
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
      


        </div>
    )
}


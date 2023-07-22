import React, { useState } from 'react';
import axios from "axios";
import { useNavigate } from 'react-router-dom';


const SignUp = ({login}) => {

    const [inputValues, setInputValue] = useState({
        name:"",
        email: "",
        password: ""
      });

      const navigate = useNavigate();

      function handleChange(event) {
        const { name, value } = event.target;
        setInputValue({ ...inputValues, [name]: value });
      }

      function handleSubmit(e){
        e.preventDefault()
        console.log("ivalues:" , inputValues)
        axios.post('http://localhost:8080/user', 
            inputValues
          )
          .then(function (response) {
            console.log(response);
            navigate("/login")
          })
          .catch(function (error) {
            console.log(error);
          });

      }


    

    return (
        <div className='container'>
            <h1 className='text-center'>Register Page </h1>
            
            <div className='col-md-6  mx-auto'>
                <form action="" onSubmit={(e)=>handleSubmit(e)}>
                    <div className="mb-3">
                        <label className="form-label">Enter Username</label>
                        <input type="text" className="form-control" id="name" onChange={handleChange} value={inputValues.name} name="name" />
                        
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Enter Email address</label>
                        <input type="email" className="form-control" id="email" onChange={handleChange} value={inputValues.email} name="email" aria-describedby="emailHelp" />
                         
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Enter Password</label>
                        <input type="password" className="form-control" id="password" onChange={handleChange} value={inputValues.password} name="password" />
                    </div>
                    
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
      


        </div>
    )
}

export default SignUp
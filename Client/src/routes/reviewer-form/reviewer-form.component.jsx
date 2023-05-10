import React, { useState } from 'react';
import FormInput from '../../components/form-input/form-input.component';
import Button, { BUTTON_TYPE } from '../../components/button/button.component';
import axios from 'axios';
import './reviewer-form.styles.scss';
import { Link } from 'react-router-dom';

const FORM_INITIAL_STATE = {
   firstName: "",
   lastName: "",
   email: "",
   title: "",
   phoneNumber: "",
   institution: "",
   country: "",
   adress: "",
};

const ReviewerForm = () => {
   const [form, setForm] = useState(FORM_INITIAL_STATE);
   const { firstName, lastName, email, title, phoneNumber, institution, country, adress } = form;
   const handleSubmit = async event => {
      event.preventDefault();

      const formData = new FormData();
      formData.append("firstName", firstName);
      formData.append("lastName", lastName);
      formData.append("email", email);
      formData.append("title", title);
      formData.append("phoneNumber", phoneNumber);
      formData.append("institution", institution);
      formData.append("country", country);
      formData.append("adress", adress);

      try {
         await axios.post("/api/reviewers", formData);
         alert("reviewer registration successful!");
      } catch (error) {
         console.error(error);
         alert("reviewer registration failed.");
      }
   };

   const handleInputChange = event => {
      const { name, value } = event.target;
      setForm({ ...form, [name]: value });
   };


   return (
      <div className='reviewer-form'>
         <div className='reviewer-form-container'>
            <h1>Reviewer Form</h1>
            <form onSubmit={handleSubmit}>
               <FormInput label="First Name" type='text' required onChange={handleInputChange} name='firstName' value={firstName} />
               <FormInput label="Last Name" type='text' required onChange={handleInputChange} name='lastName' value={lastName} />
               <FormInput label="Title" type='text' required onChange={handleInputChange} name='title' value={title} />
               <FormInput label="Institution" type='text' required onChange={handleInputChange} name='phoneNumber' value={phoneNumber} />
               <FormInput label="Email" type='email' required onChange={handleInputChange} name='email' value={email} />
               <FormInput label="Phone Number" type='tel' required onChange={handleInputChange} name='phoneNumber' value={phoneNumber} />
               <FormInput label="Country" type='text' required onChange={handleInputChange} name='country' value={country} />
               <FormInput label="Adress" type='text' required onChange={handleInputChange} name='adress' value={adress} />
               <Button type="submit" buttonType={BUTTON_TYPE.MAIN_BUTTON}>Register</Button>
            </form>
            <span>Already have an account ? <Link to="/sign-in">Sign In</Link></span>
         </div>
      </div>
   );
};

export default ReviewerForm;

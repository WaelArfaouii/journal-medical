import { useState } from 'react';
import FormInput from '../../components/form-input/form-input.component';
import Button, { BUTTON_TYPE } from '../../components/button/button.component';
import './sign-in.styles.scss';
import { Link } from 'react-router-dom';

const defaultFormFields = {
   email: '',
   password: '',
};

const SignIn = () => {
   const [formFields, setFormFields] = useState(defaultFormFields);
   const { email, password } = formFields;

   const submitHandler = async (event) => {
      event.preventDefault();
      try {

      } catch (error) {
         if (error.code === "auth/wrong-password") {

         } else if (error.code === "auth/user-not-found") {
            alert("wrong email");
         } else {

         }
         switch (error.code) {
            case "auth/wrong-password": alert("Wrong Password"); break;
            case "auth/user-not-found": alert("Wrong email"); break;
            default: console.log(error.code);
         }
      }
   };

   const changeHandle = (event) => {
      const { name, value } = event.target;
      setFormFields({ ...formFields, [name]: value });
   };

   return (
      <section className='sign-in'>
         <div className='sign-in-container'>
            <h2>Already have an account?</h2>
            <span>sign in with your email and password</span>
            <form onSubmit={submitHandler}>
               <FormInput label="Email" type='email' required onChange={changeHandle} name='email' value={email} />
               <FormInput label="Password" type='password' required onChange={changeHandle} name='password' value={password} />
               <Button type='submit' buttonType={BUTTON_TYPE.MAIN_BUTTON}>Sign In</Button>
            </form>
            <span>Did you not have an account? <Link to="/join-us">Sign Up</Link></span>
         </div>
      </section>
   );
};

export default SignIn;
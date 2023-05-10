import { Fragment, useState } from 'react';
import { GoThreeBars } from "react-icons/go";
import { Outlet, Link } from 'react-router-dom';
import { useMediaQuery } from 'react-responsive';
import logoLS from '../../assests/logo2.png';
import logoSS from '../../assests/logo-mobile.png';
import './navigation.styles.scss';



const Navigation = () => {
   const isScreenSmall = useMediaQuery({ query: '(max-width: 768px)' });
   const [isMenuOpen, setIsMenuOpen] = useState(false);

   const toggleMenu = () => {
      setIsMenuOpen(!isMenuOpen);
   };

   return (
      <Fragment>
         <header className="navigation">
            <div className='container'>
               <Link className="logo-container" to='/'>
                  {
                     isScreenSmall ?
                        <img src={logoSS} alt='logo' className='logo-sm-screen' /> :
                        <img src={logoLS} alt='logo' className='logo-lg-screen' />
                  }
               </Link>
               {
                  (!isScreenSmall || isMenuOpen) &&
                  <nav>
                     <ul>
                        <li>
                           <Link to='/'>
                              Home
                           </Link>
                        </li>
                        <li>
                           <Link to='about'>
                              About
                           </Link>
                        </li>
                        <li>
                           <Link to='sign-in'>
                              Sign In
                           </Link>
                        </li>
                        <li>
                           <Link to='join-us'>
                              Join Us
                           </Link>
                        </li>
                     </ul>
                  </nav>
               }
               {isScreenSmall && <GoThreeBars className='three-bars' onClick={toggleMenu}/>}
            </div>
         </header>
         <Outlet />
      </Fragment>
   );
};

export default Navigation;
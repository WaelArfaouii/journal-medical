import "./dashboard-header.styles.scss";
import { AiOutlineSetting, AiOutlineSearch, AiOutlineNotification } from "react-icons/ai";
import ProfilePic from "../../assests/profilepicture.png";
import { Link } from "react-router-dom";
import { useState } from "react";


const DashboardHeader = () => {
   const [isSettingsOpen, setIsSettingsOpen] = useState(false);

   const toggleSettingsMenuHandler = () => setIsSettingsOpen(!isSettingsOpen);

   return (
      <div className="dashboard-header">
         <div className="search-container">
            <img src={ProfilePic} alt="profile" />
            <AiOutlineSearch className="search-icon" />
            <input type="search" placeholder="Type A Keyword" />
         </div>
         <nav className="navbar">
            <Link to="/">Help</Link>
            <Link to="/">Report</Link>
            <AiOutlineNotification className="notifications-icon" />
            <AiOutlineSetting className="settigns-icon" onClick={toggleSettingsMenuHandler} />
         </nav>
         {
            isSettingsOpen &&
            <div className="settings-menu">
               <ul>
                  <li>Settigns</li>
                  <li>Logout</li>
               </ul>
            </div>
         }
      </div>
   );
};

export default DashboardHeader;
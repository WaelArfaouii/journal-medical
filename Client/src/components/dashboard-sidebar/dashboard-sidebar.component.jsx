import { Link } from "react-router-dom";
import logo from "../../assests/logo2.png";
import "./dashboard-sidebar.styles.scss";
import { Fragment } from "react";

const DashboardSidebar = ({ routes, dashboardTitle }) => {
   return (
      <div className="dashboard-sidebar">
         <img src={logo} alt="logo" />
         <div className="menu-container">
            <h1 className="dashboard-title">
               {dashboardTitle}
            </h1>
            {routes.map((routeCategory) => {
               const { category, pages, layout } = routeCategory;
               return (
                  <Fragment key={`${category}-section`}>
                     <span className="section-title">{category.toUpperCase()}</span>
                     <ul className="section-link">
                        {
                           pages.map((item) => {
                              return (
                                 <li key={`${layout}${item.path}`}>
                                    <Link to={`${layout}${item.path}`}>
                                       {item.name}
                                    </Link>
                                 </li>
                              );
                           })
                        }
                     </ul>
                  </Fragment>
               );
            })}
         </div>
      </div>
   );
};

export default DashboardSidebar;
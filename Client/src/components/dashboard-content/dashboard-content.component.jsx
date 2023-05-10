import { Route, Routes } from 'react-router-dom';
import "./dashboard-content.styles.scss";

const DashboardContent = ({ routes }) => {
   return (
      <div className="dashboard-content">
         <Routes>
            {
               routes.map((routesCategory) => {
                     const { pages } = routesCategory;
                     return (
                        pages.map((page) => <Route key={page.path} path={page.path} element={<page.component />} />)
                     );
                  }
               ).flat()
            }
         </Routes>
      </div>
   );
};

export default DashboardContent;
import DashboardHeader from '../../components/dashboard-header/dashboard-header.component';
import DashboardSidebar from '../../components/dashboard-sidebar/dashboard-sidebar.component';
import DashboardContent from '../../components/dashboard-content/dashboard-content.component';
import AUTHOR_ROUTES from '../../constants/author-routes';
import './author-dashboard.styles.scss';


const dashboardTitle = "Author Menu";


const AuthorDashboard = () => {

   return (
         <div className="dashboard-container">
            <div className='dashboard-sidebar-container'>
               <DashboardSidebar routes={AUTHOR_ROUTES} dashboardTitle={dashboardTitle}/>
            </div>
            <div className='dashboard-header-content-container'>
               <DashboardHeader />
               <DashboardContent routes={AUTHOR_ROUTES} />
            </div>
         </div>
   );
};

export default AuthorDashboard;
import DashboardHeader from '../../components/dashboard-header/dashboard-header.component';
import DashboardSidebar from '../../components/dashboard-sidebar/dashboard-sidebar.component';
import DashboardContent from '../../components/dashboard-content/dashboard-content.component';
import REVIEWER_ROUTES from '../../constants/reviewer-routes';
import './reviewer-dashboard.styles.scss';


const dashboardTitle = "Reviewer Menu";


const ReviewerDashboard = () => {

   return (
         <div className="dashboard-container">
            <div className='dashboard-sidebar-container'>
               <DashboardSidebar routes={REVIEWER_ROUTES} dashboardTitle={dashboardTitle}/>
            </div>
            <div className='dashboard-header-content-container'>
               <DashboardHeader />
               <DashboardContent routes={REVIEWER_ROUTES} />
            </div>
         </div>
   );
};

export default ReviewerDashboard;
import ReviewerInvitations from "../components/reviewer-content/reviewer-invitations/reviewer-invitations.component";
import ReviewerPending from "../components/reviewer-content/reviewer-pending/reviewer-pending.componont";
import ReviewerCompleted from "../components/reviewer-content/reviewer-completed/reviewer-completed.component";

const REVIEWER_ROUTES = [
   {
      category: 'Invitations',
      layout: '/reviewer-dashboard',
      pages: [
         {
            name: 'New Reviewer Invitations',
            path: '/new-reviewer-invitations',
            component: ReviewerInvitations
         }
      ]
   },
   {
      category: 'Assignements',
      layout: '/reviewer-dashboard',
      pages: [
         {
            name: 'Pending Assignements',
            path: '/pending-assignements',
            component: ReviewerPending
         },
         {
            name: 'Completed Assignements',
            path: '/completed-assignements',
            component: ReviewerCompleted
         }
      ]
   }
];

export default REVIEWER_ROUTES;
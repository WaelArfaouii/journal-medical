import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./reviewer-pending.styles.scss";

const pendingAssignements = null;

const ReviewerPending = () => {
   return (
      pendingAssignements ?
         (
            <div>there is new Pending</div>
         ) :
         (
            <Alert severity="info">
               <AlertTitle>No pending assignements found!</AlertTitle>
               There are currently no pending assignements for you.
            </Alert>
         )
   );
};

export default ReviewerPending;
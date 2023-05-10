import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./reviewer-completed.styles.scss";

const completedAssignements = null;

const ReviewerCompleted = () => {
   return (
      completedAssignements ?
         (
            <div>there is new completed</div>
         ) :
         (
            <Alert severity="info">
               <AlertTitle>No completed assignements found!</AlertTitle>
               There are currently no completed assignements for you.
            </Alert>
         )
   );
};

export default ReviewerCompleted;
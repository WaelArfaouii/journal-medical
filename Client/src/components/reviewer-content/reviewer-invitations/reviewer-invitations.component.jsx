import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./reviewer-invitations.styles.scss";

const newInvitations = null;

const ReviewerInvitations = () => {
   return (
      newInvitations ?
         (
            <div>there is new invitations</div>
         ) :
         (
            <Alert severity="info">
               <AlertTitle>No new invitations found!</AlertTitle>
               There are currently no new invitations for you.
            </Alert>
         )
   );
};

export default ReviewerInvitations;
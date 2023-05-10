import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./incomplete-submission.styles.scss";



const IncompleteSubmission = () => {

   return (
      <Alert severity="info">
         <AlertTitle>No Incomplete Submissions found!</AlertTitle>
         There are currently no incomplete submissions for you.
      </Alert>
   );
};

export default IncompleteSubmission;
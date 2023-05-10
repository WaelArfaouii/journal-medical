import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./submission-processed.styles.scss";

const submissionsProcessed = -1;

const SubmissionProcessed = () => {
   return (
      submissionsProcessed === -1 ?
         <Alert severity="info">
            <AlertTitle>No Submissions Are Processing Right Now!</AlertTitle>
            There are currently no submissions being processed.
         </Alert> :
         <p>estanna</p>
   );
};

export default SubmissionProcessed;
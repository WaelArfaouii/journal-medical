import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./submission-decision.styles.scss";

const submissionsDecision = -1;

const SubmissionDecision= () => {
   return (
      submissionsDecision === -1 ?
         <Alert severity="info">
            <AlertTitle>No Submissions With Decision Found!</AlertTitle>
            There are currently no submissions with decision.
         </Alert> :
         <p>estanna</p>
   );
};

export default SubmissionDecision;
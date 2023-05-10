import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./submission-under-revision.styles.scss";

const submissionsUnderRevision = -1;

const SubmissionsUnderRevision = () => {
   return (
      submissionsUnderRevision === -1 ?
         <Alert severity="info">
            <AlertTitle>No Submissions Are Under Revision Right Now!</AlertTitle>
            There are currently no submissions under revision.
         </Alert> :
         <p>estanna</p>
   );
};

export default SubmissionsUnderRevision;
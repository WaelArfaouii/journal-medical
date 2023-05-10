import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./revision-processed.styles.scss";

const revisionProcessed = -1;

const RevisionProcessed = () => {
   return (
      revisionProcessed === -1 ?
         <Alert severity="info">
            <AlertTitle>No Submissions Are Processing Right Now!</AlertTitle>
            There are currently no submissions being processed.
         </Alert> :
         <p>wait</p>
   );
};

export default RevisionProcessed;
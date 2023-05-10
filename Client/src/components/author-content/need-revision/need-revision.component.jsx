import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./need-revision.styles.scss";

const needRevision = -1;

const NeedRevision = () => {
   return (
      needRevision === -1 ?
         <Alert severity="info">
            <AlertTitle>No Submissions Are Processing Right Now!</AlertTitle>
            There are currently no submissions being processed.
         </Alert> :
         <p>estanna</p>
   );
};

export default NeedRevision;
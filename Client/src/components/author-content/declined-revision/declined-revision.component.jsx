import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import "./declined-revision.styles.scss";

const declinedRevision = -1;

const DeclinedRevision = () => {
   return (
      declinedRevision === -1 ?
         <Alert severity="info">
            <AlertTitle>No Declined Revisions Found!</AlertTitle>
            There are currently no declined revisions.
         </Alert> :
         <p>estanna</p>
   );
};

export default DeclinedRevision;
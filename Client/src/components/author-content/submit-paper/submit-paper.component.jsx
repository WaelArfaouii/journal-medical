import HorizontalStepper from "../../stepper/stepper.component";
import AttachFiles from "../attach-files/attach-files.component";
import ManuscripData from "../manuscript-data/manuscript-data.component";
import Comment from "../comment/comment.component";
import { useContext } from "react";
import { SubmissionContext } from "../../../contexts/submission-files.context";
import './submit-paper.styles.scss';

const steps = ['Attach Files', 'Manuscript Data', 'Comments'];

const components = [<AttachFiles />, <ManuscripData />, <Comment />];

const SubmitPaper = () => {

   const { submission } = useContext(SubmissionContext);


   const handleSubmit = (e) => {
      e.preventDefault();
      
      console.log(submission);
      const formData = new FormData();
      formData.append("submission", submission);
      console.log(formData);
   };
   return (
      <form className="submit-paper-container" onSubmit={handleSubmit}>
         <HorizontalStepper steps={steps} components={components} />
      </form>
   );
};

export default SubmitPaper;
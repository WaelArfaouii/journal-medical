import { SubmissionContext } from "../../../contexts/submission-files.context";
import "./comment.styles.scss";
import { useContext, useState } from "react";

const Comment = () => {

   const { submissionComment, setSubmissionComment } = useContext(SubmissionContext);

   const [comment, setComment] = useState("");

   const handleCommentChange = (event) => {
      setComment(event.target.value);
      setSubmissionComment({ submissionComment: comment });
   };

   return (
      <div className="comment-container">
         <div className="form-group">
            <label htmlFor="comment">Comments</label>
            <textarea id="comment" onChange={handleCommentChange} value={comment} placeholder="Please enter any additional comments you would to send to the publication office. these comments will not appear directly in your submission."
            />
         </div>
      </div>
   );
};

export default Comment;
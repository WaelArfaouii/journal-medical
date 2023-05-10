import { useNavigate } from "react-router-dom";
import { VscOpenPreview } from "react-icons/vsc";
import { TfiWrite } from "react-icons/tfi";
import JoinUsCard from "../../components/join-us-card/join-us-card.component";
import "./join-us.styles.scss";

const authorBenefits = [
   "Publication and dissemination of papars",
   "Peer Review and Feedback for papers",
   "Career advancement and opportunities for collaborations",
];

const reviewerBenefits = [
   "Evaluate the quality of submitted papers",
   "Contributes to the advancement of knowledge in the field",
   "Helps to maintain the integrity and credibility of the publication process",
];

const JoinUs = () => {
   const navigate = useNavigate();
   const authorNavigateHandler = () => navigate("/author-form");
   const reviewerNavigateHandler = () => navigate("/reviewer-form");
   return (
   <section className="join-us">
      <h1>Join as</h1>
      <div className="container">
         <JoinUsCard cardIcon={<TfiWrite />} title="Author" benefits={authorBenefits} onClick={authorNavigateHandler} />
         <JoinUsCard cardIcon={<VscOpenPreview />} title="Reviewer" benefits={reviewerBenefits} onClick={reviewerNavigateHandler} />
      </div>
   </section>
   )
}

export default JoinUs;

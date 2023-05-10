import { useNavigate } from "react-router-dom";
import Button, { BUTTON_TYPE } from "../../components/button/button.component";
import journalcover from "../../assests/journal-cover.png";
import "./home.styles.scss";

const Home = () => {

   const navigate = useNavigate();

   const submitPaperHandler = () => navigate("/sign-in");

   return (
      <section className="landing-page">
         <div className="container">
            <div className="introduction">
               <p>
                  The International Journal of Medical Images is a peer-reviewed journal
                  dedicated to the latest advancements in medical imaging technology and
                  techniques. It publishes high-quality research articles, review
                  papers, and case studies to promote the development of innovative
                  imaging methods that can improve patient diagnosis and treatment
                  outcomes.
               </p>
               <Button buttonType={BUTTON_TYPE.MAIN_BUTTON} onClick={submitPaperHandler}>Submit Paper</Button>
            </div>
            <img src={journalcover} alt="journal cover" />
         </div>
      </section>
   );
};

export default Home;

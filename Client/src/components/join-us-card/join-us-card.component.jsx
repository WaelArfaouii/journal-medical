import './join-us-card.styles.scss';
import { AiOutlineCheck } from "react-icons/ai";

const JoinUsCard = ({ cardIcon, title, benefits, ...otherProps }) => {
   return (
      <div className="join-us-card" {...otherProps}>
         <div className='main-icon'>{cardIcon}</div>
         <h2>{title}</h2>
         <div className='benefits'>
            {benefits.map((benefit) => <p><AiOutlineCheck className='check-icon' /> {benefit}.</p>)}
         </div>
      </div>
   );
};

export default JoinUsCard;
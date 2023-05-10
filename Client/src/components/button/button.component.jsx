import './button.styles.scss';

export const BUTTON_TYPE = {
   MAIN_BUTTON: 'main-button',
   SECOND_BUTTON: 'second-button',
   THIRD_BUTTON: 'third-button',
}

const Button = ({children, buttonType, ...otherProps}) => 
   <button className={`button-container ${buttonType}`} {...otherProps}>
      {children}
   </button>

export default Button;
import { useState } from "react";
import Button, { BUTTON_TYPE } from "../../button/button.component";
import FileInput from "../../file-input/file-input.compoent";
import "./attach-files.styles.scss";

const ATTACH_FILES_INITAIL_STATE = [
   <FileInput key={1} order={1} defaultDescription="Manuscript file" defaultSelectedType="Manuscript" />,
   <FileInput key={2} order={2} defaultDescription="Declaration of interest" defaultSelectedType="Declaration of interest" />
];

const AttachFiles = () => {

   const [inputFiels, setInputFiels] = useState(ATTACH_FILES_INITAIL_STATE);

   const handleAddFileClick = (event) => {
      event.preventDefault();
      const newInputFileds = [...inputFiels];
      const order = inputFiels.length + 1;
      newInputFileds.push(<FileInput key={order} order={order} />);
      setInputFiels(newInputFileds);
   };

   return (
      <section className="attach-files-container">
         <header className="attach-files-header">
            <span>Item</span>
            <span>Description</span>
            <span>File</span>
            <span>File Name</span>
         </header>
         <div className="attach-files-form">
            {inputFiels}
            <Button buttonType={BUTTON_TYPE.SECOND_BUTTON} onClick={handleAddFileClick} >Add Other File</Button>
         </div>
      </section>
   );
};

export default AttachFiles;
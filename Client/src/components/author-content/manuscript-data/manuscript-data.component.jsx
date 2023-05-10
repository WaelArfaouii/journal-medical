import React, { useContext, useState } from "react";
import ReactQuill from "react-quill";
import { SubmissionContext } from "../../../contexts/submission-files.context";
import { AiOutlineClose } from "react-icons/ai";
import Button, { BUTTON_TYPE } from "../../button/button.component";
import "react-quill/dist/quill.snow.css";
import "./manuscript-data.styles.scss";

const ManuscripData = () => {
   const { submissionData, setSubmissionData } = useContext(SubmissionContext);
   const [title, setTitle] = useState("");
   const [abstract, setAbstract] = useState("");
   const [keywords, setKeywords] = useState([]);
   const [authors, setAuthors] = useState([
      { firstName: "", lastName: "", email: "" },
   ]);

   const CreateNewSubmissionDataObject = (termToModify, value) => (
      { ...submissionData, [termToModify]: value }
   );


   // const handleSubmit = (event) => {
   //    event.preventDefault();
   //    console.log({ title, abstract, keywords, authors });
   // };

   const handleTitleChange = (value) => {
      setTitle(value);
      setSubmissionData(CreateNewSubmissionDataObject("title", title));
   };

   const handleAbstractChange = (value) => {
      setAbstract(value);
      setSubmissionData(CreateNewSubmissionDataObject("abstract", abstract));
   };

   const handleKeywordsChange = (event) => {
      setKeywords(event.target.value.split(";"));
      setSubmissionData(CreateNewSubmissionDataObject("title", keywords));
   };

   const handleAuthorChange = (index, e) => {
      const { name, value } = e.target;
      const list = [...authors];
      list[index][name] = value;
      setAuthors(list);
      setSubmissionData(CreateNewSubmissionDataObject("authors", authors));
   };

   const handleAddAuthor = (e) => {
      e.preventDefault();
      setAuthors([...authors, { firstName: "", lastName: "", email: "" }]);
   };

   const removeAuthor = (index) => {
      const newAuthors = [...authors];
      newAuthors.splice(index, 1);
      setAuthors(newAuthors);
      setSubmissionData(CreateNewSubmissionDataObject("authors", authors));
   };

   return (
      <div className="manuscript-data-container">
         <div className="form-group">
            <label htmlFor="title">Title *</label>
            <ReactQuill
               id="title"
               value={title}
               onChange={handleTitleChange}
            />
         </div>
         <div className="form-group">
            <label htmlFor="abstract">Abstract *</label>
            <ReactQuill
               id="abstract"
               value={abstract}
               onChange={handleAbstractChange}
            />
         </div>
         <div className="form-group">
            <label htmlFor="keywords">Keywords *</label>
            <input
               type="text"
               id="keywords"
               value={keywords}
               onChange={handleKeywordsChange}
               placeholder="Enter keywords separated by semicolon"
               required
               maxLength={2560}
            />
         </div>
         <div className="form-group">
            <label>Authors</label>
            {authors.map((author, index) => (
               <div key={index} className="author-fields">
                  <div className="author-input">
                     <label htmlFor="firstName">First Name</label>
                     <input
                        type="text"
                        name="firstName"
                        id="firstName"
                        placeholder="First name"
                        value={author.firstName}
                        onChange={(e) => handleAuthorChange(index, e)}
                     />
                  </div>
                  <div className="author-input">
                     <label htmlFor="lastName">Last Name</label>
                     <input
                        type="text"
                        name="lastName"
                        id="lastName"
                        placeholder="Last name"
                        value={author.lastName}
                        onChange={(e) => handleAuthorChange(index, e)}
                     />
                  </div>
                  <div className="author-input">
                     <label htmlFor="email">Email</label>
                     <input
                        type="email"
                        name="email"
                        id="email"
                        placeholder="Email"
                        value={author.email}
                        onChange={(e) => handleAuthorChange(index, e)}
                     />
                  </div>
                  <button
                     type="button"
                     className="remove-author-btn"
                     onClick={() => removeAuthor(index)}
                  >
                     <AiOutlineClose />
                  </button>
               </div>

            ))}
            <Button buttonType={BUTTON_TYPE.SECOND_BUTTON} onClick={handleAddAuthor}>Add Author</Button>
         </div>
      </div >
   );
};

export default ManuscripData;

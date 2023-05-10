import { useState, useContext } from 'react';
import { SubmissionContext } from "../../contexts/submission-files.context";
import { BiCloudUpload } from 'react-icons/bi';
import fileCategories from '../../constants/file-categories';
import './file-input.styles.scss';

const FILE_INPUT_INITIAL_STATE = {
   order: 0,
   type: '',
   description: '',
   file: {},
};

const FileInput = ({ defaultSelectedType = '', defaultDescription = '', order }) => {

   const [fileData, setFileData] = useState({...FILE_INPUT_INITIAL_STATE, order: order, type: defaultSelectedType, description: defaultDescription});

   const { type, description, file } = fileData;

   const { submissionFiles, setSubmissionFiles } = useContext(SubmissionContext);

   const changeSubmissionFilesArray = (newFileData, order) =>
      submissionFiles.map((fileData, index) => index === order ? newFileData : fileData);

   const handleInputChange = (event) => {
      const { name, value } = event.target;
      setFileData({ ...fileData, [name]: value });
      setSubmissionFiles(changeSubmissionFilesArray(fileData, order));
      console.log(submissionFiles);
   };

   const handleFileChange = (event) => {
      const files = event.target.files;
      if (files) {
         setFileData({ ...fileData, file: files[0] });
         setSubmissionFiles(changeSubmissionFilesArray(fileData, order));
      }
   };

   return (
      <form className="file-input-container">

         <div>
            <select id="file-categories" name='type' value={type || defaultSelectedType} onChange={handleInputChange}>
               {fileCategories.map((category) => <option key={category} value={category}>{category}</option>)}
            </select>
         </div>

         <div>
            <input className="file-description" type='text' name='description' value={description || defaultDescription} onChange={handleInputChange} />
         </div>
         <div>
            <label htmlFor={`file-upload-${order}`} className="custom-file-upload">
               <BiCloudUpload className="upload-icon" />
               <span>Upload File</span>
               <input id={`file-upload-${order}`} type="file" className="inputfile" required onChange={handleFileChange} />
            </label>
         </div>

         <div>
            <span className="file-name">{file.name || "no file selected"}</span>
         </div>
      </form>
   );
};

export default FileInput;
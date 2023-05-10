import { createContext, useReducer } from "react";

export const SUBMISSION_STATE_ACTION_TYPES = {
   SET_SUBMISSION_FILES: 'SET_SUBMISSION_FILES',
   SET_SUBMISSION_DATA: 'SET_SUBMISSION_DATA',
   SET_SUBMISSION_COMMENT: 'SET_SUBMISSION_COMMENT',
};

const INITIAL_SUBMISSION_STATE = {
   submissionFiles: [
      {
         type: "manuscript",
         description: "manuscript",
         file: '',
      },
      {
         type: "declaration of interest",
         description: "declaration of interest",
         file: '',
      },
   ],
   submissionData: {
      title: '',
      abstract: '',
      keywords: [],
      authors: [],
   },
   submissionComment: '',
};

//as the actual value you want to access
export const SubmissionContext = createContext({
   submissionFiles: [],
   setSubmissionFiles: () => null,
   submissionData: {},
   setSubmissionData: () => null,
   submissionComment: "",
   setSubmissionComment: () => null,
});

const submissionReducer = (state, action) => {

   const { type, payload } = action;

   switch (type) {
      case SUBMISSION_STATE_ACTION_TYPES.SET_SUBMISSION_FILES:
         return {
            ...state,
            submissionFiles: payload,
         };
      case SUBMISSION_STATE_ACTION_TYPES.SET_SUBMISSION_DATA:
         return {
            ...state,
            submissionData: payload,
         };
      case SUBMISSION_STATE_ACTION_TYPES.SET_SUBMISSION_COMMENT:
         return {
            ...state,
            submissionComment: payload,
         };
      default:
         throw new Error(`Unhandled type ${type} in submissionReducer`);
   }
};

export const SubmissionProvider = ({ children }) => {
   const [submission, dispatch] = useReducer(submissionReducer, INITIAL_SUBMISSION_STATE);
   const { submissionFiles, submissionData, submissionComment } = submission;
   const setSubmissionFiles = (newSubmissionFiles) => {
      dispatch({ type: SUBMISSION_STATE_ACTION_TYPES.SET_SUBMISSION_FILES, payload: newSubmissionFiles });
   };
   const setSubmissionData = (newSubmissionData) => {
      dispatch({ type: SUBMISSION_STATE_ACTION_TYPES.SET_SUBMISSION_DATA, payload: newSubmissionData });
   };
   const setSubmissionComment = (newSubmissionComment) => {
      dispatch({ type: SUBMISSION_STATE_ACTION_TYPES.SET_SUBMISSION_COMMENT, payload: newSubmissionComment });
   };

   const value = { submission, submissionFiles, setSubmissionFiles, submissionData, setSubmissionData, submissionComment, setSubmissionComment };

   return <SubmissionContext.Provider value={value}>{children}</SubmissionContext.Provider>;
};
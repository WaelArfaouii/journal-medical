import SubmitPaper from "../components/author-content/submit-paper/submit-paper.component";
import IncompleteSubmission from "../components/author-content/incomplete-submission/incomplete-submission.component";
import SubmissionProcessed from "../components/author-content/submission-processed/submission-processed.component";
import NeedRevision from "../components/author-content/need-revision/need-revision.component";
import RevisionProcessed from "../components/author-content/revision-processed/revision-processed.component";
import DeclinedRevision from "../components/author-content/declined-revision/declined-revision.component";
import SubmissionDecision from "../components/author-content/submission-decision/submission-decision.component";
import SubmissionsUnderRevision from "../components/author-content/submission-under-revision/submission-under-revision.component";

const AUTHOR_ROUTES = [
   {
      category: 'Submissions',
      layout: '/author-dashboard',
      pages: [
         {
            name: 'Submit New Manuscript',
            path: '/submit-new-manuscript',
            component: SubmitPaper
         },
         {
            name: 'Incomplete Submissions',
            path: '/incomplete-submissions',
            component: IncompleteSubmission
         },
         {
            name: 'Submissions Being Processed',
            path: '/submissions-being-processed',
            component: SubmissionProcessed
         },
         {
            name: 'Submissions Under Revision',
            path: '/submissions-under-revision',
            component: SubmissionsUnderRevision
         }
      ]
   },
   {
      category: 'Revision',
      layout: '/author-dashboard',
      pages: [
         {
            name: 'Submissions Needing Revision',
            path: '/submissions-needing-revision',
            component: NeedRevision
         },
         {
            name: 'Revision Being Processed',
            path: '/revision-being-processed',
            component: RevisionProcessed
         },
         {
            name: 'Declined Revisions',
            path: '/declined-revisions',
            component: DeclinedRevision
         }
      ]
   },
   {
      category: 'Completed',
      layout: '/author-dashboard',
      pages: [
         {
            name: 'Submissions With Decision',
            path: '/submissions-with-decision',
            component: SubmissionDecision
         }
      ]
   }
]
export default AUTHOR_ROUTES;
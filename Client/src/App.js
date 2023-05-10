import './App.scss';
import { Routes, Route} from 'react-router-dom';
import Navigation from './routes/navigation/navigation.component';
import Home from './routes/home/home.component';
import JoinUs from './routes/join-us/join-us.component';
import AuthorForm from './routes/author-form/author-form.component';
import AuthorDashboard from './routes/author-dashboard/author-dashboard.component';
import SignIn from './routes/sign-in/sign-in.component';
import ReviewerForm from './routes/reviewer-form/reviewer-form.component';
import ReviewerDashboard from './routes/reviewer-dashboard/reviewer-dashboard.component';

const App = () => 
  <Routes>
    <Route path='/' element={<Navigation />}>
      <Route index element={<Home />} />
      <Route path='join-us' element={<JoinUs />} />
      <Route path='sign-in' element={<SignIn />} />
      <Route path='author-form' element={<AuthorForm />} />
      <Route path='reviewer-form' element={<ReviewerForm />} />
    </Route>
    <Route path='/author-dashboard/*' element={<AuthorDashboard />} />
    <Route path='/reviewer-dashboard/*' element={<ReviewerDashboard />} />
  </Routes>

export default App;

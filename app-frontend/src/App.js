import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { ThemeProvider } from '@mui/material/styles';
import Home from './components/Home'
import theme from './components/UI/theme'
import HelloWorld from './components/HelloWorld'

const App = () => {
  return (
    <BrowserRouter>
      <ThemeProvider theme={theme}>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/api/tasks/v1/helloWorld' element={<HelloWorld />}/>
          {/* <Route path='/task'>
            <Route path=':id' element={<TaskDetail />} />
            <Route path='new' element={<NewTask />} />
            <Route path=':id/edit' element={<EditTask />} />
          </Route> */}
        </Routes>
      </ThemeProvider>
    </BrowserRouter>
  );
};

export default App;

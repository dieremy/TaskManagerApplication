import { ThemeProvider } from '@mui/material/styles';
import Navigation from './UI/Navigation'
import TaskForm from './TaskForm'
import theme from './UI/theme'

const Home = () => {
    return (
        <ThemeProvider theme={theme}>
            <>
                <Navigation></Navigation>
                {/* <TaskForm></TaskForm> */}
            </>
        </ThemeProvider>
    )
}

export default Home
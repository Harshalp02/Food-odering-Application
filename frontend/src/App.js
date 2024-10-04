
import { CssBaseline, ThemeProvider } from '@mui/material';
import './App.css';
import { Navbar } from './component/Navbar/Navbar';
import { darkTheme } from './Theme/DarkTheme';
import { Home } from './component/Home/Home';
import { RestaurantDetails } from './component/Restaurant/RestaurantDetails';
import { Cart } from './component/Cart/Cart';
import { Profile } from './component/Profile/Profile';
import { CustomerRoute } from './Routers/CustomerRoute';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getUser } from './component/State/Authentication/Action';

function App() {
  const dispatch = useDispatch();
  const jwt = localStorage.getItem("jwt"); // Corrected line
  const { auth } = useSelector(store => store.auth);
  
  useEffect(() => {
    dispatch(getUser(auth?.jwt || jwt)); // Ensure proper chaining in case auth is undefined
  }, [auth?.jwt]);

  return (
    <ThemeProvider theme={darkTheme}>
    <CssBaseline/>
      {/* <Navbar/> */}

      <CustomerRoute/>
    </ThemeProvider>
  );
}

export default App;

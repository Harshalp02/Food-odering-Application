import React from 'react';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { Button } from '@mui/material';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { logout } from '../State/Authentication/Action';

export const UserProfile = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleLogOut = () => {
    // Clear JWT from localStorage
    localStorage.removeItem("jwt");

    // Dispatch the logout action
    dispatch(logout());

    // Navigate the user to the homepage or login page
    navigate("/");
  };

  return (
    <div className='min-h-[80vh] flex flex-col justify-center items-center text-center'>
      <div className="flex flex-col items-center justify-center">
        <AccountCircleIcon sx={{fontSize:"9rem"}}/>
        <h1 className="py-5 text-2xl font-semibold">Code With Harshal</h1>
        <p>Email: hkpatil2002@gmail.com</p>
        <Button variant="contained" onClick={handleLogOut} sx={{margin:"2rem 0rem"}}>Logout</Button>
      </div>
    </div>
  );
};

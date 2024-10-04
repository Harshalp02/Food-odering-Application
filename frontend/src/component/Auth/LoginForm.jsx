import { useEffect } from 'react';
import { Button, TextField, Typography } from '@mui/material';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { loginUser } from '../State/Authentication/Action';

const initialValues = {
    email: "",
    password: ""
};

export const LoginForm = () => {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const { auth } = useSelector(state => state);  // Ensure state is correct here

    // Log the state for debugging
    console.log("Current auth state:", auth);

    const handleSubmit = (values) => {
        dispatch(loginUser({ userData: values, navigate }));
    };

    useEffect(() => {
        if (auth.user) {
            // Log navigation trigger
            console.log("User detected, navigating to the correct page. User role:", auth.user.role);
            
            if (auth.user.role === "ROLE_RESTAURANT_OWNER") {
                navigate("/admin/restaurant");
            } else {
                navigate("/");
            }
        }
    }, [auth.user, navigate]); // Trigger on user update

    return (
        <div>
            <Typography variant='h5' className='text-center'>
                Login
            </Typography>
            <Formik onSubmit={handleSubmit} initialValues={initialValues}>
                <Form>
                    <Field
                        as={TextField}
                        name="email"
                        label="Email"
                        fullWidth
                        variant="outlined"
                        margin="normal"
                    />
                    <Field
                        as={TextField}
                        name="password"
                        label="Password"
                        fullWidth
                        variant="outlined"
                        margin="normal"
                        type="password"  // Ensure it's a password field
                    />
                    <Button sx={{ mt: 2, padding: "1rem" }} fullWidth type='submit' variant='contained'>
                        Login
                    </Button>
                </Form>
            </Formik>
            <Typography variant='body2' align='center' sx={{ mt: 3 }}>
                Don't have an Account?
                <Button size="small" onClick={() => navigate("/account/register")}>register</Button>
            </Typography>
        </div>
    );
};

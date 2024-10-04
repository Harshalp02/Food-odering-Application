import { Button, FormControl, InputLabel, MenuItem, Select, TextField, Typography } from '@mui/material';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import React from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { registerUser } from '../State/Authentication/Action';

const initialValues = {
    fullName: "",
    email: "",
    password: "",
    role: "ROLE_CUSTOMER"
};

export const RegistrationForm = () => {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const handleSubmit = (values) => {
        dispatch(registerUser({ userData: values, navigate }));
    };

    return (
        <div>
            <Typography variant='h5' className='text-center'>
                Register
            </Typography>
            <Formik onSubmit={handleSubmit} initialValues={initialValues}>
                {({ touched, errors }) => ( // Destructure touched and errors from Formik
                    <Form>
                        <Field
                            as={TextField}
                            name="fullName"
                            label="Full Name"
                            fullWidth
                            variant="outlined"
                            error={touched.fullName && Boolean(errors.fullName)}  // Check for error
                            helperText={
                                <ErrorMessage name="fullName" component="span" className="text-red-600" />
                            }
                            margin="normal"
                        />
                        <Field
                            as={TextField}
                            name="email"
                            label="Email"
                            fullWidth
                            variant="outlined"
                            error={touched.email && Boolean(errors.email)}  // Check for error
                            helperText={
                                <ErrorMessage name="email" component="span" className="text-red-600" />
                            }
                            margin="normal"
                        />
                        <Field
                            as={TextField}
                            name="password"
                            label="Password"
                            fullWidth
                            variant="outlined"
                            error={touched.password && Boolean(errors.password)}  // Check for error
                            helperText={
                                <ErrorMessage name="password" component="span" className="text-red-600" />
                            }
                            margin="normal"
                            type="password"
                        />
                        <FormControl fullWidth margin="normal">
                            <InputLabel id="role-simple-select-label">Role</InputLabel>
                            <Field
                                as={Select}
                                labelId="role-simple-select-label"
                                id="role-simple-select"
                                name="role"
                                label="Role"
                            >
                                <MenuItem value={"ROLE_CUSTOMER"}>Customer</MenuItem>
                                <MenuItem value={"ROLE_RESTAURANT_OWNER"}>Restaurant Owner</MenuItem>
                            </Field>
                        </FormControl>
                        <Button sx={{ mt: 2, padding: "1rem" }} fullWidth type='submit' variant='contained'>
                            Register  {/* Changed text from "Login" to "Register" */}
                        </Button>
                    </Form>
                )}
            </Formik>
            <Typography variant='body2' align='center' sx={{ mt: 3 }}>
                If you have an account already!
                <Button size="small" onClick={() => navigate("/account/login")}>Login</Button>
            </Typography>
        </div>
    );
};

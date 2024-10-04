import { Card, CardActions, CardContent, CardMedia, IconButton, Typography } from '@mui/material'
import React from 'react'
import DeleteIcon from '@mui/icons-material/Delete';
export const EventCart = () => {
  return (
    <div>
        <Card sx={{width:250}}>
            <CardMedia sx={{height:200}} image='https://images.pexels.com/photos/1279330/pexels-photo-1279330.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2'/>
            <CardContent>
                <Typography variant='h5'>
                    India Fast Food
                </Typography>
                <Typography variant='body2'>
                    50% off on your first order
                </Typography>
                <div className="py-2 space-y-2">
                    <p>{"mumbai"}</p>
                    <p className='text-sm text-blue-500'>February 14, 2024 12.00 AM</p>
                    <p className='text-sm text-red-500'>February 15, 2024 12.00 AM</p>
                    
                </div>
            </CardContent>
           {true && <CardActions>
            <IconButton>
                <DeleteIcon/>
            </IconButton>
           </CardActions>}
        </Card>
    </div>
  )
}

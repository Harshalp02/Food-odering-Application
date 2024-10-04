import { Card } from '@mui/material'
import React from 'react'
import { Button } from '@mui/material';

export const OrderCart = () => {
  return (
    <Card className="flex justify-between items-center p-5">
     
            <div className="flex items-center space-x-5">
                <img className='h-16 w-16'
                 src="https://cdn.pixabay.com/photo/2016/11/29/04/00/bread-1867208_1280.jpg" alt="" />
                <div>
                    <p>Biryani</p>
                    <p>₹399</p>
                </div>
            </div>

            <div>
                <Button className='cursor-not-allowed'>completed</Button>
            </div>
    </Card>
  )
}

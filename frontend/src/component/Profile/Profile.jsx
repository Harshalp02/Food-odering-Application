import React, { useState } from 'react'
import { ProfileNavigation } from './ProfileNavigation'
import { Route, Routes } from 'react-router-dom'
import { UserProfile } from './UserProfile'
import { Address } from './Address'
import { Orders } from './Orders'
import { Favorites } from './Favorites'
import { Event } from './Event'
import { Payment } from './Payment'
import { Navbar } from '../Navbar/Navbar'


export const Profile = () => {
    const [openSideBar,setOpenSideBar]=useState(false)
  return (
    <>

 
    <Navbar/>
    <div className='lg:flex justify-between'>
        <div className="sticky h-[80vh] lg:-[20%]">
            <ProfileNavigation open={openSideBar}/>
        </div>
        <div className="lg:w-[80%]">
          <Routes>
            <Route path='/' element={<UserProfile/>}/>
            <Route path='/orders' element={<Orders/>}/>
            <Route path='/address' element={<Address/>}/>
            <Route path='/favorites' element={<Favorites/>}/>
            <Route path='/event' element={<Event/>}/>
            <Route path='/payment' element={<Payment/>}/>
          </Routes>
        </div>
    </div>
    </>
  )
}
export default Profile;
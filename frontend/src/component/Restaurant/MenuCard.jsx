import { Accordion, AccordionDetails, AccordionSummary, Button, Checkbox, FormControlLabel, FormGroup } from '@mui/material'
import React from 'react'
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';

const ingredients = [
    {
        category: "Nuts & seeds",
        ingredients: ["Cashews"]
    },
    {
        category: "Protein",
        ingredients: ["Ground nuts", "Bacon strips"]
    },
    {
        category: "Protein",
        ingredients: ["Protein"]
    },
    {
        category: "Nuts & seeds",
        ingredients: ["Cashews"]
    },
];

export const MenuCard = () => {
    const handleCheckBoxChange=(value)=>{
        console.log(value);
    }
    return (
        <Accordion>
            <AccordionSummary
                expandIcon={<ExpandMoreIcon />}
                aria-controls="panel1-content"
                id="panel1-header"
            >
                <div className="lg:flex items-center justify-between">
                    <div className='lg:flex items-center lg:gap-5'>
                        <img className='w-[7rem] h-[7rem] object-cover'
                            src="https://images.pexels.com/photos/4109136/pexels-photo-4109136.jpeg?auto=compress&cs=tinysrgb&w=400" alt="" />
                        <div className="space-y-1 lg:space-y-5 lg:max-w-2xl">
                            <p className='font-semibold text-xl'>Burger</p>
                            <p>₹499</p>
                            <p className='text-gray-400'>nice foood</p>
                        </div>
                    </div>
                </div>
            </AccordionSummary>
            <AccordionDetails>
                <form >
                    <div className="flex gap-5 flex-wrap">
                        {
                            ingredients.map((item) => (
                                <div>
                                    <p>{item.category}</p>
                                    <FormGroup>
                                        {item.ingredients.map((item) => (
                                            <FormControlLabel control={<Checkbox onChange={()=>handleCheckBoxChange(item)}/>} label={item} />))}


                                    </FormGroup>
                                </div>
                            ))
                        }
                    </div>
                    <div className='pt-5'>
                        <Button variant='contained' disabled={false} type='submit'>{true?"Add to Cart":"Out of Stock"}</Button>
                    </div>
                </form>
            </AccordionDetails>
        </Accordion>
    )
}

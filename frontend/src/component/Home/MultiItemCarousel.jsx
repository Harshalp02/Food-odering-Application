import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import React from 'react'
import Slider from "react-slick";
import { topMeal } from "./topMeal";
import { CarouselItem } from "./CarouselItem";
export const MultiItemCarousel = () => {
    const settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 5,
        slidesToScroll: 1,
        autoplay:true,
        autoplaySpeed:2000,
        arrows:false
      };
  return (
    <div>
        <Slider {...settings}>
            {topMeal.map((item)=>(<CarouselItem
            image={item.image}
            title={item.title}/>
            ))}
        </Slider>
    </div>
  )
}

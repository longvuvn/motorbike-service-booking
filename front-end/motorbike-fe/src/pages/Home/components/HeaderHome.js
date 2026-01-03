import React from "react";
import { Link } from "react-router-dom";
import heroBike from "../../../assets/image/anh-xe-moto-do_041858346-removebg-preview.png";

export default function HeaderHome() {
  return (
    <section className="relative min-h-screen bg-gradient-to-br from-black via-gray-900 to-red-950 text-white overflow-hidden flex items-center">
      <div className="max-w-7xl mx-auto px-4 md:px-10 py-10 md:py-20 grid grid-cols-1 lg:grid-cols-2 gap-12 items-center w-full">
        <div className="z-10 space-y-8">
          <h1 className="text-2xl md:text-4xl lg:text-4xl font-black leading-tight">
            Find Your Safe
            <br />
            <span className="text-red-600">Destination</span> With Us
          </h1>
          <p className="text-gray-300 text-lg md:text-xl max-w-lg leading-relaxed">
            At BikeCare Hub, your bike is in expert hands. With our commitment
            to precision, quality, and customer satisfaction we ensure every
            repair is done right the first time.
          </p>
          <Link
            to="/services"
            className="inline-block bg-red-600 hover:bg-red-700 text-white px-10 py-5 rounded-md font-bold text-xl transition-all transform hover:scale-105 shadow-lg"
          >
            Book Now
          </Link>
        </div>
        
        <div className="relative z-10 flex justify-center lg:justify-end">
          <img
            src={heroBike}
            alt="Sport Motorcycle"
            className="w-full max-w-3xl object-contain drop-shadow-[0_35px_70px_rgba(255,49,49,0.5)] transform hover:scale-105 transition-transform duration-500"
          />
        </div>
      </div>
      
      <div className="absolute inset-0 bg-gradient-to-r from-black/80 via-transparent to-black/60 pointer-events-none"></div>
    </section>
  );
}
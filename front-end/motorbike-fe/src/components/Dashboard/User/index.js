import React, { useState } from "react";
import { Link } from "react-router-dom";
import Logo from "../../Logo/logo-primary";

export default function User() {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  return (
    <nav
      className="fixed top-0 left-0 w-full h-44 flex justify-center items-center text-white z-50 bg-gradient-to-b from-black/60 to-transparent">
      <div className="hidden md:flex justify-center items-center gap-x-12 lg:gap-x-80 w-full">
        <div className="flex space-x-4 lg:space-x-8">
          <Link
            to="/"
            className="group relative py-2 font-bold uppercase tracking-widest text-xs transition-colors hover:text-red-500"
          >
            Home
            <span className="absolute bottom-0 left-0 h-0.5 w-0 bg-red-500 transition-all group-hover:w-full"></span>
          </Link>
          <Link
            to="/services"
            className="group relative py-2 font-bold uppercase tracking-widest text-xs transition-colors hover:text-red-500"
          >
            Service
            <span className="absolute bottom-0 left-0 h-0.5 w-0 bg-red-500 transition-all group-hover:w-full"></span>
          </Link>
          <Link
            to="/product"
            className="group relative py-2 font-bold uppercase tracking-widest text-xs transition-colors hover:text-red-500"
          >
            Product
            <span className="absolute bottom-0 left-0 h-0.5 w-0 bg-red-500 transition-all group-hover:w-full"></span>
          </Link>
        </div>
        <div className="flex justify-center items-center transform transition-transform hover:scale-105">
          <Logo variant="white" height={45} />
        </div>
        <div className="flex items-center space-x-6 lg:space-x-14">
          <Link
            to="/login"
            className="group relative py-2 font-bold uppercase tracking-widest text-xs hover:text-red-500 transition-colors"
          >
            Login
            <span className="absolute bottom-0 left-0 h-0.5 w-0 bg-red-500 transition-all group-hover:w-full"></span>
          </Link>
          <Link
            to="/register"
            className="group relative py-2 font-bold uppercase tracking-widest text-xs hover:text-red-500 transition-colors"
          >
            Register Now
            <span className="absolute bottom-0 left-0 h-0.5 w-0 bg-red-500 transition-all group-hover:w-full"></span>
          </Link>
        </div>
      </div>

      <div className="md:hidden flex justify-between items-center w-full">
        <div className="flex items-center transform transition-transform hover:scale-105">
          <Logo variant="white" height={35} />
        </div>
        <button
          onClick={() => setIsMenuOpen(!isMenuOpen)}
          className="text-white focus:outline-none"
        >
          <svg
            className="w-6 h-6"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d={
                isMenuOpen ? "M6 18L18 6M6 6l12 12" : "M4 6h16M4 12h16M4 18h16"
              }
            />
          </svg>
        </button>
      </div>
      {isMenuOpen && (
        <div className="md:hidden absolute top-20 left-0 w-full bg-[#0f172a] border-t border-gray-700 shadow-lg">
          <div className="flex flex-col space-y-4 px-4 py-6">
            <Link
              to="/"
              className="font-bold uppercase tracking-widest text-xs hover:text-red-500 transition-colors"
              onClick={() => setIsMenuOpen(false)}
            >
              Home
            </Link>
            <Link
              to="/services"
              className="font-bold uppercase tracking-widest text-xs hover:text-red-500 transition-colors"
              onClick={() => setIsMenuOpen(false)}
            >
              Service
            </Link>
            <Link
              to="/services"
              className="font-bold uppercase tracking-widest text-xs hover:text-red-500 transition-colors"
              onClick={() => setIsMenuOpen(false)}
            >
              Product
            </Link>
            <Link
              to="/login"
              className="font-bold uppercase tracking-widest text-xs hover:text-red-500 transition-colors"
              onClick={() => setIsMenuOpen(false)}
            >
              Login
            </Link>
            <Link
              to="/register"
              className="bg-red-600 text-white px-4 py-2.5 rounded-sm font-black uppercase tracking-tighter text-xs transition-all transform hover:-translate-y-0.5 active:translate-y-0 shadow-[4px_4px_0px_0px_rgba(255,255,255,0.2)] inline-block text-center"
              onClick={() => setIsMenuOpen(false)}
            >
              Register Now
            </Link>
          </div>
        </div>
      )}
    </nav>
  );
}

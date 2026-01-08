import { createContext } from "react";
import React from 'react'


export const AuthContext = createContext();
export default function useAuth() {
  return (
    <AuthContext.Provider>
        
        
    </AuthContext.Provider>
  )
}
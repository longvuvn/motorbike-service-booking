import React from 'react'
import User from '../Dashboard/User'
import Admin from '../Dashboard/Admin'
import {Route, Routes } from 'react-router-dom'

export default function Header() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<User />} />
        <Route path="/admin" element={<Admin />} />
      </Routes>
    </div>
  )
}

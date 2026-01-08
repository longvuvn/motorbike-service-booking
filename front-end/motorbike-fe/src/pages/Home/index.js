import React from "react";
import HeaderHome from "./components/HeaderHome";
import BodyHome from "./components/BodyHome";

export default function Home() {
  return (
    <div className="min-h-screen bg-gray-50">
      <HeaderHome />
      <BodyHome />
    </div>
  );
}

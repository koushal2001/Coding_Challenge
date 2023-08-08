import React, { Component, Suspense } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Redirect,
} from "react-router-dom";
import { connect } from "react-redux";

// import Auth from '../src/components/Auth/Auth'

const Auth = React.lazy(() => import("./components/Auth/Auth"));
const Hello = React.lazy(() => import("./components/Hello1"));
const Dashboard = React.lazy(() => import("./components/Dashboard/Dashboard"));


 const routes = () => {
  return (
    <Router>
        <Suspense >
        <Routes>
          <Route exact path="/" element={<Auth/>}/>
          <Route exact path="/hello" element={<Hello/>}/>
          <Route exact path="/dashboard" element={<Dashboard/>}/>
          
          
        </Routes>
        </Suspense>
      </Router>
  )
}

export default routes

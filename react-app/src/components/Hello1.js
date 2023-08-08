import React from 'react'
import { hello } from '../actions'
import { connect } from "react-redux";
import { useEffect, useState } from "react";

const Hello1 = (props) => {

  useEffect(() => {
    
    props.displayHello();
  }, []);
  return (
    <>


    </>
  )
}

const mapStateToProps = (state) => {
    return {
      message: state.hello.message,
      
    };
  };
  
  const mapDispatchToProps = (dispatch) => ({
   
    displayHello: () => dispatch(hello.displayHello()),
    
  });
  
  export default connect(mapStateToProps, mapDispatchToProps)(Hello1);
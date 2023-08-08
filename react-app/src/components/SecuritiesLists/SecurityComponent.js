import React, { useState,useEffect } from 'react'
// import { Card } from 'antd'
import logo from '../BondLists/companylogo.png'
import '../BondLists/tc.css'
import axios from 'axios'
// import 'bootstrap/dist/css/bootstrap.min.css';

const SecurityComponent = ({Id,ISIN,CUSIP,Issuer,MaturityDate,Coupon,Type,FaceValue,Status}) => {
const [form,setForm] = useState(false)
const [minDate, setminDate] = useState(null)
const [selectedOption, setSelectedOption] = useState('');
const [data,setData]=useState({Id:'',ISIN:'',CUSIP:'',Issuer:'',MaturityDate:'',Coupon:'',Type:'',FaceValue:'',Status:''})
const handleSelectChange = (e) => {
  setSelectedOption(e.target.value);
};
useEffect(()=>{
  setData({Id:{Id},ISIN:{ISIN},CUSIP:{CUSIP},Issuer:{Issuer},MaturityDate:{MaturityDate},Coupon:{Coupon},Type:{Type},FaceValue:{FaceValue},Status:{Status}})
},[])
 useEffect(() => {
    const today = new Date().toISOString().split('T')[0];

    setminDate(today)
  }, []);
const showForm = ()=>{
  
  return(
    <div className="container">
      <div className="row justify-content-center mt-5">
        <div className="col-md-6">
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="maturityDate">Maturity Date</label>
              <input
                type="date"
                className="form-control"
                id="maturityDate"
                name="maturityDate"
                min={minDate}
                value={formData.maturityDate}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="coupon">Coupon</label>
              <input
                type="number"
                className="form-control"
                id="coupon"
                name="coupon"
                value={formData.coupon}
                onChange={handleChange}
                required
              />
            </div>
            <label htmlFor="coupon">Type</label>
             <div className="form-group">
              <select
              className="form-control"
              id="dropdown"
              value={selectedOption}
              onChange={handleSelectChange}
            >
              <option value="">Choose...</option>
              <option value="option1">Government</option>
              <option value="option2">Corporate</option>
            </select>
              {/* <input
                type="text"
                className="form-control"
                id="type"
                name="type"
                value={formData.type}
                onChange={handleChange}
                required
              /> */}
            </div>
             <div className="form-group">
              <label htmlFor="status">Status</label>
              <input
                type="text"
                className="form-control"
                id="status"
                name="status"
                value={formData.status}
                onChange={handleChange}
                required
              />
            </div>
             <div className="form-group">
              <label htmlFor="faceValue">Face Value</label>
              <input
                type="number"
                className="form-control"
                id="faceValue"
                name="faceValue"
                value={formData.faceValue}
                onChange={handleChange}
                required
              />
            </div>
            <button type="submit" className="btn btn-dark" onClick={handleSubmit}>Submit</button>
          </form>
        </div>
      </div>
    </div>
  );
}
const [formData, setFormData] = useState({
    maturityDate: '',
    coupon: '',
    type: '',
    status: '',
    faceValue: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    const {maturityDate}=formData
    console.log('Form data submitted:', formData);
    setData((prevData)=>({...prevData,MaturityDate:maturityDate}))
    setForm(false)
    // You can perform further actions with the form data, like sending it to a server.
  };
  return (
   <div className="Card">
<div className="company">
  <img src={logo} alt='company logo' style={{width:"10rem"}}/>
  <h2>Company Name</h2>
</div>
<div className='tradedata'>
  <div className="d1">
    <p className='p1'>Regular Income</p>
    <p className='p1'>NBFC Retail Bond</p>
  </div>

  <div className='d2'>
    <p className='p2'>Maturity Date</p>
    <p className='p2'>Type</p>
    <p className='p2'>Status</p>
    <p className='p2' >Face Value</p>
    <p className='p2'>Issuer</p>
  </div>
  <div className='d2'>
    <p className='p2' >{MaturityDate}</p>
    <p className='p2' >{Type}</p>
    <p className='p2' >{Status}</p>
    <p className='p2' >{FaceValue}</p>
    <p className='p2' >{Issuer}</p>
  </div>
  <div className='buttons'>
    <button className='b1'onClick={()=>setForm(!form)}>Update</button>
    
    <button className='b1'>Get Trades</button>
  </div>
  <div>{form?showForm():null}</div>
</div>
   </div>
  )
}

export default SecurityComponent



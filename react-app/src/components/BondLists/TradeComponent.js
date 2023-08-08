import React, { useState ,useEffect} from 'react'
// import { Card } from 'antd'
import logo from './companylogo.png'
import './tc.css'
// import 'bootstrap/dist/css/bootstrap.min.css';

const TradeComponent = ({Id,Trade_Date}) => {
const [form,setForm] = useState(false)
const [formData, setFormData] = useState({
  counterpartyId: '',
  quantity: '',
  status: '',
  price: '',
  settlementDate: '',
});
useEffect(() => {
  const today = new Date().toISOString().split('T')[0];

  setminDate(today)
}, []);
const [minDate, setminDate] = useState(null)
const showForm = () =>{
  return(
    <div className="container">
      <div className="row justify-content-center mt-5">
        <div className="col-md-6">
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="counterpartyId">Counterparty ID</label>
              <input
                type="text"
                className="form-control"
                id="counterpartyId"
                name="counterpartyId"
                value={formData.counterpartyId}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="quantity">Quantity</label>
              <input
                type="number"
                className="form-control"
                id="quantity"
                name="quantity"
                value={formData.quantity}
                onChange={handleChange}
                required
              />
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
              <label htmlFor="price">Price</label>
              <input
                type="number"
                className="form-control"
                id="price"
                name="price"
                value={formData.price}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="settlementDate">Settlement Date</label>
              <input
                type="date"
                className="form-control"
                id="settlementDate"
                name="settlementDate"
                value={formData.settlementDate}
                onChange={handleChange}
                min={minDate}
                required
              />
            </div>
            <button type="submit" className="btn btn-dark">Submit</button>
          </form>
        </div>
      </div>
      </div>
  );
}
const handleChange = (e) => {
  const { name, value } = e.target;
  setFormData((prevData) => ({ ...prevData, [name]: value }));
};

const handleSubmit = (e) => {
  e.preventDefault();
  console.log('Form data submitted:', formData);
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
    <p className='p2'>Quantity</p>
    <p className='p2'>Status</p>
    <p className='p2'>Price</p>
    <p className='p2' >Security</p>
    <p className='p2'>Settlement Date</p>
  </div>
  <div className='d2'>
    <p className='p2' >Quantity</p>
    <p className='p2' >Status</p>
    <p className='p2' >Price</p>
    <p className='p2' >Security</p>
    <p className='p2' >Settlement Date</p>
  </div>
  <div className='buttons'>
    <button className='b1'onClick={()=>setForm(!form)}>Update</button>
{/*     
    <button className='b1'>Get Securities</button> */}
  </div>
  <div>{form?showForm():null}</div>
</div>
   </div>
  )
}

export default TradeComponent



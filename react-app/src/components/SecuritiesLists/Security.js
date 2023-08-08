import { useEffect, useState } from 'react'
import React from 'react'
import { getAllSecurities } from '../../services/SecurityServices'
import {trades} from '../BondLists/resource'
import SecurityComponent from './SecurityComponent'
const Security = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    getAllSecurities()
          .then(({data}) => {
          setData(data);
          });
  }, []);
    console.log(data);
    // useEffect(()=>{
    //   setData(trades.resources)
    // },[data])
  return (
    <div><h2>SecurityList component</h2>
    <SecurityComponent Id='1' ISIN='1' CUSIP='1' Issuer='A' MaturityDate='A' Coupon='1' Type='1' FaceValue='1' Status='1'/>
            {data.map((res)=>{
            const {Id,ISIN,CUSIP,Issuer,MaturityDate,Coupon,Type,FaceValue,Status}=res
             return <SecurityComponent  Id={Id} ISIN={ISIN} CUSIP={CUSIP} Issuer={Issuer} MaturityDate={MaturityDate} Coupon={Coupon} Type={Type} FaceValue={FaceValue} Status={Status}/>
        })}
   
  </div>
  )
}

export default Security
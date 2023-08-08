import { useEffect, useState } from 'react'
import React from 'react'

import {trades} from './resource'
import TradeComponent from './TradeComponent'
const TradeList = () => {
   const [data, setData] = useState(trades.resources)
    console.log(data)
    useEffect(()=>{
      setData(trades.resources)
    },[data])
  return (
    <div><h2>TradeList component</h2>
        {data.map((res)=>{
            const {Id,Trade_Date}=res
             return <TradeComponent  Id={Id} Trade_Date={Trade_Date}/>
        })}
   
  </div>
  )
}

export default TradeList
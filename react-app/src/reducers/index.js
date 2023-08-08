import { combineReducers } from 'redux'
import auth from './auth'
import hello from './hello'
import dashboard from './dashboard'


export default combineReducers({
    auth,
    hello,
    dashboard
   
})
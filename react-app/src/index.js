import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Auth from './components/Auth/Auth';
import reportWebVitals from './reportWebVitals';
import thunk from 'redux-thunk'
import { createStore, applyMiddleware, compose } from 'redux'


import { Provider } from 'react-redux'
import reducers from './reducers'
import Routes from './routes'


const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

export const store = createStore(
  reducers,
  composeEnhancers(applyMiddleware(thunk))
)

const rootElement = document.getElementById('root')

if (rootElement.hasChildNodes()) {
    ReactDOM.hydrate(
        <Provider store={store}>
            <Routes />
        </Provider>,
        rootElement
    )
} else {
    ReactDOM.hydrate(
        <Provider store={store}>
            <Routes />
        </Provider>,
        rootElement
    )
}

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <Auth />
//   </React.StrictMode>
// );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

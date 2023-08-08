import { createStore, applyMiddleware, compose } from 'redux';
import ReduxThunk from 'redux-thunk';
import RootReducer from './reducers';

export const middlewares = [ReduxThunk];

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

export const createStoreWithMiddleware = composeEnhancers(applyMiddleware(...middlewares))(createStore)

export const store = createStoreWithMiddleware(RootReducer)
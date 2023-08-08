import { DATA } from "../constants/dashboard";

const initialState = {
  message: null,
  bondsData:null
};

export default function auth(state = initialState, action) {
  switch (action.type) {
    case DATA:
      return { ...state, bondsData:action.data };

    default:
      return state;
  }
}

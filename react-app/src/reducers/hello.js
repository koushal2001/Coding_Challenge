import { DISPLAY } from "../constants/hello";

const initialState = {
  message: null,
};

export default function auth(state = initialState, action) {
  switch (action.type) {
    case DISPLAY:
      return { ...state, message: 'jai' };

    default:
      return state;
  }
}

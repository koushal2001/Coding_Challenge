import axios from "axios";

import { DISPLAY } from "../constants/hello";

export const displayHello = () => async (dispatch ) => {
    let headers = {
        'Content-Type': 'application/json',
    }
  try {
    let response = await axios.get(
      `https://jsonplaceholder.typicode.com/posts`,
      { headers }
    );
    if (response.status === 200) {
        console.log(response)
      return dispatch({ type: DISPLAY, data: response.data });
    }
  } catch (error) {
    throw error;
  }
};

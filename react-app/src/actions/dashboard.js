import axios from "axios";

import { DATA } from "../constants/dashboard";

export const getBondsStat = () => async (dispatch ) => {
    let headers = {
        'Content-Type': 'application/json',
    }
  try {
    let response = await axios.get(
      `http://localhost:8080/api/securities`,
      { headers }
    );
    if (response.status === 200) {
        console.log(response)
      return dispatch({ type: DATA, data: response.data });
    }
  } catch (error) {
    throw error;
  }
};

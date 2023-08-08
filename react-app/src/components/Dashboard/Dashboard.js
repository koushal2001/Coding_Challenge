import React from "react";
import { useState } from "react";
import styles from "./dashboard.module.scss";
import { Link } from "react-router-dom";
import TradeComponent from "../BondLists/TradeComponent";
import { dashboard } from '../../actions'
import { connect } from "react-redux";
import {
  Table,
  TableBody,
  TableHead,
  TableRow,
  TableCell,
  Checkbox,
  TableContainer,
  Paper,
  TablePagination,
  Toolbar,
  Typography,
  IconButton,
} from "@material-ui/core";
import {
  Input,
  DatePicker,
  Select,
  message,
  Tooltip,
  Form,
  Button,
  Tag,
  Radio,
  // Checkbox,
} from "antd";
import { Container, TextField } from "@mui/material";
import { useEffect } from "react";
function Dashboard(props) {
  const { Search } = Input;
  // const addNewMember = () => {

  // };

  useEffect(() => {
    
    props.getBondsStat();
  }, []);

  const onSearch = (value) => console.log(value);

  const [searchTerm, setSearchTerm] = useState("");

  const handleChange = (event) => {
    setSearchTerm(event.target.value);
    console.log(searchTerm);
  };

  const handleMobileSearch = () => {};
  return (
    <>
      <div className={styles.container}>
        <div className={styles.stat_container}>
          <div className={styles.stat_member}>
            Active Members
            <div className={styles.Number}> 4</div>
          </div>

          <div className={styles.stat_member}>
            Inactive Members
            <div className={styles.Number}> 4</div>
          </div>

          <div className={styles.stat_member}>
            Next Month Due
            <div className={styles.Number}> 4</div>
          </div>

          <div className={styles.stat_member}>
            Sold This Month
            <div className={styles.Number}>4</div>
          </div>
        </div>
        <div className={styles.header}>
          <div style={{ paddingTop: "1rem" }}>
            <Typography color="inherit" variant="h6" component="div">
              Bonds &nbsp;
            </Typography>
          </div>
          <div className={styles.searchbox}>
            <Container>
              <TextField
                id="search"
                type="search"
                label="Search"
                value={searchTerm}
                onChange={handleChange}
                sx={{ width: 400 }}
              />
            </Container>
          </div>
        </div>

        <TradeComponent />
      </div>
    </>
  );
}

const mapStateToProps = (state) => {
  return {
    bondsData : state.dashboard.bondsData,
    
  };
};

const mapDispatchToProps = (dispatch) => ({
 
  getBondsStat: () => dispatch(dashboard.getBondsStat()),
  
});

export default connect(mapStateToProps, mapDispatchToProps)(Dashboard);



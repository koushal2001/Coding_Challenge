import React from "react";
import { useState } from "react";
import styles from "./dashboard.module.scss";
import { Link } from "react-router-dom";
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

function Dashboard(props) {
  const { Search } = Input;
  // const addNewMember = () => {

  // };


  const onSearch = (value) => console.log(value);


  const [searchTerm, setSearchTerm] = useState('');

  const handleChange = (event) => {
    setSearchTerm(event.target.value);
    console.log(searchTerm)
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
            <Container >
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
        

        {/* <div className={styles.header}>
          <div style={{ paddingTop: "1rem" }}>
            <Typography color="inherit" variant="h6" component="div">
              Members &nbsp;
            </Typography>
          </div>
          <div className={styles.searchbox}>
            <Input.Search
              placeholder="Search by #,Name/Member type"
              style={{ width: "auto" }}
              // onSearch={handleMobileSearch}
            />
          </div>
          <div>
            <Button
              style={{
                color: "white",
                background: "#2049A6",
                //width: "8rem",
                marginTop: "1rem",
              }}
              // onClick={addNewMember}
            >
              {" "}
              Add New Member
            </Button>
            <Button
              style={{
                color: "white",
                background: "#2049A6",
                marginTop: "1rem",
                marginLeft: "1rem",
              }}
              // onClick={redeemCoupon}
            >
              Redeem Coupon
            </Button>
          </div>
        </div> */}
        {/* //{props.membersData ? showMembers() : <Preloader />} */}

         
      </div>
    </>
  );
}

export default Dashboard;

import React, {Component} from 'react';
import {Container} from "reactstrap";
import Select from "@material-ui/core/Select";
import FormControl from "@material-ui/core/FormControl"
import MenuItem from '@material-ui/core/MenuItem';


import './header-footer.css';
import logo from'./resources/pathfinder.png'

export default class Header extends Component {

    render() {
        return (
            <div className="full-width header">
                <div className="vertical-center">
                    <Container>
                        <div className="vertical-center">
                            <img className="logo" src={logo} alt="Pathfinder Role Playing Games"/>
                        </div>
                        <div className="page-select">
                            <FormControl style={{margin:"auto"}}>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    value={this.props.selectedPage}
                                    onChange={this.props.togglePages}
                                >
                                    <MenuItem value={"Basic Info"}>Basic Info</MenuItem>
                                    <MenuItem value={"Equipment"}>Equipment</MenuItem>
                                    <MenuItem value={"Combat"}>Combat</MenuItem>
                                </Select>
                            </FormControl>
                        </div>
                    </Container>
                </div>
            </div>
        );
    }
}
import React, {Component} from "react";
import {Collapse} from "reactstrap"
import './App.css';
import Header from "./Margins/Header"

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedPage: "Basic Info"
    }
    this.togglePages = this.togglePages.bind(this);
  }

  render(){
    return (
        <div className="App">
          <Header togglePages={this.togglePages} selectedPage={this.state.selectedPage}/>
          <Collapse isOpen={this.state.selectedPage=="BasicInfo"}></Collapse>
        </div>
    );
  }

  togglePages(newSelection){
    newSelection = newSelection.target.value;
    this.setState({selectedPage: newSelection});
  }
}


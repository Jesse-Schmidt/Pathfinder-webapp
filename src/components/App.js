import React, {Component} from "react";
import {Collapse} from "reactstrap"
import './App.css';
import Header from "./Margins/Header"

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedPage: 0,
      pageList: ["Basic Info", "Equipment", "Combat"]
    }
    this.togglePages = this.togglePages.bind(this);
  }

  render(){
    return (
        <div className="App">
          <div className="coolBorder">
            <Header  togglePages={this.togglePages} selectedPage={this.state.selectedPage} pageList={this.state.pageList}/>
          </div>
          <div className="pageBody">
              <p>this is where the permanent info goes.</p>
              <p>IE name, class, health, xp</p>
              <Collapse isOpen={this.state.selectedPage === 0}>
                  <p>this is where the basic info goes</p>
                  <p>IE ability scores, skills</p>
              </Collapse>
              <Collapse isOpen={this.state.selectedPage === 1}>
                  <p>this is where the equipment info goes</p>
                  <p>IE permanent equipment, potions, shopping screen</p>
              </Collapse>
              <Collapse isOpen={this.state.selectedPage === 2}>
                  <p>this is where the combat screen goes</p>
                  <p>IE weapons, combat abilities, ac</p>
              </Collapse>
          </div>
        </div>
    );
  }

  togglePages(newSelection){
    newSelection = newSelection.target.value;
    console.log(newSelection);
    this.setState({selectedPage: newSelection});
  }
}


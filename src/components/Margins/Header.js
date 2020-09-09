import React, {Component} from 'react';
import {Container} from "reactstrap";
import {renderDropdown} from '../../utils/HelpfulFunctions.js'

import './header-footer.css';
import logo from './resources/pathfinder.png'
import spacing from './resources/spacing.png'

export default class Header extends Component {

    render() {
        return (
            <div className="full-width header">
                <Container>
                    <div className="vertical-center">
                        <img className="spacer" src={spacing} alt="cool red line" />
                        <img className="logo" src={logo} alt="Pathfinder Role Playing Games"/>
                        <img className="spacer" src={spacing} alt="cool red line" />
                    </div>
                    <div className="page-select">
                        {renderDropdown("pageSelect", this.props.selectedPage, this.props.togglePages, this.props.pageList)}
                    </div>
                </Container>
            </div>
        );
    }
}
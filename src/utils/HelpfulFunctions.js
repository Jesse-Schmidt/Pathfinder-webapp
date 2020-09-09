import React from 'react'
import Select from "@material-ui/core/Select";
import FormControl from "@material-ui/core/FormControl"
import MenuItem from '@material-ui/core/MenuItem';

export function renderDropdown(name, value, handle, listToDisplay) {
    return (
        <FormControl style={{margin:"auto"}}>
            <Select
                labelId="demo-simple-select-label"
                id={name} value={value}
                onChange={handle}>
                {generateUnitsList(listToDisplay)}
            </Select>
        </FormControl>
    )
}

export function generateUnitsList(units) {
    let listOfUnits = [];
    for (let i = 0; i < units.length; i++) {
        listOfUnits.push(<MenuItem key={'Page' + i} value={i}>{units[i]}</MenuItem>)
    }
    return(listOfUnits)
}
import React, {useState, useEffect} from "react";

function getSaveValue(key, initialValue){
    const savedValue = JSON.parse(localStorage.getItem(key));
    if(savedValue){
        return savedValue
    }else{
        return initialValue;
    }
}

export default function useLocalStorage(key, initivalValue){
    let[value, setValue] = useState(() => {
        return getSaveValue(key, initivalValue);
    });

    useEffect(() => {
        localStorage.setItem(key, JSON.stringify(value));
    })

    return [value, setValue];
}
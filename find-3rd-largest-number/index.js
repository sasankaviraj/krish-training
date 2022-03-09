const prompt = require('prompt-sync')();
const {of,map} =require('rxjs');
let input = prompt('Enter the number sequence with spaces: ');

if(checkValidity(input)){
    let numberArr = input.split(' ');
    numberArr = sortDescending(numberArr);

    console.log('3rd Largest number of the sequence is '+numberArr[2]);
}


function sortDescending(numberArr){
    of(numberArr).pipe(
        map((result)=>{
            result.sort((i,j)=>{
                return Number(i) > Number(j) ? -1 : 1;
            });
            numberArr = result;
            return result;
        })
    ).subscribe();

    return numberArr;
}

function checkValidity(input){
    let isValid = true;
    let regexForSpcChar = new RegExp("[^a-zA-Z0-9. ]");
    let regexForLetters = new RegExp(".*[a-zA-Z.?].*");
    if(regexForSpcChar.test(input)){
        console.log('input numbers without special characters');
        isValid = false;
    }
    if(regexForLetters.test(input)){
        console.log('input only the numbers');
        isValid = false;
    }
    if (input.split(' ').length <= 3){
        console.log('input more than 3 numbers');
        isValid = false;
    }
    return isValid;
}

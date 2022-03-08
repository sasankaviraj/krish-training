const prompt = require('prompt-sync')();
const {map, from, of} = require("rxjs");
const alphabet = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',];

let word1 = prompt('Enter the first word: ');

let word2 = prompt('Enter the second word: ');

let validated = checkValidity(word1,word2);

let charIndexesWord1 = [];
let charIndexesWord2 = [];

if(validated){
    word1 = word1.toLowerCase();
    word2 = word2.toLowerCase();
    let word1CharArray = word1.split('');
    let word2CharArray = word2.split('');

    charIndexesWord2 = sort(word2CharArray);
    charIndexesWord1 = sort(word1CharArray);

    if (JSON.stringify(charIndexesWord1) === JSON.stringify(charIndexesWord2)){
        console.log('The given two words are anagram of each other')
    }else {
        console.log('The given two words are not anagram of each other')
    }
}

function sort(charArray){
    let sortedCharIndexes = [];
    from(charArray).pipe(
        map(letter => {
            sortedCharIndexes.push(alphabet.indexOf(letter));
        }),
    ).subscribe();

    of(sortedCharIndexes).pipe(
        map(result => {
            result.sort((i,j) => {
                return i < j ? -1 : 1;
            })
            return result;
        }),
    ).subscribe();

    return sortedCharIndexes;
}

function checkValidity(word1,word2){
    let isValid = true;
    let regex = new RegExp("[0-9]+");
    if (word1.length !== word2.length){
        isValid = false;
    }
    if (regex.test(word1) || regex.test(word2)){
        isValid = false;
    }
    return isValid;
}

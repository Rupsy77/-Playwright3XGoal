/*
Task

You are given a variable, . Your task is to print:

- ONE, if  is equal to .
- TWO, if  is equal to .
- THREE, if  is equal to .
- FOUR, if  is equal to .
- FIVE, if  is equal to .
- SIX, if  is equal to .
- SEVEN, if  is equal to .
- EIGHT, if  is equal to .
- NINE, if  is equal to .
- PLEASE TRY AGAIN, if  is none of the above.

Note: Do not declare the variable ; it is declared inside our code checker. Use console.log to print statements to the console.
*/
//console.log("Enter the number:");
//const num = require('fs').readFileSync(0, 'utf8').trim();
//console.log(num);
let num = 5; // change this value
switch (num) {
    case 1:
        console.log("ONE");
        break;
    case 2:
        console.log("TWO");
        break;
    case 3:
        console.log("THREE");
        break;
    case 4:
        console.log("FOUR");
        break;
    case 5:
        console.log("FIVE");
        break;
    case 6:
        console.log("SIX");
        break;
    case 7:
        console.log("SEVEN");
        break;
    case 8:
        console.log("EIGHT");
        break;
    case 9:
        console.log("NINE");
        break;
    default:
        console.log("PLEASE TRY AGAIN");
}
//let input = 85; // change this value
console.log("Enter the mark:");
const input = require('fs').readFileSync(0,'utf8');
if(input>90 && input<=100)
{
    console.log("AA");
}
else if(input>80 && input<= 90)
{
    console.log("AB");
}
else if(input>70 && input <= 80)
{
    console.log("BB");
}
else if(input>60 && input <= 70)
{
    console.log("BC");
}
else if(input>50 && input <= 60)
{
    console.log("CC");
}
else if(input>40 && input <= 50)
{
    console.log("CD");
}
else if(input>30 && input <= 40)
{
    console.log("DD");
}
else 
{
    console.log("FF");
}
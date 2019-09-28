x = 0; a = 0; b = 0;
while (x < 100) {
	x = x + 1;
}

str = "1;";

if (x == 5) {
	str = "a=".str;
} else {
	str = "b=".str;
}



eval(str);
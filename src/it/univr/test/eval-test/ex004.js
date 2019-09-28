x = 0; a = 0; b = 0;
while (x < 100) {
	x = x + 1;
}

if (x == 4) {
	str = "a=a+1;";
} else {
	str = "b=b+1;";
}

eval(str);
x = 0; str = "";a=0; b=0;
while (x < 5) {
	if (x < 3) {
		str = str."a=a+1;";
	} else {
		str = str."b=b+1;";
	}
	x = x + 1;
}

eval(str);

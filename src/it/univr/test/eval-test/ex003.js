i = 0; y = "";x=0;

while (i < 100) {
	y = y."x=x+1;";
	i=i+1;
}

eval(y);
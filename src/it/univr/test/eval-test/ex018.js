x = 0; y = 0; a = 0;
str = "a=a+1;";

while (y < 3) {
	y = y + 1;
	str = str."a=a+1;";
}


eval("while(a<10){".str."}");

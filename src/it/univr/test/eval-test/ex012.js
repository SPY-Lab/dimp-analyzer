x = 0; y = 0;
ds = "x=x+1;";

while (y < 3) {
	ds = ds."x=x+1;y=10;";
	y = y + 1;
}

if (y == 9) {
	ds = "while(x<5){y=x;}";
} else {}

eval(ds);

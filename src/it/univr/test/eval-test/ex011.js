x = 0; y = 0;
ds = "";

while (y < 3) {
	ds = ds."x=x+1;y=10;";
	y = y + 1;
}

if (y == 5) {
	ds = "hello(";
} else {}

if (y == 7) {
	ds = "while(y;";
} else {}

if (y == 9) {
	ds = "while(x < 5){y=x;}";
} else {}

eval(ds);

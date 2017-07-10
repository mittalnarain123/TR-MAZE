# TR-MAZE

This is a Java project to implement the Maze Problem. A maze consists of Walls and Aisles. The program Uses Depth First Search algorithm to find a path from start to finish traversing thru the aisles.

## Getting Started

The input data for the program includes: 

- Maze definition in a 2D array representation (0 for Aisle, 1 for Wall), 
- Maze entrance point
- Maze exit point

Output:
- True if a path available from start to end
- False if no path available from start to end
- There is also a display() method which prints the pictorial representation of the Maze along with the selected solution. 

e.g.
```
for the input maze definition:

	{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1}, 
	{1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1}, 
	{1,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1}, 
	{1,0,1,1,0,1,0,1,1,1,1,1,0,1,0,1}, 
	{1,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1}, 
	{1,0,1,1,1,1,1,0,1,1,0,1,1,1,0,1}, 
	{1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1}, 
	{1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1}, 
	{1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,1}, 
	{1,0,1,1,1,1,0,1,0,0,1,0,0,0,0,1}, 
	{1,0,0,0,0,1,0,1,0,1,1,0,1,1,1,1}, 
	{1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1}, 
	{1,0,1,1,1,1,1,1,0,0,1,1,1,1,0,1}, 
	{1,0,1,0,0,0,0,0,0,1,1,0,0,1,0,1}, 
	{1,0,1,0,1,1,1,0,0,0,0,0,0,1,0,1},
	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1}}

start: {0, 2}
end: {15, 14}
```

The program outputs: 
```
true
xXxxXx * xXxxXxxXxxXxxXxxXxxXxxXxxXxxXxxXxxXxxXx
xXx    * xXx   xXx   xXx                     xXx
xXx *  * xXx   xXx         xXx         xXx   xXx
xXx * xXxxXx   xXx   xXxxXxxXxxXxxXx   xXx   xXx
xXx *          xXx         xXx   xXx   xXx   xXx
xXx * xXxxXxxXxxXxxXx   xXxxXx   xXxxXxxXx   xXx
xXx *  *  *             xXx      xXx         xXx
xXxxXxxXx * xXxxXxxXxxXxxXx   xXxxXxxXxxXxxXxxXx
xXx *  *  *    xXx *  *  *    xXx   xXx      xXx
xXx * xXxxXxxXxxXx * xXx *    xXx            xXx
xXx *  *  *    xXx * xXx * xXxxXx   xXxxXxxXxxXx
xXx   xXx *  *  *  * xXx *  *  *  *  *  *  * xXx
xXx   xXxxXxxXxxXxxXxxXx *  * xXxxXxxXxxXx * xXx
xXx   xXx                  xXxxXx      xXx * xXx
xXx   xXx   xXxxXxxXx                  xXx * xXx
xXxxXxxXxxXxxXxxXxxXxxXxxXxxXxxXxxXxxXxxXx * xXx
```

## Executing the program

### With Maven

The program includes a maven plugin to directly execute thru maven command
```
mvn exec:java
```

### Java class thru IDE/command line

Otherwise, the program can be executed thru Ide by running the main() method in MazeRunner.java

## Running the tests

### With Maven

```
mvn test
```

### Java class thru IDE/command line

```
MazeTest.java
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

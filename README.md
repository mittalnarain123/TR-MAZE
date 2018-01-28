# TR-MAZE

This is a Java project to implement the Maze Problem. A maze consists of Walls and Aisles. The program Uses Depth First Search and Breadth First Search algorithm to find a path from start to finish traversing through the aisles.

_The BFS algorithm also finds the shortest solution path_

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
-------------DFS---------------
true
xxxxxx * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxx    * xxx   xxx   xxx                     xxx
xxx *  * xxx   xxx         xxx         xxx   xxx
xxx * xxxxxx   xxx   xxxxxxxxxxxxxxx   xxx   xxx
xxx *          xxx         xxx   xxx   xxx   xxx
xxx * xxxxxxxxxxxxxxx   xxxxxx   xxxxxxxxx   xxx
xxx *  *  *             xxx      xxx         xxx
xxxxxxxxx * xxxxxxxxxxxxxxx   xxxxxxxxxxxxxxxxxx
xxx *  *  *    xxx *  *  *    xxx   xxx      xxx
xxx * xxxxxxxxxxxx * xxx *    xxx            xxx
xxx *  *  *    xxx * xxx * xxxxxx   xxxxxxxxxxxx
xxx   xxx *  *  *  * xxx *  *  *  *  *  *  * xxx
xxx   xxxxxxxxxxxxxxxxxx *  * xxxxxxxxxxxx * xxx
xxx   xxx                  xxxxxx      xxx * xxx
xxx   xxx   xxxxxxxxx                  xxx * xxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx * xxx

Solution path size: 42

-------------BFS---------------
true
xxxxxx * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
xxx    * xxx   xxx   xxx                     xxx
xxx *  * xxx   xxx         xxx         xxx   xxx
xxx * xxxxxx   xxx   xxxxxxxxxxxxxxx   xxx   xxx
xxx *          xxx         xxx   xxx   xxx   xxx
xxx * xxxxxxxxxxxxxxx   xxxxxx   xxxxxxxxx   xxx
xxx *  *  *             xxx      xxx         xxx
xxxxxxxxx * xxxxxxxxxxxxxxx   xxxxxxxxxxxxxxxxxx
xxx *  *  *    xxx *  *  *    xxx   xxx      xxx
xxx * xxxxxxxxxxxx * xxx *    xxx            xxx
xxx *  *  *    xxx * xxx * xxxxxx   xxxxxxxxxxxx
xxx   xxx *  *  *  * xxx *  *  *  *  *  *  * xxx
xxx   xxxxxxxxxxxxxxxxxx      xxxxxxxxxxxx * xxx
xxx   xxx                  xxxxxx      xxx * xxx
xxx   xxx   xxxxxxxxx                  xxx * xxx
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx * xxx

Solution path size: 40

```

## Executing the program

### With Maven

The program includes a maven plugin to directly execute thru maven command
```
./mvnw compile exec:java
```

### With Gradle

To execute the program using gradle

```
./gradlew run
```

### Java class thru IDE/command line

Otherwise, the program can be executed thru Ide by running the main() method in MazeRunner.java

## Running the tests

### With Maven

```
./mvnw test
```

### With Gradle

```
./gradlew test
```
_The Gradle test report will be generated in $project/build/reports/index.html_


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

# TR-MAZE
Maze Project

This is a Java project to implement the Maze Problem. A maze consists of Walls and Aisles. The program Uses Depth First Search algorithm to find a path from start to finish traversing thru the aisles.

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

{1,0,1,1,1,1,1,1,1}, 
{1,0,0,0,1,0,0,0,1},
{1,0,1,1,1,0,1,0,1}, 
{1,0,1,0,0,0,1,0,1},
{1,0,1,0,1,0,1,1,1},
{1,0,0,0,1,0,1,0,1},
{1,0,1,1,1,0,1,0,1},
{1,0,0,0,1,0,0,0,1},
{1,1,1,1,1,1,1,0,1}

start: {0, 1}
end: {8, 7}
```

The program outputs: 
```
X*XXXXXXX
X*  X   X
X*XXX X X
X*X***X X
X*X*X*XXX
X***X*X X
X XXX*X X
X   X***X
XXXXXXX*X
```

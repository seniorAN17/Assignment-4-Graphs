**task 1 — Depth First Search**



Graph (Adjacency List):

A: C B D

B: A C E G

C: A B D

D: C A

E: G F B

F: G E

G: F B



Start node: A



Method: Recursive DFS



Visited = \[]



\--------------------------------------------------



Call dfs(A)

Visited = \[A]



Move to C



\--------------------------------------------------



Call dfs(C)

Visited = \[A, C]



Move to B



\--------------------------------------------------



Call dfs(B)

Visited = \[A, C, B]



Move to E



\--------------------------------------------------



Call dfs(E)

Visited = \[A, C, B, E]



Move to G



\--------------------------------------------------



Call dfs(G)

Visited = \[A, C, B, E, G]



Move to F



\--------------------------------------------------



Call dfs(F)

Visited = \[A, C, B, E, G, F]



Neighbors (G, E) already visited → backtrack



\--------------------------------------------------



Back to G → no unvisited neighbors → backtrack



\--------------------------------------------------



Back to E → no unvisited neighbors → backtrack



\--------------------------------------------------



Back to B → next neighbor G already visited → backtrack



\--------------------------------------------------



Back to C → move to D



\--------------------------------------------------



Call dfs(D)

Visited = \[A, C, B, E, G, F, D]



Neighbors already visited → backtrack



\--------------------------------------------------



Back to A → all nodes processed



\--------------------------------------------------



FINAL DFS ORDER:

A → C → B → E → G → F → D



Explanation:

DFS starts from node A and explores as deep as possible before backtracking. It follows one branch fully before moving to another.







**Task 2  — Breadth First Search** 

Graph (Adjacency List):

A: C B D

B: A C E G

C: A B D

D: C A

E: G F B

F: G E

G: F B



Start node: A



Data structures:

Queue = \[]        (FIFO structure)

Visited = \[]      (to avoid revisiting nodes)



\--------------------------------------------------



Step 1:

Queue = \[A]

Visited = \[A]







Step 2:

Dequeue A → process A

Add neighbors of A: C, B, D



Queue = \[C, B, D]

Visited = \[A, C, B, D]







Step 3:

Dequeue C → process C

Neighbors: A, B, D (already visited)



Queue = \[B, D]

Visited = \[A, C, B, D]







Step 4:

Dequeue B → process B

Neighbors: A, C, E, G

Add E and G



Queue = \[D, E, G]

Visited = \[A, C, B, D, E, G]





Step 5:

Dequeue D → process D

Neighbors: C, A (already visited)



Queue = \[E, G]

Visited = \[A, C, B, D, E, G]







Step 6:

Dequeue E → process E

Neighbors: G, F, B

Add F



Queue = \[G, F]

Visited = \[A, C, B, D, E, G, F]







Step 7:

Dequeue G → process G

Neighbors: F, B (already visited)



Queue = \[F]

Visited = \[A, C, B, D, E, G, F]







Step 8:

Dequeue F → process F

Neighbors: G, E (already visited)



Queue = \[]

Visited = \[A, C, B, D, E, G, F]







FINAL BFS ORDER:

A → C → B → D → E → G → F



Explanation:

BFS starts from node A and visits nodes level by level using a queue, exploring all neighbors before moving deeper.



**TASK 4 — Shortest Path (Dijkstra Concept)**



Find the shortest path from Edinburgh to Dundee.



paths:

1\. Edinburgh → Perth → Dundee

&#x20;  Cost = 160



2\. Edinburgh → Stirling → Perth → Dundee

&#x20;  Cost = 150



Shortest Path:

Edinburgh → Stirling → Perth → Dundee



Total Cost:

150




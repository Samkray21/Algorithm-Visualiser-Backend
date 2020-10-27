# Algorithm-Visualiser-Backend

This is the Java and Spring backend api which gets called by this front end application: https://github.com/Samkray21/Algorithm-Visualiser-Frontend

This api will return the edges of a minimum spanning tree of a given graph in order.

The three algorithms this api can calculate are: Prims, Kruskal’s and Boruvka’s.

Prims algorithm will require a starting node input but Kruskal's and Boruvka’s do not require a starting node as it does not get considered when processing the algorithm.

This backend is hosted on both Heroku and on the Google Cloud Platform.

![](https://user-images.githubusercontent.com/48014118/96774777-70bc7b00-13de-11eb-94ac-03713b568692.gif)

## Testing

This project uses JUnit to run unit tests. A folder containing all tests is included.

The conditions tested:

- Prims Algorithm
- Kruskal’s
- Boruvka’s

## Built With

- Java 11
- Spring Boot 2.0

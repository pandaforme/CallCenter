# How to run 
```bash
mvn compile
mvn exec:java
```

# How to run test
```bash
mvn test
```

# How to format
```bash
mvn com.coveo:fmt-maven-plugin:format
```

# Architecture
According to requirements, I design a parent class `Employee` and it has 3 children `Fresher`, `TechnicalLead` and `ProductManager`.
The logic of escalating to deputy is almost same, so I put this flow into `Employee`.
But there is little difference among`Fresher`, `TechnicalLead` and `ProductManager`. 
When they are not free, they use a different way to handle it.
So I use `Strategy` pattern to solve this question and `Chain of Responsibility` to handle how to escalate to related deputy.  

`CallCenter` has 3 ways to create employees and uses `answer()` to response a call which using a thread to serve a new call.

`Main` is a entry point of this program.

# Improvements
1. control the number of threads with a thread pool.
2. use a effective data structure to detect whether all freshers are not available.
3. use a queue to store coming requests, when `TechnicalLead` or `ProductManager` is not free.
## About Carbon-Tracker
Carbon-Tracker expose the HTTP Rest API end points for tracking the Co2 values .
This facilitate to keep track of the levels of CO2 across several city ,districts which is collected from various sensors installed across city.

### Goals
* Simple, flexible, extendable Co2 values tracker backend System

<!-- ### Design Inspiration Architecture from Industry Standard

![Design Inspiration Architecture](./docs/images/CleanArchitecture.jpg)
![Design Inspiration Architecture](./docs/images/ddd.jpeg) -->

### Carbon-Tracker Application Architecture

![Application Architecture](./docs/images/Carbon-Tracker-Application-Architecture.png)

### API Execution Flow

![API Execution Flow](./docs/images/API-Execution-Flow.png)

### Add Reading API

![Add Reading API](./docs/images/Sequence-diagram-addReading.png)


### Get Reading API

![Get Reading API](./docs/images/Sequence-diagram-getReading.png)

### Entity Diagrams

![ER Diagram](./docs/images/Acc-ERDiagram.pdf)
![ER Class-Diagram](./docs/images/Entity_ClassDiagram.gif)


### Swagger Link 
[Corbon-Tracker-swagger](https://xxyyy/).

### Carbon-Tracker Application Prerequisites

1. Configure DB properties like H2 host, credentials etc.
2. Update the property `spring.datasource.url` `spring.datasource.driverClassName` `spring.datasource.username` `spring.datasource.password` `spring.h2.console.path`  **H2** and **JPA** will support this.


**H2**
<!-- 6. XXXX [dbconfig](./docs/images/CleanArchitecture.jpg) 
7. YYYY [dbconfig](./docs/images/CleanArchitecture.jpg)    -->

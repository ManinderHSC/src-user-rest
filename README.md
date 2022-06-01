Given:
- 1M Users in a DB of your selection
- User has the following attributes: {ID, Name, Age, Address 1, Address 2 }
Implement a working API for a Web UI / Mobile App, that supports the following use cases:
- Display all users in a table view (Name, Age)
- Filter the users by last name and age
- Sort by Name or Age
Nonfunctional requirements:
- Response time &lt; 1sec
Deliverable:
- Fully functional API implemented using Java including source codes
- A simple Web UI (Angular, React) demonstrating the use cases is a plus but not a must.
- Source code preferable shared on GitHub.


Remarks:
In-file H2 Database used for development 
Db Scripts used are avilable as part of the project.
Tested the application with 1M records. Response time noticed was within 1 sec.
Second level cache can be used to minimize the query time further if needed


Example:
Below are the GET requests to get the list of users with different filter and sort criteria

To get all the users with pagination 
http://localhost:8080/v1/users
http://localhost:8080/v1/users?pageSize=500
http://localhost:8080/v1/users?pageSize=100&pageNo=3

http://localhost:8080/v1/users?sortBy=name&sortDir=asc
http://localhost:8080/v1/users?sortBy=name&sortDir=desc

http://localhost:8080/v1/users?lastName=Price
http://localhost:8080/v1/users?lastName=Price&age=82
http://localhost:8080/v1/users?age=82


Assumptions:
The name column in db contains the data in the format firstname<space>lastName - Search using lastname would have memory efficient if there would have been seperate columns for firstname and lastname
The response time would depend on database and configuration of db and deployment server used
The response time would also depend on network latency
The pazeSize param supports maximum of 5000 records that can be fetched. The client can adjust this based on the network and server infrastructure.
The pazeSize default value is 100

Sample logs:

2022-06-01 13:40:33.669  INFO 15964 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
Hibernate: select user0_.name as col_0_0_, user0_.age as col_1_0_ from users_tbl1 user0_ order by user0_.name asc limit ?
Hibernate: select count(user0_.id) as col_0_0_ from users_tbl1 user0_
Execution time: 18 milliseconds
Hibernate: select user0_.name as col_0_0_, user0_.age as col_1_0_ from users_tbl1 user0_ order by user0_.name asc limit ?
Hibernate: select count(user0_.id) as col_0_0_ from users_tbl1 user0_
Execution time: 8 milliseconds
Hibernate: select user0_.name as col_0_0_, user0_.age as col_1_0_ from users_tbl1 user0_ order by user0_.name asc limit ?
Hibernate: select count(user0_.id) as col_0_0_ from users_tbl1 user0_
Execution time: 2 milliseconds
Hibernate: select user0_.name as col_0_0_, user0_.age as col_1_0_ from users_tbl1 user0_ order by user0_.name asc limit ?
Hibernate: select count(user0_.id) as col_0_0_ from users_tbl1 user0_
Execution time: 3 milliseconds
2022-06-01 15:19:35.616  WARN 15964 --- [nio-8080-exec-9] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [javax.validation.ConstraintViolationException: getUsers.pageSize: must be less than or equal to 5000]
Hibernate: select user0_.name as col_0_0_, user0_.age as col_1_0_ from users_tbl1 user0_ order by user0_.name asc limit ? offset ?
Hibernate: select count(user0_.id) as col_0_0_ from users_tbl1 user0_
Execution time: 252 milliseconds
Hibernate: select user0_.name as col_0_0_, user0_.age as col_1_0_ from users_tbl1 user0_ order by user0_.name asc limit ? offset ?
Hibernate: select count(user0_.id) as col_0



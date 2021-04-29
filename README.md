# studentmanagementservice

This project is useful for managing student data and courses data.
You can add the students and view the students list and can search using the firstname and lastname.
You can add the course and view the course lists and can search using course name and description.
You can view the View count in dashboard how many people actually hits the server.

StudentManagementController -  It deals with adding , fetching and searching students
    StudentService -     It deals with business logic for adding , fetching and searching students
    StudentRepository -  It deals with db  for adding , fetching and searching students
   
CourseManagementController - It deals with adding, fetching and searchig courses
     CourseManagementService - It delas with business logic adding, fetching and searchig courses
      CourseRepository - It deals with db for adding, fetching and searchig courses
      
      
Index.html - In this displaying page view count where having an ajax call which fetches the count for every 3sec.
students.html- In this we will display list of students and having an search feature with firstname and lastname.
addstudent.html - In this we can add the student and having server side validation before saving the data into db.
courses.html- In this we will display list of courses and having an search feature with course name and description.
addcourse.html - In this we can add the course and having server side validation before saving the data into db.



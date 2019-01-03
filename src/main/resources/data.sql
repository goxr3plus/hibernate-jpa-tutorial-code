
insert into course(id,FULLNAME,created_date,last_updated_date,is_deleted) values 
(1001,' JPA IN 50 STEPS',sysdate(),sysdate(),false),
(1002,' Spring IN 50 STEPS',sysdate(),sysdate(),false),
(1003,' Spring Boot IN 100 STEPS',sysdate(),sysdate(),false),
(1004,' JPA IN 50 STEPS',sysdate(),sysdate(),false),
(1005,' Spring IN 50 STEPS',sysdate(),sysdate(),false),
(1006,' JPA IN 50 STEPS',sysdate(),sysdate(),false),
(1007,' Spring IN 50 STEPS',sysdate(),sysdate(),false),
(1008,' JPA IN 50 STEPS',sysdate(),sysdate(),false),
(1009,' Spring IN 50 STEPS',sysdate(),sysdate(),false),
(1010,' JPA IN 50 STEPS',sysdate(),sysdate(),false),
(1011,' Spring IN 50 STEPS',sysdate(),sysdate(),false);



insert into passport(id,number) values (4001,'E123456');
insert into passport(id,number) values (4002,'N123457');
insert into passport(id,number) values (4003,'L123890');


insert into student(id,name,passport_id) values (2001,'RANGA',4001);
insert into student(id,name,passport_id) values (2002,'Leila',4002);
insert into student(id,name,passport_id) values (2003,'Jaisal',4003);


insert into review(id,rating,description,course_id)  values (5001,'5','Great Course',1001);
insert into review(id,rating,description,course_id)  values (5002,'5','Wonderful Course',1001);
insert into review(id,rating,description,course_id)  values (5003,'5','Awesome Course',1003);

insert into student_course(student_id,course_id) values 
(2001,1001)
,(2002,1001)
,(2003,1001)
,(2001,1003);
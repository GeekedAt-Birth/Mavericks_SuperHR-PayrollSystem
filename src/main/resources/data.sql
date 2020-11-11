INSERT INTO JOBS_MAVERICKS (TITLE,SALARY_PER_DAY,PAY_PERIOD) VALUES ('SOFTWARE ENGINEER I',250.00,10);
INSERT INTO JOBS_MAVERICKS (TITLE,SALARY_PER_DAY,PAY_PERIOD) VALUES ('SOFTWARE ENGINEER II',200.00,10);
INSERT INTO JOBS_MAVERICKS (TITLE,SALARY_PER_DAY,PAY_PERIOD) VALUES ('SOFTWARE ARCHITECT',200.00,10);
INSERT INTO JOBS_MAVERICKS (TITLE,SALARY_PER_DAY,PAY_PERIOD) VALUES ('SOFTWARE TESTER',150.00,10);


INSERT INTO USERS_MAVERICKS (USERNAME,EMAIL,FIRST_NAME,LAST_NAME,PHONE_NUMBER,PASSWORD,CONFIRM_PASSWORD,IS_ADMIN,JOB_ID) VALUES('admin','admin@gmail.com','Mr','Admin','123123123','adminpass','adminpass',TRUE,1);
INSERT INTO USERS_MAVERICKS (USERNAME,EMAIL,FIRST_NAME,LAST_NAME,PHONE_NUMBER,PASSWORD,CONFIRM_PASSWORD,IS_ADMIN,JOB_ID) VALUES('melanie','melanie@gmail.com','Melanie','Kung','123123123','melaniepass','melaniepass',FALSE,2);
INSERT INTO USERS_MAVERICKS (USERNAME,EMAIL,FIRST_NAME,LAST_NAME,PHONE_NUMBER,PASSWORD,CONFIRM_PASSWORD,IS_ADMIN,JOB_ID) VALUES('rita','rita@gmail.com','Rita','Ak','123123123','ritapass','ritapass',FALSE,2);
INSERT INTO USERS_MAVERICKS (USERNAME,EMAIL,FIRST_NAME,LAST_NAME,PHONE_NUMBER,PASSWORD,CONFIRM_PASSWORD,IS_ADMIN,JOB_ID) VALUES('tarek','tarek@gmail.com','Tarek','Ahmed','123123123','tarekpass','tarekpass',FALSE,2);

INSERT INTO PAY_MAVERICKS (benefitEI, benefitCPP, income_Tax, sick_Days, holidays, start_Date, end_Date, employeeId) VALUES (0.0158, 0.0525, 0.15, 14, 10, '2020-10-28 03:36:48', '2020-11-09 13:16:24', 1);
INSERT INTO PAY_MAVERICKS (benefitEI, benefitCPP, income_Tax, sick_Days, holidays, start_Date, end_Date, employeeId) VALUES (0.0158, 0.0525, 0.15, 14, 15, '2020-10-28 07:54:58', '2020-11-07 11:41:22', 2);
INSERT INTO PAY_MAVERICKS (benefitEI, benefitCPP, income_Tax, sick_Days, holidays, start_Date, end_Date, employeeId) VALUES (0.0158, 0.0525, 0.15, 14, 15, '2020-10-19 16:12:55', '2020-11-12 15:09:08', 3);
INSERT INTO PAY_MAVERICKS (benefitEI, benefitCPP, income_Tax, sick_Days, holidays, start_Date, end_Date, employeeId) VALUES (0.0158, 0.0525, 0.15, 7, 10, '2020-10-23 09:16:39', '2020-11-12 23:37:16', 4);
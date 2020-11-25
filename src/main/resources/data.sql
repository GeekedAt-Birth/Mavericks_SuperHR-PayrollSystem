INSERT INTO JOBS_MAVERICKS (TITLE,SALARY_PER_DAY,PAY_PERIOD) VALUES ('SOFTWARE ENGINEER I',250.00,10);
INSERT INTO JOBS_MAVERICKS (TITLE,SALARY_PER_DAY,PAY_PERIOD) VALUES ('SOFTWARE ENGINEER II',200.00,10);
INSERT INTO JOBS_MAVERICKS (TITLE,SALARY_PER_DAY,PAY_PERIOD) VALUES ('SOFTWARE ARCHITECT',200.00,10);
INSERT INTO JOBS_MAVERICKS (TITLE,SALARY_PER_DAY,PAY_PERIOD) VALUES ('SOFTWARE TESTER',150.00,10);

INSERT INTO USERS_MAVERICKS (USERNAME,EMAIL,FIRST_NAME,LAST_NAME,PHONE_NUMBER,PASSWORD,CONFIRM_PASSWORD,IS_ADMIN,JOB_ID) VALUES('admin','admin@gmail.com','Mr','Admin','123123123','adminpass','adminpass',TRUE,1);
INSERT INTO USERS_MAVERICKS (USERNAME,EMAIL,FIRST_NAME,LAST_NAME,PHONE_NUMBER,PASSWORD,CONFIRM_PASSWORD,IS_ADMIN,JOB_ID) VALUES('melanie','melanie@gmail.com','Melanie','Kung','123123123','melaniepass','melaniepass',FALSE,2);
INSERT INTO USERS_MAVERICKS (USERNAME,EMAIL,FIRST_NAME,LAST_NAME,PHONE_NUMBER,PASSWORD,CONFIRM_PASSWORD,IS_ADMIN,JOB_ID) VALUES('rita','rita@gmail.com','Rita','Akansiima','123123123','ritapass','ritapass',FALSE,3);
INSERT INTO USERS_MAVERICKS (USERNAME,EMAIL,FIRST_NAME,LAST_NAME,PHONE_NUMBER,PASSWORD,CONFIRM_PASSWORD,IS_ADMIN,JOB_ID) VALUES('tarek','tarek@gmail.com','Tarek','Ahmed','123123123','tarekpass','tarekpass',FALSE,4);
INSERT INTO USERS_MAVERICKS (USERNAME,EMAIL,FIRST_NAME,LAST_NAME,PHONE_NUMBER,PASSWORD,CONFIRM_PASSWORD,IS_ADMIN,JOB_ID) VALUES('arie','arie@gmail.com','Arie','Ellish','123123123','ariepass','ariepass',FALSE,4);

INSERT INTO PAY_MAVERICKS (benefitEI, benefitCPP, income_Tax, sick_Days, holidays, start_Date, end_Date, employeeId, pay_status) VALUES (0.0158, 0.0525, 0.15, 14, 10, '2020-10-28 03:36:48', '2020-11-09 13:16:24', 1, TRUE);
INSERT INTO PAY_MAVERICKS (benefitEI, benefitCPP, income_Tax, sick_Days, holidays, start_Date, end_Date, employeeId, pay_status) VALUES (0.0158, 0.0525, 0.15, 14, 15, '2020-10-28 07:54:58', '2020-11-07 11:41:22', 2, FALSE);
INSERT INTO PAY_MAVERICKS (benefitEI, benefitCPP, income_Tax, sick_Days, holidays, start_Date, end_Date, employeeId, pay_status) VALUES (0.0158, 0.0525, 0.15, 14, 15, '2020-10-19 16:12:55', '2020-11-12 15:09:08', 3, FALSE);
INSERT INTO PAY_MAVERICKS (benefitEI, benefitCPP, income_Tax, sick_Days, holidays, start_Date, end_Date, employeeId, pay_status) VALUES (0.0158, 0.0525, 0.15, 7, 10, '2020-10-23 09:16:39', '2020-11-12 23:37:16', 4, TRUE);
INSERT INTO PAY_MAVERICKS (benefitEI, benefitCPP, income_Tax, sick_Days, holidays, start_Date, end_Date, employeeId, pay_status) VALUES (0.0158, 0.0525, 0.15, 7, 10, '2020-10-23 09:16:39', '2020-11-12 23:37:16', 5, FALSE);

INSERT INTO LEAVE_APPLICATIONS_MAVERICKS  (id, start_date, end_date, days, leave_type, reason, application_status, employee_Id) VALUES (1, '2020-11-03 16:04:15', '2020-11-07 22:31:14', 4, 'holidays', 'I am sick','approved', 2);
INSERT INTO LEAVE_APPLICATIONS_MAVERICKS  (id, start_date, end_date, days, leave_type, reason, application_status, employee_Id) VALUES (2, '2020-11-05 09:57:13', '2020-11-06 18:04:40', 1, 'sick days', 'I''d like to take a break','pending', 5);
INSERT INTO LEAVE_APPLICATIONS_MAVERICKS  (id, start_date, end_date, days, leave_type, reason, application_status, employee_Id) VALUES (3, '2020-11-06 20:19:36', '2020-11-18 01:12:21', 12, 'sick days', 'I got the flu','pending', 3);
INSERT INTO LEAVE_APPLICATIONS_MAVERICKS  (id, start_date, end_date, days, leave_type, reason, application_status, employee_Id) VALUES (4, '2020-04-30 10:57:06', '2020-05-03 23:06:12', 3, 'holidays', 'I just hate work','rejected', 4);
INSERT INTO LEAVE_APPLICATIONS_MAVERICKS  (id, start_date, end_date, days, leave_type, reason, application_status, employee_Id) VALUES (5, '2020-04-30 10:57:06', '2020-05-03 23:06:12', 3, 'holidays', 'I just hate work','rejected', 3);
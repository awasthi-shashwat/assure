
-- INSERT INTO POLICY VALUES(1, 10.0, 0.0, 100000.0, 200000.0, 300000.0, TRUE, TRUE, TRUE, '2 YEARS', 'MAX BUPA', 10000.0, 6000.0, 7000.0, 12000.0, 'AC/NON AC', 3, 4, 5);


-- INSERT INTO POLICY VALUES(2, 10.0, 0.0, 400000.0, 500000.0, 600000.0, TRUE, TRUE, TRUE, '3 YEARS', 'RELIANCE HEALTH', 20000.0, 8000.0, 10000.0, 15000.0, 'NON AC', 5, 6, 7);

-- INSERT INTO USER VALUES('1','ABHI','ABC@GMAIL.COM','988856661','1234');

-- -- INSERT INTO MEMBERS VALUES(1,'11/02/1996','PTK','ABC@GMAIL.COM','MALE','5ft',TRUE,'UNMARRIED','9888422255','ABHI','SELF-EMPLOYED','Brother','60KG',null);

-- INSERT INTO LOCATION(LOCATION_ID,NAME)
-- VALUES(101L,'MUMBAI');

-- INSERT INTO LOCATION(LOCATION_ID,NAME)
-- VALUES(102L,'PUNE');

-- INSERT INTO HOSPITALS(HOSPITAL_ID,NAME,LOCATION_LOCATION_ID)
-- VALUES (501L,'Shubh',102L);

-- INSERT INTO HOSPITALS(HOSPITAL_ID,NAME,LOCATION_LOCATION_ID)
-- VALUES (502L,'Astha',102L);


INSERT INTO POLICY VALUES(1, 10.0, 0.0, 100000.0, 200000.0, 300000.0, TRUE, TRUE, TRUE, '2 YEARS', 'MAX BUPA HEALTH INSURANCE', 10000.0, 6000.0, 7000.0, 12000.0, 'AC/NON AC', 3, 4, 5);

INSERT INTO POLICY VALUES(2, 10.0, 0.0, 400000.0, 500000.0, 600000.0, TRUE, TRUE, TRUE, '3 YEARS', 'RELIANCE HEALTH INSURANCE', 20000.0, 8000.0, 10000.0, 15000.0, 'NON AC', 5, 6, 7);

INSERT INTO USER VALUES('1','ABC@GMAIL.COM','988856661','Abhi','1234');

-- INSERT INTO MEMBERS(MEMBER_ID,DOB,CITY,EMAIL,GENDER,HEIGHT,IS_TAKING_MEDICINES,MARTIAL_STATUS,MOBILE,NAME,OCCUPATION,RELATION_WITH_USER,WEIGHT,POLICY_BOOKINGS_BOOKING_ID) VALUES(1,'11/02/1996 00:00:00','PTK','ABC@GMAIL.COM','MALE','5ft',TRUE,'UNMARRIED','9888422255','ABHI','SELF-EMPLOYED','Brother','60KG',NULL);

INSERT INTO LOCATION(LOCATION_ID,NAME)
VALUES(101L,'MUMBAI');

INSERT INTO LOCATION(LOCATION_ID,NAME)
VALUES(102L,'PUNE');


INSERT INTO HOSPITALS(HOSPITAL_ID,NAME,LOCATION_LOCATION_ID)
VALUES (501L,'Apollo Hospital',101L);
INSERT INTO HOSPITALS(HOSPITAL_ID,NAME,LOCATION_LOCATION_ID)
VALUES (502L,'Apollo Hospital',102L);
INSERT INTO HOSPITALS(HOSPITAL_ID,NAME,LOCATION_LOCATION_ID)
VALUES (503L,'Fortis Hospital',102L);

INSERT INTO POLICY_HOSPITALS VALUES(1, 501L);
INSERT INTO POLICY_HOSPITALS VALUES(1, 502L);

INSERT INTO POLICY_HOSPITALS VALUES(2, 501L);

INSERT INTO POLICY_BOOKINGS VALUES (1, '2021-11-10 16:48:18.434', 100000.0, 3, 'MAX BUPA HEALTH INSURANCE', 19000.0, 1, 1);
INSERT INTO MEMBERS VALUES (1, '1965-07-12 00:00:00', '988333507533', 'Kolkata', 'prottayray@gmail.com', 'male', '5 ft 6 in', true, true, '9477133482', 'Prottay Ray', 'Coding', 'self', 55.5, 1);
INSERT INTO MEMBERS VALUES (2, '1991-07-12 00:00:00', '222233334444', 'Kolkata', 'prottayray@gmail.com', 'male', '5 ft 6 in', true, false, '9477133482', 'Arjun Kumar', 'Coding', 'son', 50.5, 1);

INSERT INTO POLICY_BOOKINGS_MEMBERS VALUES (1, 1);
INSERT INTO POLICY_BOOKINGS_MEMBERS VALUES (1, 2);


INSERT INTO USER_POLICY_BOOKINGS_LIST VALUES (1, 1);

INSERT INTO POLICY_POLICY_BOOKINGS VALUES (1, 1);

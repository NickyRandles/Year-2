
create database medicClinic;

create table medication
(medId int not null primary key,
mname varchar(20),
dose varchar (20)); 


create table speciality
(medId int not null primary key,
mname varchar(20),
dose varchar (20)



speciality(specID(pk), name)
department(deptno(PK), name) 
patient(patientID(pk), name, address. gender)

patient_hx(patientiD(PK, FK), staffID(FK), desc, medID(fk)) 
staff(staffID(PK), name, address, specID(fk), room number)  
service(serviceID(pk),name, cost, deptno(fk) 

insert into medication values( "01", "panadol", "5day");

create table appointent(appointmentID int not null primary key, 
adate date,
atime time, 
patientID int(30),
serviceID int (30),
constraint pt_app foreign key(patientID) references patient(patientID),
constraint service_app foreign key(serviceID) references service(serviceID)); 


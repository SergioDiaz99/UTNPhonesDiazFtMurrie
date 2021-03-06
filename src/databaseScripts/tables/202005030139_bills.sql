/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 03/05/2020
 *  Description: create of table bills
 */

use utnphones;

create table if not exists bills
(
	idBill int auto_increment,
	idBillState int default(1),
	idPhoneLine int not null,
	callsQuantity int default(0),
	costPrice float default(0),
	totalPrice float default(0),
	billMonth varchar(100) not null,
	issueDate datetime default(now()),
	expiryDate datetime not null,
	expired boolean default(false),
    creatorUser varchar(100) not null,
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_bills_idBill primary key(idBill),
	constraint UK_bills_idPhoneLine_billMonth unique(idPhoneLine,billMonth),
	constraint FK_bills_idPhoneLine foreign key(idPhoneLine) references phoneLines(idPhoneLine) on update cascade on delete cascade
);

/*Indexes for the searchs in the table bills*/

create index if not exists idx_bills_ on bills(idPhoneLine,issueDate) using btree;
create index if not exists idx_bills_ on bills(issueDate) using btree;





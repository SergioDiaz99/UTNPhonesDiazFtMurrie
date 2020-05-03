/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table companies
 */

use utnphones;

drop table if exists companies;

create table if not exists companies
(
	creatorUser varchar(100),
	createdDate datetime default(now()),
	updaterUser varchar(100),
	updatedDate timestamp,
	idCompany int auto_increment,
    logicDelete bit(1) default(0),
	name varchar(100) not null,
	constraint PK_companies_idCompany primary key(idCompany),
	constraint UK_companies_name unique(name)
);

/*Triggers for audit*/

/*Trigger for creator user*/

drop trigger if exists companies_audit_creator;
delimiter //
create trigger if not exists companies_audit_creator
before insert on companies
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger for updater user*/

drop trigger if exists companies_audit_updater;
delimiter //
create trigger if not exists companies_audit_updater
before update on companies
for each row
begin
set new.updaterUser=getDbUserName();
end //
delimiter ;
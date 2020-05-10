/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table countryAreaCodes
 */

use utnphones;

drop table if exists countryAreaCodes;

create table if not exists countryAreaCodes
(
	idCountryAreaCode int auto_increment,
	code varchar(100) not null,
	idInterAreaCode int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_countryAreaCodes_idCountryAreaCode primary key(idCountryAreaCode),
	constraint UK_countryAreaCodes_code unique(code),
	constraint FK_countryAreaCodes_idInterAreaCode foreign key(idInterAreaCode) references interAreaCodes(idInterAreaCode) on update cascade on delete cascade
);

/*Triggers for the table countryAreaCodes*/

/*Trigger before insert*/

drop trigger if exists countryAreaCodes_before_insert;
delimiter //
create trigger if not exists countryAreaCodes_before_insert
before insert on countryAreaCodes
for each row
begin
set new.creatorUser=getDbUserName();
end //
delimiter ;

/*Trigger before update*/

drop trigger if exists countryAreaCodes_before_update;
delimiter //
create trigger if not exists countryAreaCodes_before_update
before update on countryAreaCodes
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;

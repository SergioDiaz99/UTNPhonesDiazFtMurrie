/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 02/05/2020
 * 	Description: create of table localAreaCodes
 */

use utnphones;

create table if not exists localAreaCodes
(
	idLocalAreaCode int auto_increment,
	code varchar(100) not null,
	idCountryAreaCode int not null,
    creatorUser varchar(100),
    createdDate datetime default(now()),
    updaterUser varchar(100),
    updatedDate datetime,
	constraint PK_localAreaCodes_idLocalAreaCode primary key(idLocalAreaCode),
	constraint UK_localAreaCodes_code unique(code),
	constraint FK_localAreaCodes_idCountryAreaCode foreign key(idCountryAreaCode) references countryAreaCodes(idCountryAreaCode) on update cascade on delete cascade
);
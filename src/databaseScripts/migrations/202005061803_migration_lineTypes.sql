/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 06/05/2020
 *  Description: migration of data into the table lineTypes.
 */

use utnphones;

drop procedure if exists migration_lineTypes;
delimiter //
create procedure migration_lineTypes
(
)
begin

if(not exists(select 1 from lineTypes limit 1))
then

set autocommit=0;
start transaction;

insert into lineTypes (description,code) values ("Mobile","9");
insert into lineTypes (description,code) values ("Residential","11");

commit;

end if;

end //
delimiter ;

/*
 * 	Author: Murrie Battistoni Felipe
 * 	Created Date: 10/05/2020
 * 	Description: create of trigger for the table provinces
*/

use utnphones;

drop trigger if exists provinces_before_update;
delimiter //
create trigger if not exists provinces_before_update
before update on provinces
for each row
begin
set new.updaterUser=getDbUserName();
set new.updatedDate=now();
end //
delimiter ;
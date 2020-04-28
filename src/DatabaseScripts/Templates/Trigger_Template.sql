/*Template for create a Trigger object for MySQL*/

use 'Name of Database';

drop trigger if exists 'Name of the Trigger';

create trigger if not exists 'Name of the Trigger' 'time(after or before)' 'action(insert, update or delete)' on 'Name of the Table'
for each rows
begin

/*Body of the trigger*/

end;
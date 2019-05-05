insert into usr (username, password, active)
values ('admin', '1', true);

insert into user_role (user_id, roles)
values (1, 'USER'), (1, 'ADMIN'), (1, 'MOD1'), (1, 'MOD2');

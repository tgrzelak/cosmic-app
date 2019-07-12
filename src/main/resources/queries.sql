/*ROLES*/
insert into role (role_id, role)
values ( 1, 'ADMIN' );

insert into role (role_id, role)
values ( 2, 'USER' );

/*USERS*/
insert into user (user_id, active, name, password)
values ( 1,1,'admin', '$2a$10$ugO1HQik6KbhxtEZAiIdnOVTS1eR/coYvg.T9C/STMymvQaOnPfz.' );

insert into user (user_id, active, name, password)
values ( 2,1,'user', '$2a$10$k8eNyLc3tTixwnyCc22m.ewJV6zJWlTtypluESbe.OtC9PQhU8XKC' );

/*ADD ROLES TO USERS*/
insert into user_role (user_id, role_id) values ( 1,1 ); /*admin*/
insert into user_role (user_id, role_id) values ( 1,2 );

insert into user_role (user_id, role_id) values ( 2,2 ); /*user*/

-- INSERT INTO "public"."tags" ("id", "title") VALUES (DEFAULT, 'big');
  

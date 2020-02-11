

--delete from Taco_ingredients;
--delete from Taco_Order_Tacos;
--delete from Taco_Order;
--delete from Taco;
--delete from Ingredient;
  
  /*
insert into Ingredient(id, codigo, name, type)values(10001, 'FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient(id, codigo, name, type)values(10002, 'COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient(id, codigo, name, type)values(10003, 'GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient(id, codigo, name, type)values(10004, 'CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient(id, codigo, name, type)values(10005, 'TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient(id, codigo, name, type)values(10006, 'LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient(id, codigo, name, type)values(10007, 'CHED', 'Cheddar', 'CHEESE');
insert into Ingredient(id, codigo, name, type)values(10008, 'JACK', 'Moterrey', 'CHEESE');
insert into Ingredient(id, codigo, name, type)values(10009, 'SLSA', 'Salsa', 'SAUCE');
insert into Ingredient(id, codigo, name, type)values(100010, 'SRCR', 'Sour Cream', 'SAUCE');*/

insert into user(id, username, password, enabled )values(10001, 'cacofut', '{bcrypt}$2a$10$N/m4wiAuv2MoxlOQdC0TweCotk0DzTAsOkoL5KikUBBZnmXzbccEC', 1);
insert into user(id, username, password, enabled )values(10002, 'joao', '{bcrypt}$2a$10$N/m4wiAuv2MoxlOQdC0TweCotk0DzTAsOkoL5KikUBBZnmXzbccEC', 1);
insert into user(id, username, password, enabled )values(10003, 'joao', '{bcrypt}$2a$10$N/m4wiAuv2MoxlOQdC0TweCotk0DzTAsOkoL5KikUBBZnmXzbccEC', 1);

insert into authority(id, name)values(20001, 'ROLE_USER');
insert into authority(id, name)values(20002, 'ROLE_ADMIN');
insert into authority(id, name)values(20003, 'ROLE_MANAGER');

insert into user_authority(id, user_id, authority_id)values(30001, 10001, 20001);

insert into groups(id, name)values(40001, 'Administrator s group');
insert into groups(id, name)values(40002, 'Manager s group');


insert into user_groups(id, user_id, group_id)values(50001, 10001, 40001);
insert into user_groups(id, user_id, group_id)values(50002, 10002, 40001);
insert into user_groups(id, user_id, group_id)values(50003, 10003, 40001);

insert into groups_authority(id, groups_id, authority_id)values(60001, 40001, 20002);

 
/* 

SELECT USERNAME, PASSWORD, ENABLED FROM USER U
 WHERE U.USERNAME = 'cacofut'
 
 SELECT 
   U.USERNAME USERNAME,  
   A.NAME  AUTHORITY
  FROM USER U, AUTHORITY A, USER_AUTHORITY UA
 WHERE U.USERNAME = 'cacofut'
   AND U.ID = UA.USER_ID
   AND A.ID = UA.AUTHORITY_ID

SELECT 
   USERNAME, 
   PASSWORD, 
   ENABLED 
  FROM USER U, AUTHORITY A, USER_AUTHORITY UA
 WHERE U.USERNAME = 'cacofut'
   AND U.ID = UA.USER_ID
   AND A.ID = UA.AUTHORITY_ID

*/
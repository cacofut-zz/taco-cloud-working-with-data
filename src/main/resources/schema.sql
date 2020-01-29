

create table if not exists Ingredient(	
	id identity,
	codigo varchar(4) not null,
	name   varchar(50) not null,
	type   varchar(10) not null
);

create table if not exists Taco(
	id identity, 
 	name varchar(50) not null,
 	createdAt timestamp not null
);

create table if not exists Taco_ingredients(
	taco_id bigint not null,
	ingredient_id bigint not null
);


create table if not exists Taco_Order(
	id identity,
	deliveryName varchar(50) not null, 
	deliveryStreet varchar(50) not null,
	deliveryCity varchar(50) not null,
	deliveryState varchar(2) not null,
	deliveryZip varchar(10) not null,
	ccNumber varchar(16) not null,
	ccExpiration varchar(5) not null, 
	ccCVV varchar(3) not null, 
	placeAt timestamp not null
);

create table if not exists Taco_Order_Tacos(
	taco_order_id bigint not null,
	taco_id bigint not null
); 


alter table Taco_ingredients
  add foreign key(taco_id) references Taco(id);
  
alter table Taco_ingredients
  add foreign key(ingredient_id) references Ingredient(id);
  
  
  alter table Taco_Order_Tacos
  add foreign key(taco_order_id) references Taco_Order(id);
  
alter table Taco_Order_Tacos
  add foreign key(taco_id) references Taco(id);
 
  





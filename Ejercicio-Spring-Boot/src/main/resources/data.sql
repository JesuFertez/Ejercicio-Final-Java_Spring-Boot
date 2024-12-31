insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Manuel', 'Hernández', '15667896-5', 'Valparaíso', 'Hijuelas', 'Las Camelias', 33, '1975-12-05', '97656445', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Mónica', 'Hernández', '15887896-5', 'Valparaíso', 'Casa Blanca', 'Las Verbenas', 854, '1983-10-03', '97655555', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Manuel', 'López', '15602334-7', 'Valparaíso', 'Peña Blanca', 'El Bosque Verde', 665, '1970-10-27', '987645633', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Alberto', 'Herrera', '17835455-7', 'Valparaíso', 'Valparaíso', 'Las Piñuflas', 26, '1985-11-15', '953672871', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('María', 'Castillo', '23176546-6', 'Valparaíso', 'Quilpué', 'El Piñon', 227, '1983-01-11', '936527788', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Pedro', 'Flores', '12776556-3', 'Valparaíso', 'Valparaíso', 'Calle Larga', 2678, '2000-02-27', '946758329', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Yerko', 'Gómez', '13776564-9', 'Valparaíso', 'Villa Alemana', 'Avenida Siempre Viva', 2442, '1990-09-17', '936547766', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Marta', 'Alvarado', '24665334-k', 'Valparaíso', 'Calera', 'Callejón Oscuro', 1988, '1999-03-30', '987878744', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Osvaldo', 'Cortez', '13256634-5', 'Valparaíso', 'Limache', 'One Way', 35, '1998-08-14', '987367745', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Laura', 'Montenegro', '17889876-1', 'Valparaíso', 'Olmué', 'La Arboleda', 39, '1963-04-07', '987665544', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Ernesto', 'Lazcano', '19887889-9', 'Valparaíso', 'Hijuelas', 'Villa Amarilla', 64, '1968-09-19', '983645577', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Naomí', 'Pangüi', '16443234-8', 'Valparaíso', 'Casa Blanca', 'Las Amapolas', 88, '1996-11-22', '983664457', true);
insert into customer (name, last_name, run, city, commune, street, number, date_of_birth, phone, is_active) values ('Ester', 'Montero', '15554345-3', 'Valparaíso', 'Quilpué', 'El Arbolado', 290, '1982-10-18', '998988788', true);

insert into plans (name, price, services_provided, active) values ('más x menos', 29990, 'internet ilimitado', true);
insert into plans (name, price, services_provided, active) values ('promo spring', 20000, 'internet ilimitado, 500 minutos', false);
insert into plans (name, price, services_provided, active) values ('vacaciones por el mundo', 35000, 'internet ilimitado, llamadas ilimitadas, cobertura en el extranjero', true);
insert into plans (name, price, services_provided, active) values ('promo winter', 23000, 'internet ilimitado, 900 minutos', false);
insert into plans (name, price, services_provided, active) values ('promo summer', 25000, 'internet ilimitado, 1000 minutos', true);
insert into plans (name, price, services_provided, active) values ('plan estudiante', 13990, 'internet ilimitado, 200 minutos', true);

insert into contracts (customer_id, plan_id, start_date, end_date) values (1, 1, '2024-12-29', '2025-12-29');
insert into contracts (customer_id, plan_id, start_date, end_date) values (3, 4, '2024-12-20', '2026-12-28');
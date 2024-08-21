-- CREACION DE PROCEDIMIENTO PARA OBTENER EMPLEADOS POR SU DEPARTAMENTO

--CREATE PROCEDURE get_empleados_por_id_departamento(id_departamento integer)
--LANGUAGE SQL
--BEGIN
	--DECLARE c CURSOR WITH RETURN TO CALLER FOR
  --SELECT * FROM empleados WHERE id_departamento = id_departamento;
--END;


-- CREACIÓN DE FUNCIÓN PARA OBTENER EMPLEADOS POR SU DEPARTAMENTO -> https://www.ibm.com/docs/en/db2-for-zos/12?topic=statements-create-function-sql-table

CREATE FUNCTION get_empleados_por_id_departamento (id_departamento_in INT)
	RETURNS TABLE (id bigint, apellido_materno varchar(255), apellido_paterno varchar(255), fecha_nacimiento date, primer_nombre varchar(255), segundo_nombre varchar(255), fecha_ingreso date, numero_empleado varchar(255), salario_bruto numeric(31,0), id_departamento integer)
	LANGUAGE SQL
	SPECIFIC DEPTINFO
	NOT DETERMINISTIC
	READS SQL DATA
	RETURN
		SELECT * FROM empleados WHERE empleados.id_departamento = id_departamento_in;

-- CREACION DE PROCEDIMIENTO PARA ACTUALIZAR EL NOMBRE DEL DEPARTAMENTO

CREATE PROCEDURE update_nombre_departamento(id_departamento integer, nuevo_nombre varchar(255))
LANGUAGE SQL
BEGIN
  UPDATE departamentos SET nombre = nuevo_nombre WHERE ID = id_departamento;
END;


insert into departamentos (id, nombre, descripcion) values (1, 'TI', 'Descripción TI');
insert into departamentos (id, nombre, descripcion) values (2, 'RR.HH.','Descripción RR.HH.');
insert into departamentos (id, nombre, descripcion) values (3, 'FINANZAS','Descripción FINANZAS');
insert into departamentos (id, nombre, descripcion) values (4, 'LEGAL','Descripción LEGAL');
insert into departamentos (id, nombre, descripcion) values (5, 'COMPRAS','Descripción COMPRAS');

insert into empleados (id, apellido_materno, apellido_paterno, fecha_nacimiento, primer_nombre, segundo_nombre, fecha_ingreso, numero_empleado, salario_bruto, id_departamento) values (1, 'Oliver', 'Ávila', '1994-03-02', 'Saúl', 'Israel', '2024-09-10', '5155615', 10000.00, 1);
insert into empleados (id, apellido_materno, apellido_paterno, fecha_nacimiento, primer_nombre, segundo_nombre, fecha_ingreso, numero_empleado, salario_bruto, id_departamento) values (2, 'Hernadez', 'Marques', '1994-03-02', 'Carlos', null, '2024-09-10', '5155615', 10000.00, 2);
insert into empleados (id, apellido_materno, apellido_paterno, fecha_nacimiento, primer_nombre, segundo_nombre, fecha_ingreso, numero_empleado, salario_bruto, id_departamento) values (3, 'Soprano', 'Del Carmen', '1994-03-02', 'Maria', 'Isabel', '2024-09-10', '5155615', 10000.00, 1);
insert into empleados (id, apellido_materno, apellido_paterno, fecha_nacimiento, primer_nombre, segundo_nombre, fecha_ingreso, numero_empleado, salario_bruto, id_departamento) values (4, 'Oliver', 'Gasca', '1994-03-02', 'Nayeli', 'Julia', '2024-09-10', '5155615', 10000.00, 5);

-- CREACION DE SP PARA OBTENER EMPLEADOS POR SU DEPARTAMENTO

--CREATE OR REPLACE PROCEDURE get_empleados_por_id_departamento(IN id_departamento_in integer)
--LANGUAGE SQL
--BEGIN ATOMIC
  --SELECT * FROM public.empleados WHERE id_departamento = id_departamento_in;
--END;

-- CREACION DE SP PARA OBTENER EMPLEADOS POR SU DEPARTAMENTO -> https://www.squash.io/using-select-query-as-a-stored-procedure-in-postgresql/

CREATE OR REPLACE FUNCTION get_empleados_por_id_departamento(IN id_departamento_in INTEGER)
RETURNS TABLE (id bigint, apellido_materno varchar, apellido_paterno varchar, fecha_nacimiento date, primer_nombre varchar, segundo_nombre varchar, fecha_ingreso date, numero_empleado varchar, salario_bruto numeric, id_departamento integer)
AS $$
BEGIN
    RETURN QUERY SELECT * FROM empleados WHERE empleados.id_departamento = id_departamento_in;
END;
$$ LANGUAGE plpgsql;

-- CREACION DE SP PARA ACTUALIZAR EL NOMBRE DEL DEPARTAMENTO

CREATE PROCEDURE update_nombre_departamento(id_departamento integer, nuevo_nombre varchar(255))
LANGUAGE SQL
BEGIN ATOMIC
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

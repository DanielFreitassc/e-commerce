Primeira aula Resolvendo um quiz do site [SQL Murder Mystery ](https://mystery.knightlab.com/)
```
SELECT * FROM crime_scene_report
WHERE date = "20180115" and type = "murder" and city = "SQL City"

SELECT * FROM person
WHERE address_street_name = "Northwestern Dr" order by address_number DESC

SELECT *
FROM person
WHERE name like '%Annabel%' AND address_street_name = "Franklin Ave";

SELECT *
FROM interview
WHERE person_id = 14887 OR person_id = 16371;

SELECT *
FROM get_fit_now_check_in 
WHERE membership_id like "%48Z%" AND check_in_date = 20180109 
order by check_in_date;

SELECT *
FROM drivers_license
WHERE plate_number like "%H42W%";

SELECT *
FROM person
WHERE license_id = "423327" OR license_id = "664760";

SELECT *
FROM get_fit_now_member
WHERE person_id = "51739" OR person_id = "67318";

SELECT *
FROM interview
WHERE person_id = 67318;

SELECT *
FROM drivers_license
WHERE car_make = "Tesla" AND car_model = "Model S" AND 
gender = "female" AND hair_color = "red";

SELECT *
FROM person
WHERE license_id = "202298" OR license_id = "291182" OR license_id = "918773";

SELECT person_id, count(*), event_name
FROM facebook_event_checkin 
GROUP BY person_id
having count(*) = 3 AND event_name = "SQL Symphony Concert" AND date like "%201712%";

```
# Aula 3 
```
SELECT * 
FROM aluno INNER JOIN notebook
ON aluno.code_note=notebook.cod

SELECT * 
FROM aluno LEFT JOIN notebook
ON aluno.code_note=notebook.cod

SELECT * 
FROM aluno RIGHT JOIN notebook
ON aluno.code_note=notebook.cod

SELECT * 
FROM aluno FULL JOIN notebook
ON aluno.code_note=notebook.cod

SELECT * 
FROM aluno CROSS JOIN notebook
ON aluno.code_note=notebook.cod

```

# 1. (Criar com CTE e subconsulta) Utilizando a linguagem SQL, execute consultas que possam responder a
seguinte questão: Qual(is) Carro(s) possui(em) mais sinistros cadastrados?

```
WITH placaSinistro as (
	SELECT placa FROM sinistro
	WHERE placa = placa
)

SELECT placa, count(*) as num FROM placaSinistro
group by placa
order by num desc

```
# 2. Quais clientes cadastrados possuem letra “a” no meio e não no final? 
```
SELECT nome FROM cliente
WHERE nome like '%a%' AND nome LIKE 'a%'
```
# 3. (Criar com JOIN, subconsultas correlacionada e aninhada) Quais clientes não possuem apólice?
```
SELECT nome FROM cliente c
WHERE nome  NOT IN (
	SELECT nome FROM apolice a
	WHERE c.cod_cliente = a.cod_cliente
)

SELECT nome 
FROM cliente 
LEFT JOIN apolice 
ON cliente.cod_cliente = apolice.cod_cliente 
WHERE apolice.cod_cliente IS NULL;
```
# 4. (Criar com JOIN, subconsultas correlacionada e aninhada) Quais carros não possuem apólice?
```
SELECT *
FROM carro
WHERE placa NOT IN (SELECT placa FROM apolice);
```
# 5. Quais clientes temos hoje na base de dados?
```
SELECT  * FROM cliente
```
# 6. Quais carros possuem a placa iniciando com as letras L ou M
```
SELECT  placa FROM carro
WHERE placa LIKE 'L%' OR placa LIKE 'M%'
```
# 7. Quais são os sinistros que ocorreram em 2022?
```
SELECT data_sinistro FROM sinistro
WHERE data_sinistro 
```

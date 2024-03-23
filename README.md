```
 SELECT cod_apolice
 ,(SELECT nome FROM cliente WHERE cliente.cod_cliente = apolice.cod_cliente) AS nm_clinte
 ,data_inicio_vigencia
 ,data_fim_vigencia
 ,valor_cobertura
 ,valor_franquia
 ,placa
 FROM apolice
ORDER BY data_fim_vigencia ASC

GO

SELECT cod_apolice
 ,nome 
 ,data_inicio_vigencia
 ,data_fim_vigencia
 ,valor_cobertura
 ,valor_franquia
 ,placa
 FROM apolice
 INNER JOIN 
 cliente

 ON cliente.cod_cliente = apolice.cod_cliente
ORDER BY data_fim_vigencia ASC
GO

SELECT * , ROW_NUMBER() OVER(ORDER BY local_sinistro) AS ordem
FROM sinistro 
GO

SELECT * , RANK() OVER(ORDER BY local_sinistro) AS ordem
FROM sinistro
GO 

SELECT *, DENSE_RANK() OVER(ORDER BY local_sinistro) AS ordem
FROM sinistro
GO

WITH cte1 AS (
	SELECT placa, count(1) AS qtde
	FROM sinistro
	GROUP BY placa
)
SELECT * 
FROM carro
WHERE placa in (
	select placa
    FROM cte1
	WHERE qtde in (
		SELECT MAX(qtde)
		FROM cte1))
go
```

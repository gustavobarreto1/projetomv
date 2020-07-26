create table cliente(
personalid char(11) not null,
nome VARCHAR2(255 BYTE) not null,
telefone VARCHAR2(255 BYTE) not null,
tipoPessoa VARCHAR2(255 BYTE),
email VARCHAR2(255 BYTE) not null,
rg    VARCHAR2(255 BYTE) not null,
sexo VARCHAR2(255 BYTE) not null,
CONSTRAINT pk_personalid PRIMARY KEY (personalid)
)TABLESPACE system;

create table endereco(
cep VARCHAR2(255 BYTE) not null,
rua VARCHAR2(255 BYTE) not null,
numero VARCHAR2(255 BYTE),
personalid CHAR(11) not null,
CONSTRAINT fk_personalid FOREIGN KEY (personalid) REFERENCES cliente(personalid)
)TABLESPACE system;

CREATE OR REPLACE FUNCTION f_numero_clientes
RETURN NUMBER
AS
   registros Integer;
BEGIN
   SELECT COUNT(*) INTO registros
       FROM cliente;
  RETURN registros;
END;


CREATE OR REPLACE FUNCTION f_tipo_cliente
RETURN VARCHAR2
AS
   pj VARCHAR2(15);
BEGIN
    pj := 'Pessoa Juridica';
  RETURN pj;
END;

commit;



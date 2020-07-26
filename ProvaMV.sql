create table cliente(
personalid char(11) not null,
nome VARCHAR2(255 BYTE),
telefone VARCHAR2(255 BYTE),
tipoPessoa VARCHAR2(255 BYTE),
email VARCHAR2(255 BYTE),
rg    VARCHAR2(255 BYTE),
sexo VARCHAR2(255 BYTE),
CONSTRAINT pk_personalid PRIMARY KEY (personalid)
)TABLESPACE system;

create table endereco(
cep VARCHAR2(255 BYTE),
rua VARCHAR2(255 BYTE),
numero VARCHAR2(255 BYTE),
personalid CHAR(11) not null,
CONSTRAINT fk_personalid FOREIGN KEY (personalid) REFERENCES cliente(personalid)
)TABLESPACE system;

CREATE FUNCTION f_tipoPessoa
RETURN VARCHAR(15);
IS
BEGIN
tipoP VARCHAR(15);
tipoP = 'Pessoa Juridica';
return tipoP;
END;
commit;



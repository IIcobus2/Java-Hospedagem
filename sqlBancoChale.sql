
CREATE SCHEMA IF NOT EXISTS `bancoreserva` DEFAULT CHARACTER SET utf8 ;
USE `bancoreserva` ;

-- -----------------------------------------------------
-- Table `bancoreserva`.`tb_chales`
-- -----------------------------------------------------
CREATE TABLE bancoreserva.tb_chales
(
    "codChale" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    localizacao character varying(45) COLLATE pg_catalog."default",
    capacidade integer,
    "valorAltaEstacao" integer,
    "valorBaixaEstacao" integer,
    CONSTRAINT "codChale" PRIMARY KEY ("codChale")
)

TABLESPACE pg_default;

ALTER TABLE bancoreserva.tb_chales
    OWNER to postgres;


-- -----------------------------------------------------
-- Table `bancoreserva`.`tb_hospedagem`
-- -----------------------------------------------------
CREATE TABLE bancoreserva.tb_cliente
(
    "nomeCliente" character varying(45) COLLATE pg_catalog."default",
    "enderecoCliente" character varying(45) COLLATE pg_catalog."default",
    "bairroCliente" character varying(45) COLLATE pg_catalog."default",
    "cidadeCliente" character varying(45) COLLATE pg_catalog."default",
    "estadoCliente" character varying(45) COLLATE pg_catalog."default",
    "CEPCliente" character varying(45) COLLATE pg_catalog."default",
    "nascimentoCliente" character varying(45) COLLATE pg_catalog."default",
    "rgCliente" character(45) COLLATE pg_catalog."default",
    "codCliente" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    CONSTRAINT "codCliente" PRIMARY KEY ("codCliente")
)

TABLESPACE pg_default;

ALTER TABLE bancoreserva.tb_cliente
    OWNER to postgres;


-- -----------------------------------------------------
-- Table `bancoreserva`.`tb_cliente`
-- -----------------------------------------------------
CREATE TABLE bancoreserva.tb_hospedagem
(
    "codHospedagem" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    estado character varying(45) COLLATE pg_catalog."default",
    "qntPessoas" integer,
    desconto integer,
    "valorFinal" integer,
    "codCliente" integer NOT NULL,
    "codChale" integer NOT NULL,
    "dataInicio" integer,
    "dataFim" integer,
    CONSTRAINT "codHospedagem" PRIMARY KEY ("codHospedagem"),
    CONSTRAINT "codChale" FOREIGN KEY ("codChale")
        REFERENCES bancoreserva.tb_chales ("codChale") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "codCliente" FOREIGN KEY ("codCliente")
        REFERENCES bancoreserva.tb_cliente ("codCliente") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE bancoreserva.tb_hospedagem
    OWNER to postgres;
-- Index: fki_codChale

-- DROP INDEX bancoreserva."fki_codChale";

CREATE INDEX "fki_codChale"
    ON bancoreserva.tb_hospedagem USING btree
    ("codChale" ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: fki_codCliente

-- DROP INDEX bancoreserva."fki_codCliente";

CREATE INDEX "fki_codCliente"
    ON bancoreserva.tb_hospedagem USING btree
    ("codCliente" ASC NULLS LAST)
    TABLESPACE pg_default;


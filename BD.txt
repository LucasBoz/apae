-- Table: public.aluno

-- DROP TABLE public.aluno;

CREATE TABLE public.aluno
(
  id bigint NOT NULL DEFAULT nextval('aluno_id_seq'::regclass),
  created timestamp without time zone NOT NULL,
  updated timestamp without time zone,
  alergia character varying(100),
  autorizacao_ir_sozinho boolean,
  bairro character varying(100),
  beneficio character varying(100),
  bolsa_familia boolean,
  bpc character varying(100),
  cep character varying(8),
  certidao_nacimento character varying(100),
  cpf character varying(100),
  data_matricula timestamp without time zone,
  data_nacimento timestamp without time zone,
  endereco character varying(100),
  folha character varying(100),
  livro character varying(100),
  matricula character varying(100),
  naturalidade character varying(100),
  nome character varying(100),
  rg character varying(100),
  sere_cgm character varying(100),
  sexo character(1),
  sus character varying(100),
  telefone character varying(100),
  cid_id bigint,
  transporte_id bigint,
  CONSTRAINT aluno_pkey PRIMARY KEY (id),
  CONSTRAINT fk_aluno_cid_id FOREIGN KEY (cid_id)
      REFERENCES public.cid10 (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_aluno_transporte_id FOREIGN KEY (transporte_id)
      REFERENCES public.transporte (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.aluno
  OWNER TO postgres;

-- Table: public.responsavel

-- DROP TABLE public.responsavel;

CREATE TABLE public.responsavel
(
  id bigint NOT NULL DEFAULT nextval('responsavel_id_seq'::regclass),
  created timestamp without time zone NOT NULL,
  updated timestamp without time zone,
  cpf character varying(11),
  local_trabalho character varying(100),
  nome character varying(100) NOT NULL,
  rg character varying(11),
  telefone character varying(50) NOT NULL,
  CONSTRAINT responsavel_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.responsavel
  OWNER TO postgres;

-- Table: public.aluno_responsavel

-- DROP TABLE public.aluno_responsavel;

CREATE TABLE public.aluno_responsavel
(
  aluno_id bigint NOT NULL,
  responsavel_id bigint NOT NULL,
  CONSTRAINT aluno_responsavel_pkey PRIMARY KEY (aluno_id, responsavel_id),
  CONSTRAINT fk_aluno_responsavel_aluno_id FOREIGN KEY (aluno_id)
      REFERENCES public.aluno (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_aluno_responsavel_responsavel_id FOREIGN KEY (responsavel_id)
      REFERENCES public.responsavel (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.aluno_responsavel
  OWNER TO postgres;

-- Table: public.cid10

-- DROP TABLE public.cid10;

CREATE TABLE public.cid10
(
  id bigint NOT NULL DEFAULT nextval('cid10_id_seq'::regclass),
  created timestamp without time zone NOT NULL,
  updated timestamp without time zone,
  ativo boolean,
  cat character varying(100),
  cid10 character varying(123),
  definicao character varying(100),
  descr character varying(50),
  opc character varying(123),
  restrsexo character varying(123),
  subcat character varying(123),
  CONSTRAINT cid10_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.cid10
  OWNER TO postgres;

-- Table: public.responsavel

-- DROP TABLE public.responsavel;

CREATE TABLE public.responsavel
(
  id bigint NOT NULL DEFAULT nextval('responsavel_id_seq'::regclass),
  created timestamp without time zone NOT NULL,
  updated timestamp without time zone,
  cpf character varying(11),
  local_trabalho character varying(100),
  nome character varying(100) NOT NULL,
  rg character varying(11),
  telefone character varying(50) NOT NULL,
  CONSTRAINT responsavel_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.responsavel
  OWNER TO postgres;
-- Table: public.transporte

-- DROP TABLE public.transporte;

CREATE TABLE public.transporte
(
  id bigint NOT NULL DEFAULT nextval('transporte_id_seq'::regclass),
  created timestamp without time zone NOT NULL,
  updated timestamp without time zone,
  nome character varying(100),
  telefone character varying(100),
  tipo_transporte integer,
  CONSTRAINT transporte_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.transporte
  OWNER TO postgres;
-- Table: public."user"

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
  id bigint NOT NULL DEFAULT nextval('user_id_seq'::regclass),
  created timestamp without time zone NOT NULL,
  updated timestamp without time zone,
  email character varying(144) NOT NULL,
  enabled boolean NOT NULL,
  last_login timestamp without time zone,
  name character varying(50) NOT NULL,
  password character varying(100) NOT NULL,
  role integer NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id),
  CONSTRAINT uk_user_email UNIQUE (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."user"
  OWNER TO postgres;

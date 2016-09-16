--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

-- Started on 2016-09-14 20:25:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 9 (class 2615 OID 96615)
-- Name: auditing; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA auditing;


ALTER SCHEMA auditing OWNER TO postgres;

--
-- TOC entry 2 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2474 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1 (class 3079 OID 16407)
-- Name: unaccent; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS unaccent WITH SCHEMA pg_catalog;


--
-- TOC entry 2475 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION unaccent; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION unaccent IS 'text search dictionary that removes accents';


SET search_path = auditing, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 201 (class 1259 OID 96694)
-- Name: area_atendimento_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE area_atendimento_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    nome character varying(100)
);


ALTER TABLE area_atendimento_audited OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 96699)
-- Name: certidao_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE certidao_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    folha character varying(100),
    livro character varying(100),
    numero character varying(100)
);


ALTER TABLE certidao_audited OWNER TO postgres;


--
-- TOC entry 204 (class 1259 OID 96709)
-- Name: endereco_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE endereco_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    bairro character varying(100),
    cep character varying(20),
    complemento character varying(100),
    logradouro character varying(100),
    municipio character varying(100),
    numero character varying(50),
    uf character varying(2)
);


ALTER TABLE endereco_audited OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 96714)
-- Name: familiar_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE familiar_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    tipo_responsavel integer,
    aluno_id bigint,
    responsavel_id bigint
);


ALTER TABLE familiar_audited OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 96719)
-- Name: formacao_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE formacao_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    ano_conclusao integer,
    ano_inicio integer,
    area character varying(100),
    codigo character varying(100),
    formacao_pedagoga boolean,
    nome_instituicao character varying(100),
    situacao integer,
    tipo_instituicao integer
);


ALTER TABLE formacao_audited OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 96724)
-- Name: funcionario_curso_especificos_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE funcionario_curso_especificos_audited (
    revision bigint NOT NULL,
    funcionario_id bigint NOT NULL,
    curso_especifico integer NOT NULL,
    revision_type smallint
);


ALTER TABLE funcionario_curso_especificos_audited OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 96729)
-- Name: funcionario_formacao_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE funcionario_formacao_audited (
    revision bigint NOT NULL,
    pessoa_id bigint NOT NULL,
    id bigint NOT NULL,
    revision_type smallint
);


ALTER TABLE funcionario_formacao_audited OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 96734)
-- Name: funcionario_funcao_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE funcionario_funcao_audited (
    revision bigint NOT NULL,
    funcionario_id bigint NOT NULL,
    funcao integer NOT NULL,
    revision_type smallint
);


ALTER TABLE funcionario_funcao_audited OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 96739)
-- Name: irmao_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE irmao_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    data_nascimento timestamp without time zone,
    nome character varying(100)
);


ALTER TABLE irmao_audited OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 96744)
-- Name: medida_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE medida_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    altura real,
    data_medicao timestamp without time zone,
    peso real
);


ALTER TABLE medida_audited OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 96749)
-- Name: pessoa_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE pessoa_audited (
    dtype character varying(31) NOT NULL,
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    cpf character varying(20),
    data_nascimento timestamp without time zone,
    nome character varying(100),
    rg character varying(20),
    sexo integer,
    local_trabalho character varying(100),
    codigo_inep character varying(12),
    cor integer,
    email character varying(100),
    escolaridade integer,
    nome_mae character varying(100),
    nome_pai character varying(100),
    numero_identificacao_social character varying(100),
    tipo_deficiencia integer,
    endereco_id bigint,
    local_nascimento_id bigint,
    alergia character varying(100),
    autorizacao_ir_sozinho boolean,
    beneficio character varying(100),
    bolsa_familia boolean,
    bpc character varying(100),
    naturalidade character varying(100),
    sere_cgm character varying(100),
    sus character varying(100),
    posicao_lista_espera_id bigint,
    transporte_id bigint
);


ALTER TABLE pessoa_audited OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 96757)
-- Name: pessoa_irmao_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE pessoa_irmao_audited (
    revision bigint NOT NULL,
    pessoa_id bigint NOT NULL,
    irmao_id bigint NOT NULL,
    revision_type smallint
);


ALTER TABLE pessoa_irmao_audited OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 96762)
-- Name: pessoa_voluntariado_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE pessoa_voluntariado_audited (
    revision bigint NOT NULL,
    pessoa_id bigint NOT NULL,
    voluntariado_id bigint NOT NULL,
    revision_type smallint
);


ALTER TABLE pessoa_voluntariado_audited OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 96767)
-- Name: posicao_lista_espera_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE posicao_lista_espera_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    data_avaliacao timestamp without time zone,
    posicao integer,
    turma integer,
    aluno_id bigint
);


ALTER TABLE posicao_lista_espera_audited OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 96618)
-- Name: revision; Type: TABLE; Schema: auditing; Owner: postgres
--


ALTER TABLE revision OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 96616)
-- Name: revision_id_seq; Type: SEQUENCE; Schema: auditing; Owner: postgres
--

CREATE SEQUENCE revision_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE revision_id_seq OWNER TO postgres;

--
-- TOC entry 2476 (class 0 OID 0)
-- Dependencies: 184
-- Name: revision_id_seq; Type: SEQUENCE OWNED BY; Schema: auditing; Owner: postgres
--

ALTER SEQUENCE revision_id_seq OWNED BY revision.id;


--
-- TOC entry 216 (class 1259 OID 96772)
-- Name: telefone_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE telefone_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    numero character varying(100),
    tipo character varying(50),
    pessoa_id bigint
);


ALTER TABLE telefone_audited OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 96777)
-- Name: termo_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE termo_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    data_fim timestamp without time zone,
    data_geracao timestamp without time zone,
    data_inicio timestamp without time zone
);


ALTER TABLE termo_audited OWNER TO postgres;


--
-- TOC entry 219 (class 1259 OID 96787)
-- Name: voluntariado_audited; Type: TABLE; Schema: auditing; Owner: postgres
--

CREATE TABLE voluntariado_audited (
    id bigint NOT NULL,
    revision bigint NOT NULL,
    revision_type smallint,
    data_fim timestamp without time zone,
    data_inicio timestamp without time zone,
    termo_id bigint
);


ALTER TABLE voluntariado_audited OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- TOC entry 196 (class 1259 OID 96670)
-- Name: aluno_deficiencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE aluno_deficiencia (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    deficiencia integer,
    aluno_id bigint
);


ALTER TABLE aluno_deficiencia OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 96668)
-- Name: aluno_deficiencia_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE aluno_deficiencia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE aluno_deficiencia_id_seq OWNER TO postgres;

--
-- TOC entry 2478 (class 0 OID 0)
-- Dependencies: 195
-- Name: aluno_deficiencia_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE aluno_deficiencia_id_seq OWNED BY aluno_deficiencia.id;


--
-- TOC entry 198 (class 1259 OID 96678)
-- Name: area_atendimento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE area_atendimento (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    nome character varying(100)
);


ALTER TABLE area_atendimento OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 96676)
-- Name: area_atendimento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE area_atendimento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE area_atendimento_id_seq OWNER TO postgres;

--
-- TOC entry 2479 (class 0 OID 0)
-- Dependencies: 197
-- Name: area_atendimento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE area_atendimento_id_seq OWNED BY area_atendimento.id;


--
-- TOC entry 221 (class 1259 OID 96794)
-- Name: certidao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE certidao (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    folha character varying(100),
    livro character varying(100),
    numero character varying(100)
);


ALTER TABLE certidao OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 96792)
-- Name: certidao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE certidao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE certidao_id_seq OWNER TO postgres;

--
-- TOC entry 2480 (class 0 OID 0)
-- Dependencies: 220
-- Name: certidao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE certidao_id_seq OWNED BY certidao.id;


--
-- TOC entry 223 (class 1259 OID 96802)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE endereco (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    bairro character varying(100),
    cep character varying(20),
    complemento character varying(100),
    logradouro character varying(100),
    municipio character varying(100),
    numero character varying(50),
    uf character varying(2)
);


ALTER TABLE endereco OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 96800)
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE endereco_id_seq OWNER TO postgres;

--
-- TOC entry 2482 (class 0 OID 0)
-- Dependencies: 222
-- Name: endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE endereco_id_seq OWNED BY endereco.id;


--
-- TOC entry 225 (class 1259 OID 96810)
-- Name: familiar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE familiar (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    tipo_responsavel integer,
    aluno_id bigint,
    responsavel_id bigint
);


ALTER TABLE familiar OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 96808)
-- Name: familiar_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE familiar_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE familiar_id_seq OWNER TO postgres;

--
-- TOC entry 2483 (class 0 OID 0)
-- Dependencies: 224
-- Name: familiar_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE familiar_id_seq OWNED BY familiar.id;


--
-- TOC entry 227 (class 1259 OID 96818)
-- Name: formacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE formacao (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    ano_conclusao integer,
    ano_inicio integer,
    area character varying(100),
    codigo character varying(100),
    formacao_pedagoga boolean,
    nome_instituicao character varying(100),
    situacao integer,
    tipo_instituicao integer,
    pessoa_id bigint
);


ALTER TABLE formacao OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 96816)
-- Name: formacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE formacao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE formacao_id_seq OWNER TO postgres;

--
-- TOC entry 2484 (class 0 OID 0)
-- Dependencies: 226
-- Name: formacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE formacao_id_seq OWNED BY formacao.id;


--
-- TOC entry 228 (class 1259 OID 96824)
-- Name: funcionario_curso_especificos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE funcionario_curso_especificos (
    funcionario_id bigint NOT NULL,
    curso_especifico integer NOT NULL
);


ALTER TABLE funcionario_curso_especificos OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 96829)
-- Name: funcionario_funcao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE funcionario_funcao (
    funcionario_id bigint NOT NULL,
    funcao integer NOT NULL
);


ALTER TABLE funcionario_funcao OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 96836)
-- Name: irmao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE irmao (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    data_nascimento timestamp without time zone,
    nome character varying(100)
);


ALTER TABLE irmao OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 96834)
-- Name: irmao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE irmao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE irmao_id_seq OWNER TO postgres;

--
-- TOC entry 2485 (class 0 OID 0)
-- Dependencies: 230
-- Name: irmao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE irmao_id_seq OWNED BY irmao.id;


--
-- TOC entry 233 (class 1259 OID 96844)
-- Name: medida; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE medida (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    altura real NOT NULL,
    data_medicao timestamp without time zone,
    peso real NOT NULL
);


ALTER TABLE medida OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 96842)
-- Name: medida_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE medida_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE medida_id_seq OWNER TO postgres;

--
-- TOC entry 2486 (class 0 OID 0)
-- Dependencies: 232
-- Name: medida_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE medida_id_seq OWNED BY medida.id;


--
-- TOC entry 235 (class 1259 OID 96852)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pessoa (
    dtype character varying(31) NOT NULL,
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    cpf character varying(20),
    data_nascimento timestamp without time zone,
    nome character varying(100) NOT NULL,
    rg character varying(20),
    sexo integer,
    alergia character varying(100),
    autorizacao_ir_sozinho boolean,
    beneficio character varying(100),
    bolsa_familia boolean,
    bpc character varying(100),
    naturalidade character varying(100),
    sere_cgm character varying(100),
    sus character varying(100),
    codigo_inep character varying(12),
    cor integer,
    email character varying(100),
    escolaridade integer,
    nome_mae character varying(100),
    nome_pai character varying(100),
    numero_identificacao_social character varying(100),
    tipo_deficiencia integer,
    local_trabalho character varying(100),
    posicao_lista_espera_id bigint,
    transporte_id bigint,
    endereco_id bigint,
    local_nascimento_id bigint
);


ALTER TABLE pessoa OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 96850)
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 2487 (class 0 OID 0)
-- Dependencies: 234
-- Name: pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pessoa_id_seq OWNED BY pessoa.id;


--
-- TOC entry 236 (class 1259 OID 96861)
-- Name: pessoa_irmao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pessoa_irmao (
    pessoa_id bigint NOT NULL,
    irmao_id bigint NOT NULL
);


ALTER TABLE pessoa_irmao OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 96864)
-- Name: pessoa_voluntariado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pessoa_voluntariado (
    pessoa_id bigint NOT NULL,
    voluntariado_id bigint NOT NULL
);


ALTER TABLE pessoa_voluntariado OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 96869)
-- Name: posicao_lista_espera; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE posicao_lista_espera (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    data_avaliacao timestamp without time zone,
    posicao integer,
    turma integer,
    aluno_id bigint
);


ALTER TABLE posicao_lista_espera OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 96867)
-- Name: posicao_lista_espera_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE posicao_lista_espera_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE posicao_lista_espera_id_seq OWNER TO postgres;

--
-- TOC entry 2488 (class 0 OID 0)
-- Dependencies: 238
-- Name: posicao_lista_espera_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE posicao_lista_espera_id_seq OWNED BY posicao_lista_espera.id;


--
-- TOC entry 183 (class 1259 OID 96515)
-- Name: schema_version; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE schema_version (
    version_rank integer NOT NULL,
    installed_rank integer NOT NULL,
    version character varying(50) NOT NULL,
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE schema_version OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 96877)
-- Name: telefone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE telefone (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    numero character varying(100) NOT NULL,
    tipo character varying(50),
    pessoa_id bigint
);


ALTER TABLE telefone OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 96875)
-- Name: telefone_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE telefone_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE telefone_id_seq OWNER TO postgres;

--
-- TOC entry 2489 (class 0 OID 0)
-- Dependencies: 240
-- Name: telefone_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE telefone_id_seq OWNED BY telefone.id;


--
-- TOC entry 243 (class 1259 OID 96885)
-- Name: termo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE termo (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    data_fim timestamp without time zone,
    data_geracao timestamp without time zone,
    data_inicio timestamp without time zone
);


ALTER TABLE termo OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 96883)
-- Name: termo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE termo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE termo_id_seq OWNER TO postgres;

--
-- TOC entry 2490 (class 0 OID 0)
-- Dependencies: 242
-- Name: termo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE termo_id_seq OWNED BY termo.id;


--
-- TOC entry 245 (class 1259 OID 96893)
-- Name: voluntariado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE voluntariado (
    id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone,
    data_fim timestamp without time zone,
    data_inicio timestamp without time zone,
    termo_id bigint
);


ALTER TABLE voluntariado OWNER TO postgres;

--
-- TOC entry 244 (class 1259 OID 96891)
-- Name: voluntariado_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE voluntariado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE voluntariado_id_seq OWNER TO postgres;

--
-- TOC entry 2493 (class 0 OID 0)
-- Dependencies: 244
-- Name: voluntariado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE voluntariado_id_seq OWNED BY voluntariado.id;


SET search_path = auditing, pg_catalog;

--
-- TOC entry 2199 (class 2604 OID 96621)
-- Name: id; Type: DEFAULT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY revision ALTER COLUMN id SET DEFAULT nextval('revision_id_seq'::regclass);


SET search_path = public, pg_catalog;

--
-- TOC entry 2203 (class 2604 OID 96665)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--




--
-- TOC entry 2204 (class 2604 OID 96673)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluno_deficiencia ALTER COLUMN id SET DEFAULT nextval('aluno_deficiencia_id_seq'::regclass);


--
-- TOC entry 2205 (class 2604 OID 96681)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY area_atendimento ALTER COLUMN id SET DEFAULT nextval('area_atendimento_id_seq'::regclass);


--
-- TOC entry 2206 (class 2604 OID 96797)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY certidao ALTER COLUMN id SET DEFAULT nextval('certidao_id_seq'::regclass);


--
-- TOC entry 2201 (class 2604 OID 96649)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--




--
-- TOC entry 2207 (class 2604 OID 96805)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco ALTER COLUMN id SET DEFAULT nextval('endereco_id_seq'::regclass);


--
-- TOC entry 2208 (class 2604 OID 96813)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar ALTER COLUMN id SET DEFAULT nextval('familiar_id_seq'::regclass);


--
-- TOC entry 2209 (class 2604 OID 96821)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY formacao ALTER COLUMN id SET DEFAULT nextval('formacao_id_seq'::regclass);


--
-- TOC entry 2210 (class 2604 OID 96839)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY irmao ALTER COLUMN id SET DEFAULT nextval('irmao_id_seq'::regclass);


--
-- TOC entry 2211 (class 2604 OID 96847)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medida ALTER COLUMN id SET DEFAULT nextval('medida_id_seq'::regclass);


--
-- TOC entry 2212 (class 2604 OID 96855)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa ALTER COLUMN id SET DEFAULT nextval('pessoa_id_seq'::regclass);


--
-- TOC entry 2213 (class 2604 OID 96872)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY posicao_lista_espera ALTER COLUMN id SET DEFAULT nextval('posicao_lista_espera_id_seq'::regclass);


--
-- TOC entry 2214 (class 2604 OID 96880)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY telefone ALTER COLUMN id SET DEFAULT nextval('telefone_id_seq'::regclass);


--
-- TOC entry 2215 (class 2604 OID 96888)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY termo ALTER COLUMN id SET DEFAULT nextval('termo_id_seq'::regclass);


--
-- TOC entry 2202 (class 2604 OID 96657)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--


--
-- TOC entry 2200 (class 2604 OID 96639)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--


--
-- TOC entry 2216 (class 2604 OID 96896)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY voluntariado ALTER COLUMN id SET DEFAULT nextval('voluntariado_id_seq'::regclass);


SET search_path = auditing, pg_catalog;


--
-- TOC entry 2243 (class 2606 OID 96693)
-- Name: aluno_deficiencia_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY aluno_deficiencia_audited
    ADD CONSTRAINT aluno_deficiencia_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2245 (class 2606 OID 96698)
-- Name: area_atendimento_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY area_atendimento_audited
    ADD CONSTRAINT area_atendimento_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2247 (class 2606 OID 96703)
-- Name: certidao_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY certidao_audited
    ADD CONSTRAINT certidao_audited_pkey PRIMARY KEY (id, revision);

--
-- TOC entry 2251 (class 2606 OID 96713)
-- Name: endereco_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY endereco_audited
    ADD CONSTRAINT endereco_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2253 (class 2606 OID 96718)
-- Name: familiar_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY familiar_audited
    ADD CONSTRAINT familiar_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2255 (class 2606 OID 96723)
-- Name: formacao_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY formacao_audited
    ADD CONSTRAINT formacao_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2257 (class 2606 OID 96728)
-- Name: funcionario_curso_especificos_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY funcionario_curso_especificos_audited
    ADD CONSTRAINT funcionario_curso_especificos_audited_pkey PRIMARY KEY (revision, funcionario_id, curso_especifico);


--
-- TOC entry 2259 (class 2606 OID 96733)
-- Name: funcionario_formacao_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY funcionario_formacao_audited
    ADD CONSTRAINT funcionario_formacao_audited_pkey PRIMARY KEY (revision, pessoa_id, id);


--
-- TOC entry 2261 (class 2606 OID 96738)
-- Name: funcionario_funcao_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY funcionario_funcao_audited
    ADD CONSTRAINT funcionario_funcao_audited_pkey PRIMARY KEY (revision, funcionario_id, funcao);


--
-- TOC entry 2263 (class 2606 OID 96743)
-- Name: irmao_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY irmao_audited
    ADD CONSTRAINT irmao_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2265 (class 2606 OID 96748)
-- Name: medida_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY medida_audited
    ADD CONSTRAINT medida_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2267 (class 2606 OID 96756)
-- Name: pessoa_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY pessoa_audited
    ADD CONSTRAINT pessoa_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2269 (class 2606 OID 96761)
-- Name: pessoa_irmao_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY pessoa_irmao_audited
    ADD CONSTRAINT pessoa_irmao_audited_pkey PRIMARY KEY (revision, pessoa_id, irmao_id);


--
-- TOC entry 2271 (class 2606 OID 96766)
-- Name: pessoa_voluntariado_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY pessoa_voluntariado_audited
    ADD CONSTRAINT pessoa_voluntariado_audited_pkey PRIMARY KEY (revision, pessoa_id, voluntariado_id);


--
-- TOC entry 2273 (class 2606 OID 96771)
-- Name: posicao_lista_espera_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY posicao_lista_espera_audited
    ADD CONSTRAINT posicao_lista_espera_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2223 (class 2606 OID 96623)
-- Name: revision_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY revision
    ADD CONSTRAINT revision_pkey PRIMARY KEY (id);


--
-- TOC entry 2275 (class 2606 OID 96776)
-- Name: telefone_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY telefone_audited
    ADD CONSTRAINT telefone_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2277 (class 2606 OID 96781)
-- Name: termo_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY termo_audited
    ADD CONSTRAINT termo_audited_pkey PRIMARY KEY (id, revision);


--
-- TOC entry 2281 (class 2606 OID 96791)
-- Name: voluntariado_audited_pkey; Type: CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY voluntariado_audited
    ADD CONSTRAINT voluntariado_audited_pkey PRIMARY KEY (id, revision);


SET search_path = public, pg_catalog;

--
-- TOC entry 2237 (class 2606 OID 96675)
-- Name: aluno_deficiencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluno_deficiencia
    ADD CONSTRAINT aluno_deficiencia_pkey PRIMARY KEY (id);


--
-- TOC entry 2239 (class 2606 OID 96683)
-- Name: area_atendimento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY area_atendimento
    ADD CONSTRAINT area_atendimento_pkey PRIMARY KEY (id);


--
-- TOC entry 2283 (class 2606 OID 96799)
-- Name: certidao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY certidao
    ADD CONSTRAINT certidao_pkey PRIMARY KEY (id);


--
-- TOC entry 2285 (class 2606 OID 96807)
-- Name: endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- TOC entry 2287 (class 2606 OID 96815)
-- Name: familiar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT familiar_pkey PRIMARY KEY (id);


--
-- TOC entry 2289 (class 2606 OID 96823)
-- Name: formacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY formacao
    ADD CONSTRAINT formacao_pkey PRIMARY KEY (id);


--
-- TOC entry 2291 (class 2606 OID 96828)
-- Name: funcionario_curso_especificos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario_curso_especificos
    ADD CONSTRAINT funcionario_curso_especificos_pkey PRIMARY KEY (funcionario_id, curso_especifico);


--
-- TOC entry 2293 (class 2606 OID 96833)
-- Name: funcionario_funcao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario_funcao
    ADD CONSTRAINT funcionario_funcao_pkey PRIMARY KEY (funcionario_id, funcao);


--
-- TOC entry 2295 (class 2606 OID 96841)
-- Name: irmao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY irmao
    ADD CONSTRAINT irmao_pkey PRIMARY KEY (id);


--
-- TOC entry 2297 (class 2606 OID 96849)
-- Name: medida_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medida
    ADD CONSTRAINT medida_pkey PRIMARY KEY (id);


--
-- TOC entry 2299 (class 2606 OID 96860)
-- Name: pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);


--
-- TOC entry 2305 (class 2606 OID 96874)
-- Name: posicao_lista_espera_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY posicao_lista_espera
    ADD CONSTRAINT posicao_lista_espera_pkey PRIMARY KEY (id);


--
-- TOC entry 2219 (class 2606 OID 96523)
-- Name: schema_version_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY schema_version
    ADD CONSTRAINT schema_version_pk PRIMARY KEY (version);


--
-- TOC entry 2307 (class 2606 OID 96882)
-- Name: telefone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_pkey PRIMARY KEY (id);


--
-- TOC entry 2309 (class 2606 OID 96890)
-- Name: termo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY termo
    ADD CONSTRAINT termo_pkey PRIMARY KEY (id);


--
-- TOC entry 2301 (class 2606 OID 96900)
-- Name: uk_pessoa_irmao_irmao_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa_irmao
    ADD CONSTRAINT uk_pessoa_irmao_irmao_id UNIQUE (irmao_id);


--
-- TOC entry 2303 (class 2606 OID 96902)
-- Name: uk_pessoa_voluntariado_voluntariado_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa_voluntariado
    ADD CONSTRAINT uk_pessoa_voluntariado_voluntariado_id UNIQUE (voluntariado_id);

--
-- TOC entry 2311 (class 2606 OID 96898)
-- Name: voluntariado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY voluntariado
    ADD CONSTRAINT voluntariado_pkey PRIMARY KEY (id);


--
-- TOC entry 2217 (class 1259 OID 96525)
-- Name: schema_version_ir_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX schema_version_ir_idx ON schema_version USING btree (installed_rank);


--
-- TOC entry 2220 (class 1259 OID 96526)
-- Name: schema_version_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX schema_version_s_idx ON schema_version USING btree (success);


--
-- TOC entry 2221 (class 1259 OID 96524)
-- Name: schema_version_vr_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX schema_version_vr_idx ON schema_version USING btree (version_rank);


SET search_path = auditing, pg_catalog;

--
-- TOC entry 2319 (class 2606 OID 96933)
-- Name: fk_aluno_deficiencia_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY aluno_deficiencia_audited
    ADD CONSTRAINT fk_aluno_deficiencia_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2320 (class 2606 OID 96938)
-- Name: fk_area_atendimento_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY area_atendimento_audited
    ADD CONSTRAINT fk_area_atendimento_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2321 (class 2606 OID 96943)
-- Name: fk_certidao_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY certidao_audited
    ADD CONSTRAINT fk_certidao_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2323 (class 2606 OID 96953)
-- Name: fk_endereco_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY endereco_audited
    ADD CONSTRAINT fk_endereco_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2324 (class 2606 OID 96958)
-- Name: fk_familiar_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY familiar_audited
    ADD CONSTRAINT fk_familiar_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2325 (class 2606 OID 96963)
-- Name: fk_formacao_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY formacao_audited
    ADD CONSTRAINT fk_formacao_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2326 (class 2606 OID 96968)
-- Name: fk_funcionario_curso_especificos_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY funcionario_curso_especificos_audited
    ADD CONSTRAINT fk_funcionario_curso_especificos_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2327 (class 2606 OID 96973)
-- Name: fk_funcionario_formacao_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY funcionario_formacao_audited
    ADD CONSTRAINT fk_funcionario_formacao_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2328 (class 2606 OID 96978)
-- Name: fk_funcionario_funcao_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY funcionario_funcao_audited
    ADD CONSTRAINT fk_funcionario_funcao_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2329 (class 2606 OID 96983)
-- Name: fk_irmao_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY irmao_audited
    ADD CONSTRAINT fk_irmao_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2330 (class 2606 OID 96988)
-- Name: fk_medida_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY medida_audited
    ADD CONSTRAINT fk_medida_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2331 (class 2606 OID 96993)
-- Name: fk_pessoa_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY pessoa_audited
    ADD CONSTRAINT fk_pessoa_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2332 (class 2606 OID 96998)
-- Name: fk_pessoa_irmao_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY pessoa_irmao_audited
    ADD CONSTRAINT fk_pessoa_irmao_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2333 (class 2606 OID 97003)
-- Name: fk_pessoa_voluntariado_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY pessoa_voluntariado_audited
    ADD CONSTRAINT fk_pessoa_voluntariado_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2334 (class 2606 OID 97008)
-- Name: fk_posicao_lista_espera_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY posicao_lista_espera_audited
    ADD CONSTRAINT fk_posicao_lista_espera_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2335 (class 2606 OID 97013)
-- Name: fk_telefone_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY telefone_audited
    ADD CONSTRAINT fk_telefone_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


--
-- TOC entry 2336 (class 2606 OID 97018)
-- Name: fk_termo_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY termo_audited
    ADD CONSTRAINT fk_termo_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);



-- TOC entry 2338 (class 2606 OID 97028)
-- Name: fk_voluntariado_audited_revision; Type: FK CONSTRAINT; Schema: auditing; Owner: postgres
--

ALTER TABLE ONLY voluntariado_audited
    ADD CONSTRAINT fk_voluntariado_audited_revision FOREIGN KEY (revision) REFERENCES revision(id);


SET search_path = public, pg_catalog;

--
-- TOC entry 2317 (class 2606 OID 96923)
-- Name: fk_aluno_deficiencia_aluno_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY aluno_deficiencia
    ADD CONSTRAINT fk_aluno_deficiencia_aluno_id FOREIGN KEY (aluno_id) REFERENCES pessoa(id);


--
-- TOC entry 2339 (class 2606 OID 97033)
-- Name: fk_familiar_aluno_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT fk_familiar_aluno_id FOREIGN KEY (aluno_id) REFERENCES pessoa(id);


--
-- TOC entry 2340 (class 2606 OID 97038)
-- Name: fk_familiar_responsavel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT fk_familiar_responsavel_id FOREIGN KEY (responsavel_id) REFERENCES pessoa(id);


--
-- TOC entry 2341 (class 2606 OID 97043)
-- Name: fk_formacao_pessoa_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY formacao
    ADD CONSTRAINT fk_formacao_pessoa_id FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);


--
-- TOC entry 2342 (class 2606 OID 97048)
-- Name: fk_funcionario_curso_especificos_funcionario_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario_curso_especificos
    ADD CONSTRAINT fk_funcionario_curso_especificos_funcionario_id FOREIGN KEY (funcionario_id) REFERENCES pessoa(id);


--
-- TOC entry 2343 (class 2606 OID 97053)
-- Name: fk_funcionario_funcao_funcionario_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionario_funcao
    ADD CONSTRAINT fk_funcionario_funcao_funcionario_id FOREIGN KEY (funcionario_id) REFERENCES pessoa(id);


--
-- TOC entry 2346 (class 2606 OID 97068)
-- Name: fk_pessoa_endereco_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT fk_pessoa_endereco_id FOREIGN KEY (endereco_id) REFERENCES endereco(id);


--
-- TOC entry 2348 (class 2606 OID 97078)
-- Name: fk_pessoa_irmao_irmao_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa_irmao
    ADD CONSTRAINT fk_pessoa_irmao_irmao_id FOREIGN KEY (irmao_id) REFERENCES irmao(id);


--
-- TOC entry 2349 (class 2606 OID 97083)
-- Name: fk_pessoa_irmao_pessoa_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa_irmao
    ADD CONSTRAINT fk_pessoa_irmao_pessoa_id FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);


--
-- TOC entry 2347 (class 2606 OID 97073)
-- Name: fk_pessoa_local_nascimento_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT fk_pessoa_local_nascimento_id FOREIGN KEY (local_nascimento_id) REFERENCES endereco(id);


--
-- TOC entry 2344 (class 2606 OID 97058)
-- Name: fk_pessoa_posicao_lista_espera_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT fk_pessoa_posicao_lista_espera_id FOREIGN KEY (posicao_lista_espera_id) REFERENCES posicao_lista_espera(id);


--
-- TOC entry 2351 (class 2606 OID 97093)
-- Name: fk_pessoa_voluntariado_pessoa_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa_voluntariado
    ADD CONSTRAINT fk_pessoa_voluntariado_pessoa_id FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);


--
-- TOC entry 2350 (class 2606 OID 97088)
-- Name: fk_pessoa_voluntariado_voluntariado_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa_voluntariado
    ADD CONSTRAINT fk_pessoa_voluntariado_voluntariado_id FOREIGN KEY (voluntariado_id) REFERENCES voluntariado(id);


--
-- TOC entry 2352 (class 2606 OID 97098)
-- Name: fk_posicao_lista_espera_aluno_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY posicao_lista_espera
    ADD CONSTRAINT fk_posicao_lista_espera_aluno_id FOREIGN KEY (aluno_id) REFERENCES pessoa(id);


--
-- TOC entry 2353 (class 2606 OID 97103)
-- Name: fk_telefone_pessoa_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY telefone
    ADD CONSTRAINT fk_telefone_pessoa_id FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);

--
-- TOC entry 2354 (class 2606 OID 97108)
-- Name: fk_voluntariado_termo_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY voluntariado
    ADD CONSTRAINT fk_voluntariado_termo_id FOREIGN KEY (termo_id) REFERENCES termo(id);


-- Completed on 2016-09-14 20:25:34

--
-- PostgreSQL database dump complete
--


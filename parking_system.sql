--
-- PostgreSQL database dump
--

-- Dumped from database version 12.11
-- Dumped by pg_dump version 12.11

-- Started on 2023-06-02 13:46:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2847 (class 1262 OID 32777)
-- Name: park; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE park WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';


ALTER DATABASE park OWNER TO postgres;

\connect park

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 32784)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id integer NOT NULL,
    user_id integer,
    category character varying
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 32800)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id integer NOT NULL,
    type_id character varying,
    user_id integer
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 32792)
-- Name: user_t; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_t (
    id integer NOT NULL,
    mail character varying,
    password character varying,
    first_name character varying,
    second_name character varying,
    last_name character varying,
    second_last_name character varying,
    phone character varying,
    active boolean,
    cc character varying
);


ALTER TABLE public.user_t OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 40973)
-- Name: employees_view; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.employees_view AS
 SELECT e.id,
    e.type_id,
    e.user_id,
    u.mail,
    u.cc,
    u.password,
    u.first_name,
    u.second_name,
    u.last_name,
    u.second_last_name,
    u.phone,
    u.active
   FROM (public.employee e
     JOIN public.user_t u ON ((u.id = e.user_id)));


ALTER TABLE public.employees_view OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32778)
-- Name: vehicle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vehicle (
    id integer,
    type_id integer,
    color_id integer,
    plate character varying
);


ALTER TABLE public.vehicle OWNER TO postgres;

--
-- TOC entry 2839 (class 0 OID 32784)
-- Dependencies: 203
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2841 (class 0 OID 32800)
-- Dependencies: 205
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employee (id, type_id, user_id) VALUES (1, '1', NULL);


--
-- TOC entry 2840 (class 0 OID 32792)
-- Dependencies: 204
-- Data for Name: user_t; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2838 (class 0 OID 32778)
-- Dependencies: 202
-- Data for Name: vehicle; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2710 (class 2606 OID 32807)
-- Name: employee Empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT "Empleado_pkey" PRIMARY KEY (id);


--
-- TOC entry 2706 (class 2606 OID 32791)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- TOC entry 2708 (class 2606 OID 32799)
-- Name: user_t user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_t
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


-- Completed on 2023-06-02 13:46:46

--
-- PostgreSQL database dump complete
--


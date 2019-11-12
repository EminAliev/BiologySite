--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

-- Started on 2019-11-12 22:54:57

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

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 32776)
-- Name: comments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comments (
    id integer NOT NULL,
    iduser integer,
    text text,
    date timestamp with time zone
);


ALTER TABLE public.comments OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 57371)
-- Name: comments_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comments_id_seq OWNER TO postgres;

--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 204
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comments_id_seq OWNED BY public.comments.id;


--
-- TOC entry 198 (class 1259 OID 32783)
-- Name: cookies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cookies (
    id integer,
    token character varying(128)
);


ALTER TABLE public.cookies OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 32789)
-- Name: questions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.questions (
    id integer NOT NULL,
    questiontext text,
    answera text,
    answerb text,
    answerc text,
    answerd text,
    correctanswer text,
    idtheme integer NOT NULL
);


ALTER TABLE public.questions OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 40973)
-- Name: resuts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resuts (
    id integer NOT NULL,
    correctanswer integer,
    wronganswer integer,
    countcorrect integer,
    idquestion integer,
    iduser integer
);


ALTER TABLE public.resuts OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 32771)
-- Name: sequence_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sequence_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_1 OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 40968)
-- Name: themes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.themes (
    id integer NOT NULL,
    nametheme text,
    texttheme text
);


ALTER TABLE public.themes OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 49159)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(64),
    password character varying(64),
    name character varying(64),
    fullname character varying(64),
    classnumber integer,
    email character varying(120),
    photo text
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 57347)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 203
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 2713 (class 2604 OID 57373)
-- Name: comments id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments ALTER COLUMN id SET DEFAULT nextval('public.comments_id_seq'::regclass);


--
-- TOC entry 2714 (class 2604 OID 57349)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2849 (class 0 OID 32776)
-- Dependencies: 197
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.comments (id, iduser, text, date) FROM stdin;
1	2	\N	2019-11-11 23:23:11.523+03
2	2	\N	2019-11-11 23:23:32.457+03
3	2	\N	2019-11-11 23:24:36.28+03
4	2	\N	2019-11-11 23:25:40.862+03
5	2	\N	2019-11-11 23:25:41.641+03
6	2	\N	2019-11-11 23:25:44.505+03
7	2	\N	2019-11-11 23:27:53.283+03
8	8	\N	2019-11-12 21:46:01.8+03
\.


--
-- TOC entry 2850 (class 0 OID 32783)
-- Dependencies: 198
-- Data for Name: cookies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cookies (id, token) FROM stdin;
2	[B@21b2fe58
2	[B@2ff03828
2	[B@65ab62d4
2	[B@635245d
2	[B@10e7313c
2	[B@6a0a50de
2	[B@78ed8be1
2	[B@6ed072d9
2	[B@7b7942ea
2	[B@13457f5c
2	[B@47503c45
2	[B@7c850d01
2	[B@3b5a4085
2	[B@3036a2d8
2	[B@56ef2101
2	[B@33a1ecd5
2	[B@731ef626
2	[B@4daaefce
2	[B@7a6c46d6
2	[B@3ddfc20
2	[B@6520c908
2	[B@4e0950bb
2	[B@7dd2cff
2	[B@1bc7c8f8
2	[B@28e26033
2	[B@7ddd0fc9
2	[B@1cc1d3cd
2	[B@45ead6a1
2	[B@ac76d8b
2	[B@70fe7bf4
2	[B@f420bc7
5	[B@5dd81a17
7	[B@228b06ea
\.


--
-- TOC entry 2851 (class 0 OID 32789)
-- Dependencies: 199
-- Data for Name: questions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.questions (id, questiontext, answera, answerb, answerc, answerd, correctanswer, idtheme) FROM stdin;
6	\N	\N	\N	\N	\N	\N	2
7	\N	\N	\N	\N	\N	\N	2
8	\N	\N	\N	\N	\N	\N	2
9	\N	\N	\N	\N	\N	\N	2
10	\N	\N	\N	\N	\N	\N	2
11	\N	\N	\N	\N	\N	\N	3
12	\N	\N	\N	\N	\N	\N	3
13	\N	\N	\N	\N	\N	\N	3
14	\N	\N	\N	\N	\N	\N	3
15	\N	\N	\N	\N	\N	\N	3
2	Сколько костей в организме взрослого человека?	150	256	250	120	120	1
4	В каком возрасте в костях преобладают органические вещества?\r\n	В молодом	В юности	В зрелом	В старом	В зрелом	1
3	К какому типу костей относятся фаланги пальцев?\r\n	Плоские	Смешанные	Трубчатые	Древовидные	Смешанные	1
1	Какого типа соединения костей не существует?	Подвижное	Недвижимое	Полуподвижное	Передвижное	Подвижное	1
5	Чем покрыта кость снаружи?	Хрящом	Надкостницей	Плотным веществом	-	Плотным веществом	1
\.


--
-- TOC entry 2853 (class 0 OID 40973)
-- Dependencies: 201
-- Data for Name: resuts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resuts (id, correctanswer, wronganswer, countcorrect, idquestion, iduser) FROM stdin;
\.


--
-- TOC entry 2852 (class 0 OID 40968)
-- Dependencies: 200
-- Data for Name: themes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.themes (id, nametheme, texttheme) FROM stdin;
1	Направления биологии	Название биология пришло из греческого языка. Греческое βίος, bios означает «жизнь»; λόγος, logos — «наука». Это наука о всех живых организмах, изучающая то, как они растут, питаются, двигаются, а также размножаются и развиваются.\r\nБиология тесно связана с физикой, химией, медициной, сельским хозяйством, лесоводством и другими отраслями науки, объединяя которые, получают такие отрасли науки, как биофизика, биохимия, биогеография, биоинженерия и даже космическая биология.
2	Растительная клетка	Клетки мякоти апельсина или грейпфрута можно видеть невооружённым глазом или при помощи лупы. Многие клетки настолько малы, что их можно увидеть только под микроскопом. То, что живые организмы состоят из клеток, учёные открыли ещё в 17 веке.\r\nИзвестны самостоятельно существующие организмы, состоящие из одной клетки, например, простейшими является часть зелёных водорослей.\r\n \r\nЯдро — самая важная составная часть клетки. Ядро отвечает за все процессы, происходящие в клетке. Ядро содержит наследственную информацию о том, какой будет новая клетка, которая образуется в результате процесса деления.\r\n \r\nЦитоплазма — бесцветное, вязкое вещество, наполняющее клетку. В цитоплазме находятся все остальные части клетки.\r\n  \r\nМембрана — тонкая полупроницаемая плёнка, которая окружает цитоплазму и отвечает за поступление в клетку и вывод из неё различных веществ. Она находится под клеточной стенкой.
3	Ткани растений	Основная ткань заполняет пространство между другими тканями. На поперечном сечении стебля растения видно, что основная ткань заполняет пространство между покровной и проводящей тканями.\r\nКлетки основной ткани живые и имеют тонкие клеточные стенки. В клетках основной ткани происходит создание питательных веществ, они участвуют в газообмене, осуществляют накопление веществ.\r\nМеханическая ткань придаёт растениям прочность. Она находится во всех органах растения. Много механической ткани расположено в стволе и прожилках листа. Механическая ткань удерживает ствол и сучья деревьев в вертикальном положении.\r\nУ клеток механической ткани толстые клеточные стенки, у некоторых клеток оболочки одревесневают. Часто клетки механической ткани удлинённые и имеют вид волокон. Клетки механической ткани могут погибнуть, но твёрдые, толстые клеточные стенки сохраняются.\r\n \r\nСкорлупа орехов состоит из механической ткани.
\.


--
-- TOC entry 2854 (class 0 OID 49159)
-- Dependencies: 202
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, username, password, name, fullname, classnumber, email, photo) FROM stdin;
1	sada	ec02c59dee6faaca3189bace969c22d3	asd	sad	2	sambufer200@gmail.com	\N
2	fantik	a901e2c8426a4e074fcb5b0b2e5181f5	Emin	Aliev	6	aliev.elchin@mail.ru	\N
3	fan1	a901e2c8426a4e074fcb5b0b2e5181f5	sdas	asda	1	aa@mail.ru	\N
4	eminaliev	a901e2c8426a4e074fcb5b0b2e5181f5	Emin	Aliev	11	aliev.emin@mail.ru	\N
5	eminaliev1	a901e2c8426a4e074fcb5b0b2e5181f5	Emin	Aliev	11	alievemin@mail.ru	\N
6	eminaliev2	a901e2c8426a4e074fcb5b0b2e5181f5	Emin	Aliev	11	aliev.emin@mail.ru	\N
7	ealiev	a901e2c8426a4e074fcb5b0b2e5181f5	Emin	Aliev	11	aliev.emin@mail.ru	\N
8	esaliev	a901e2c8426a4e074fcb5b0b2e5181f5	Emin	Aliev	11	alievemin@mail.ru	\N
\.


--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 204
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comments_id_seq', 8, true);


--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 196
-- Name: sequence_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence_1', 1, false);


--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 203
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 8, true);


--
-- TOC entry 2716 (class 2606 OID 32796)
-- Name: questions questions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions
    ADD CONSTRAINT questions_pkey PRIMARY KEY (id);


--
-- TOC entry 2721 (class 2606 OID 40977)
-- Name: resuts resuts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resuts
    ADD CONSTRAINT resuts_pkey PRIMARY KEY (id);


--
-- TOC entry 2719 (class 2606 OID 57362)
-- Name: themes themes_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.themes
    ADD CONSTRAINT themes_pk PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 49163)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2717 (class 1259 OID 57359)
-- Name: themes_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX themes_id_uindex ON public.themes USING btree (id);


--
-- TOC entry 2724 (class 2606 OID 57374)
-- Name: comments comments_users_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT comments_users_id_fk FOREIGN KEY (iduser) REFERENCES public.users(id);


--
-- TOC entry 2725 (class 2606 OID 57363)
-- Name: questions questions_themes_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.questions
    ADD CONSTRAINT questions_themes_id_fk FOREIGN KEY (idtheme) REFERENCES public.themes(id) ON UPDATE CASCADE ON DELETE CASCADE DEFERRABLE;


--
-- TOC entry 2726 (class 2606 OID 57379)
-- Name: resuts resuts_users_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resuts
    ADD CONSTRAINT resuts_users_id_fk FOREIGN KEY (iduser) REFERENCES public.users(id);


-- Completed on 2019-11-12 22:54:57

--
-- PostgreSQL database dump complete
--


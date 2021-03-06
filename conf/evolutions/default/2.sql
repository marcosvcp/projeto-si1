# --- Sample dataset

# --- !Ups

insert into cadeira values(128,'Matemática Discreta I',4,4,1,'novo');

insert into cadeira values(129,'Programação I',4,5,1,'novo');

insert into cadeira values(130,'Lab. de Programação I',4,5,1,'novo');

insert into cadeira values(131,'Int. à Computacação',4,3,1,'novo');

insert into cadeira values(132,'Optativa Geral I',4,3,1,'novo');

insert into cadeira values(133,'Matemática Discreta II',4,4,2,'novo');
insert into cadeira_requisito values(133,128);

insert into cadeira values(134,'Cálculo I',4,7,2,'novo');

insert into cadeira values(135,'Programação II',4,5,2,'novo');
insert into cadeira_requisito values(135,129);
insert into cadeira_requisito values(135,130);

insert into cadeira values(136,'Lab. de Programação II',4,5,2,'novo');
insert into cadeira_requisito values(136,129);
insert into cadeira_requisito values(136,130);

insert into cadeira values(137,'Optativa Geral II',4,3,2,'novo');

insert into cadeira values(138,'Algebra Linear',4,9,3,'novo');
insert into cadeira_requisito values(138,128);

insert into cadeira values(139,'Teoria dos Grafos',4,3,3,'novo');

insert into cadeira values(140,'Cálculo II',4,7,3,'novo');
insert into cadeira_requisito values(140,134);

insert into cadeira values(141,'Estrutura de Dados',4,7,3,'novo');
insert into cadeira_requisito values(141,135);
insert into cadeira_requisito values(141,136);

insert into cadeira values(142,'Lab. de Estrutura de Dados',4,7,3,'novo');
insert into cadeira_requisito values(142,135);
insert into cadeira_requisito values(142,136);

insert into cadeira values(143,'Lógica para Computação',4,7,3,'novo');
insert into cadeira_requisito values(143,128);

insert into cadeira values(144,'Introdução a Probabilidade',4,7,4,'novo');
insert into cadeira_requisito values(144,133);
insert into cadeira_requisito values(144,134);

insert into cadeira values(145,'Projeto de Software',4,6,4,'novo');

insert into cadeira values(146,'Paradigma de Linguagens de Programação',4,5,4,'novo');

insert into cadeira values(147,'Banco de Dados I',4,7,4,'novo');

insert into cadeira values(148,'Org. e Arquitetura de Computadores I',4,5,4,'novo');

insert into cadeira values(149,'Lab. de Org. e Arquitetura de Computadores',4,5,4,'novo');

insert into cadeira values(150,'Estatística Aplicada',4,5,5,'novo');
insert into cadeira_requisito values(150,144);

insert into cadeira values(151,'Análise de Sistemas',4,6,5,'novo');

insert into cadeira values(152,'Engenharia de Software',4,5,5,'novo');

insert into cadeira values(153,'Redes de Computadores',4,7,5,'novo');

insert into cadeira values(154,'Sistemas Operacionais',4,8,5,'novo');

insert into cadeira values(155,'Teoria da Computação',4,6,5,'novo');
insert into cadeira_requisito values(155,146);

insert into cadeira values(156,'Metodologia Científica',4,6,6,'novo');

insert into cadeira values(157,'Programação Concorrente',4,9,6,'novo');
insert into cadeira_requisito values(157,154);

insert into cadeira values(158,'Inteligência Artificial',4,7,6,'novo');
insert into cadeira_requisito values(158,155);

insert into cadeira values(159,'Optativa Específica I',4,3,6,'novo');

insert into cadeira values(160,'Optativa Específica II',4,4,6,'novo');

insert into cadeira values(161,'Análise e Técnicas de Algoritmos',4,8,7,'novo');

insert into cadeira values(162,'Compiladores',4,9,7,'novo');

insert into cadeira values(163,'Optativa Específica III',4,5,7,'novo');

insert into cadeira values(164,'Optativa Específica IV',4,5,7,'novo');

insert into cadeira values(165,'Optativa Geral III',4,3,7,'novo');

insert into cadeira values(166,'Projeto em Computação I',4,7,8,'novo');
insert into cadeira_requisito values(166,152);

insert into cadeira values(167,'Optativa Especifica V',4,5,8,'novo');

insert into cadeira values(168,'Optativa Especifica VI',4,5,8,'novo');

insert into cadeira values(169,'Optativa Geral IV',4,4,8,'novo');

insert into cadeira values(170,'Trabalho de Conclusão de Curso I',4,6,8,'novo');

insert into cadeira values(171,'Projeto em Computação II',4,6,9,'novo');
insert into cadeira_requisito values(171,166);

insert into cadeira values(172,'Optativa Especifica VI',4,5,9,'novo');

insert into cadeira values(173,'Optativa Especifica VII',4,5,9,'novo');

insert into cadeira values(174,'Optativa Especifica VIII',4,5,9,'novo');

insert into cadeira values(175,'Optativa Especifica IX',4,5,9,'novo');

insert into cadeira values(176,'Trabalho de Conclusão de Curso II',4,7,9,'novo');
insert into cadeira_requisito values(176,170);

insert into cadeira values(56,'Programação I',4,4,1,'comum');

insert into cadeira values(57,'Leitura e Prod. de Textos',4,2,1,'comum');

insert into cadeira values(58,'Cálculo I',4,7,1,'comum');

insert into cadeira values(59,'Álgebra Vetorial',4,3,1,'comum');

insert into cadeira values(60,'Int. a Computação',4,5,1,'comum');

insert into cadeira values(61,'Lab. de Programação I',4,4,1,'comum');

insert into cadeira values(62,'Programação II',4,5,2,'comum');
insert into cadeira_requisito values(62,56);
insert into cadeira_requisito values(62,60);
insert into cadeira_requisito values(62,61);

insert into cadeira values(63,'Lab. de Programação II',4,5,2,'comum');
insert into cadeira_requisito values(63,56);
insert into cadeira_requisito values(63,60);
insert into cadeira_requisito values(63,61);

insert into cadeira values(64,'Matemática Discreta',4,5,2,'comum');

insert into cadeira values(65,'Metodologia Científica',4,4,6,'comum');

insert into cadeira values(66,'Teoria dos Grafos',2,3,2,'comum');
insert into cadeira_requisito values(66,56);
insert into cadeira_requisito values(66,61);

insert into cadeira values(67,'Fund. de Física Clássica',4,8,2,'comum');
insert into cadeira_requisito values(67,58);
insert into cadeira_requisito values(67,59);

insert into cadeira values(68,'Cálculo II',4,7,2,'comum');
insert into cadeira_requisito values(68,58);

insert into cadeira values(69,'Estruturas de Dados',4,7,3,'comum');
insert into cadeira_requisito values(69,62);
insert into cadeira_requisito values(69,63);
insert into cadeira_requisito values(69,66);

insert into cadeira values(70,'Lab. de Estruturas de Dados',4,7,3,'comum');
insert into cadeira_requisito values(70,62);
insert into cadeira_requisito values(70,63);
insert into cadeira_requisito values(70,66);

insert into cadeira values(71,'Álgebra Linear',4,9,3,'comum');
insert into cadeira_requisito values(71,59);

insert into cadeira values(72,'Probabilidade e Estatística',4,9,3,'comum');
insert into cadeira_requisito values(72,68);

insert into cadeira values(73,'Teoria da Computação',4,6,3,'comum');
insert into cadeira_requisito values(73,60);
insert into cadeira_requisito values(73,64);
insert into cadeira_requisito values(73,66);

insert into cadeira values(74,'Fund. de Física Moderna',4,7,3,'comum');
insert into cadeira_requisito values(74,67);
insert into cadeira_requisito values(74,68);

insert into cadeira values(75,'Gerência da Informação',4,5,5,'comum');

insert into cadeira values(76,'Métodos Estatísticos',4,5,5,'comum');
insert into cadeira_requisito values(76,71);
insert into cadeira_requisito values(76,72);

insert into cadeira values(77,'Paradigmas de Linguagens de Programação',2,5,4,'comum');
insert into cadeira_requisito values(77,73);
insert into cadeira_requisito values(77,69);
insert into cadeira_requisito values(77,70);

insert into cadeira values(78,'Org. e Arquitetura de Computadores I',4,5,4,'comum');
insert into cadeira_requisito values(78,69);
insert into cadeira_requisito values(78,70);
insert into cadeira_requisito values(78,74);

insert into cadeira values(79,'Lab. de Org. e Arquitetura de Computadores',4,5,4,'comum');
insert into cadeira_requisito values(79,69);
insert into cadeira_requisito values(79,70);
insert into cadeira_requisito values(79,74);

insert into cadeira values(80,'Lógica Matemática',4,5,4,'comum');
insert into cadeira_requisito values(80,73);

insert into cadeira values(81,'Sistemas de Informação I',4,5,4,'comum');
insert into cadeira_requisito values(81,75);

insert into cadeira values(82,'Engenharia de Software I',4,5,5,'comum');
insert into cadeira_requisito values(82,72);
insert into cadeira_requisito values(82,62);
insert into cadeira_requisito values(82,63);

insert into cadeira values(83,'Análise e Tecnicas de Algoritmos',4,9,5,'comum');
insert into cadeira_requisito values(83,68);
insert into cadeira_requisito values(83,69);
insert into cadeira_requisito values(83,70);
insert into cadeira_requisito values(83,80);

insert into cadeira values(84,'Redes de Computadores',4,5,6,'comum');
insert into cadeira_requisito values(84,78);
insert into cadeira_requisito values(84,79);

insert into cadeira values(85,'Compiladores',4,9,8,'comum');
insert into cadeira_requisito values(85,77);
insert into cadeira_requisito values(85,78);
insert into cadeira_requisito values(85,79);

insert into cadeira values(86,'Banco de Dados I',4,5,5,'comum');
insert into cadeira_requisito values(86,81);

insert into cadeira values(87,'Sistemas de Informação II',4,5,6,'comum');
insert into cadeira_requisito values(87,81);

insert into cadeira values(88,'Laboratório de Engenharia de Software',4,5,6,'comum');
insert into cadeira_requisito values(88,82);

insert into cadeira values(89,'Informática e Sociedade',2,5,2,'comum');

insert into cadeira values(90,'Sistemas Operacionais',4,5,7,'comum');
insert into cadeira_requisito values(90,78);
insert into cadeira_requisito values(90,79);

insert into cadeira values(91,'Interconexão de Redes de Computadores',4,5,7,'comum');
insert into cadeira_requisito values(91,84);

insert into cadeira values(92,'Lab. de Interconexão de Redes de Computadores',4,5,7,'comum');
insert into cadeira_requisito values(92,84);

insert into cadeira values(93,'Inteligência Artificial I',4,5,8,'comum');
insert into cadeira_requisito values(93,76);
insert into cadeira_requisito values(93,77);
insert into cadeira_requisito values(93,83);

insert into cadeira values(94,'Banco de Dados II',4,5,7,'comum');
insert into cadeira_requisito values(94,86);
insert into cadeira_requisito values(94,87);

insert into cadeira values(95,'Direito e Cidadania',4,5,4,'comum');

insert into cadeira values(96,'Optativa 1',4,3,0,'comum');

insert into cadeira values(97,'Optativa 2',4,3,0,'comum');

insert into cadeira values(98,'Métodos e Software Numéricos',4,5,8,'comum');
insert into cadeira_requisito values(98,71);
insert into cadeira_requisito values(98,83);

insert into cadeira values(99,'Aval. de Desempenho de Sist. Discretos',4,5,8,'comum');
insert into cadeira_requisito values(99,72);

insert into cadeira values(100,'Projeto em Computação I',4,5,8,'comum');
insert into cadeira_requisito values(100,65);
insert into cadeira_requisito values(100,88);

insert into cadeira values(101,'Optativa 3',4,3,0,'comum');

insert into cadeira values(102,'Optativa 4',4,3,0,'comum');

insert into cadeira values(103,'Optativa 5',4,3,0,'comum');

insert into cadeira values(104,'Optativa 6',4,3,0,'comum');

insert into cadeira values(105,'Projeto em Computação II',6,5,9,'comum');
insert into cadeira_requisito values(105,100);

insert into cadeira values(106,'Optativa 7',4,3,0,'comum');

insert into cadeira values(107,'Optativa 8',4,3,0,'comum');

insert into cadeira values(108,'Optativa 9',4,3,0,'comum');

insert into cadeira values(109,'Optativa 10',4,3,0,'comum');

insert into cadeira values(110,'Optativa 11',4,3,0,'comum');

insert into cadeira values(111,'Administração',4,5,0,'comum');

insert into cadeira values(112,'Sociologia Industrial',3,5,0,'comum');

insert into cadeira values(113,'Economia',4,5,0,'comum');

insert into cadeira values(114,'Futsal',2,5,0,'comum');

insert into cadeira values(115,'Basquete',2,5,0,'comum');

insert into cadeira values(116,'Cálculo III',4,5,0,'comum');
insert into cadeira_requisito values(116,68);
insert into cadeira_requisito values(116,59);

insert into cadeira values(117,'Equações Diferenciais',4,5,0,'comum');
insert into cadeira_requisito values(117,71);

insert into cadeira values(118,'Inglês',4,5,0,'comum');

insert into cadeira values(119,'Expressão Gráfica',4,5,0,'comum');

insert into cadeira values(120,'Realidade Virtual',4,5,0,'comum');

insert into cadeira values(121,'Empreendedorismo I',4,5,0,'comum');

insert into cadeira values(122,'Administração Financeira',4,5,0,'comum');

insert into cadeira values(123,'Administração de Sistemas',4,5,0,'comum');

insert into cadeira values(124,'Análise de dados I',4,5,0,'comum');

insert into cadeira values(125,'Arquitetura de Software',4,5,0,'comum');
insert into cadeira_requisito values(125,81);
insert into cadeira_requisito values(125,82);

insert into cadeira values(126,'Desenvolvimento Dirigido a Modelos',4,5,0,'comum');
insert into cadeira_requisito values(126,82);

insert into cadeira values(127,'Desenvolvimento de Aplicações Corporativas Avançadas',4,5,0,'comum');
insert into cadeira_requisito values(127,86);

insert into cadeira values(1,'Programação I',4,4,1,'padrao');

insert into cadeira values(2,'Leitura e Prod. de Textos',4,2,1,'padrao');

insert into cadeira values(3,'Cálculo I',4,7,1,'padrao');

insert into cadeira values(4,'Algebra Vetorial',4,3,1,'padrao');

insert into cadeira values(5,'Int. à Computacação',4,5,1,'padrao');

insert into cadeira values(6,'Lab. de Programação I',4,4,1,'padrao');

insert into cadeira values(7,'Programação II',4,5,2,'padrao');
insert into cadeira_requisito values(7,1);
insert into cadeira_requisito values(7,5);
insert into cadeira_requisito values(7,6);

insert into cadeira values(8,'Lab. de Programação II',4,5,2,'padrao');
insert into cadeira_requisito values(8,1);
insert into cadeira_requisito values(8,5);
insert into cadeira_requisito values(8,6);

insert into cadeira values(9,'Matemática Discreta',4,5,2,'padrao');

insert into cadeira values(10,'Metodologia Científica',4,4,2,'padrao');

insert into cadeira values(11,'Teoria dos Grafos',2,3,2,'padrao');
insert into cadeira_requisito values(11,1);
insert into cadeira_requisito values(11,6);

insert into cadeira values(12,'Fund. de Física Clássica',4,8,2,'padrao');
insert into cadeira_requisito values(12,3);
insert into cadeira_requisito values(12,4);

insert into cadeira values(13,'Cálculo II',4,7,2,'padrao');
insert into cadeira_requisito values(13,3);

insert into cadeira values(14,'Estrutura de Dados',4,7,3,'padrao');
insert into cadeira_requisito values(14,7);
insert into cadeira_requisito values(14,8);
insert into cadeira_requisito values(14,11);

insert into cadeira values(15,'Lab. de Estrutura de Dados',4,7,3,'padrao');
insert into cadeira_requisito values(15,7);
insert into cadeira_requisito values(15,8);
insert into cadeira_requisito values(15,11);

insert into cadeira values(16,'Algebra Linear',4,9,3,'padrao');
insert into cadeira_requisito values(16,4);

insert into cadeira values(17,'Probabilidade e Est.',4,9,3,'padrao');
insert into cadeira_requisito values(17,13);

insert into cadeira values(18,'Teoria da Computação',4,6,3,'padrao');
insert into cadeira_requisito values(18,5);
insert into cadeira_requisito values(18,9);
insert into cadeira_requisito values(18,11);

insert into cadeira values(19,'Fund. de Física Moderna',4,7,3,'padrao');
insert into cadeira_requisito values(19,12);
insert into cadeira_requisito values(19,13);

insert into cadeira values(20,'Gerência da Informação',4,5,3,'padrao');

insert into cadeira values(21,'Métodos Estatísticos',4,5,4,'padrao');
insert into cadeira_requisito values(21,16);
insert into cadeira_requisito values(21,17);

insert into cadeira values(22,'Paradigmas de Linguagens de Programação',2,5,4,'padrao');
insert into cadeira_requisito values(22,18);
insert into cadeira_requisito values(22,14);
insert into cadeira_requisito values(22,15);

insert into cadeira values(23,'Org. e Arquitetura de Computadores I',4,5,4,'padrao');
insert into cadeira_requisito values(23,14);
insert into cadeira_requisito values(23,15);
insert into cadeira_requisito values(23,19);

insert into cadeira values(24,'Lab. de Org. e Arquitetura de Computadores',4,5,4,'padrao');
insert into cadeira_requisito values(24,14);
insert into cadeira_requisito values(24,15);
insert into cadeira_requisito values(24,19);

insert into cadeira values(25,'Lógica Matemática',4,5,4,'padrao');
insert into cadeira_requisito values(25,18);

insert into cadeira values(26,'Sistemas de Informação I',4,5,4,'padrao');
insert into cadeira_requisito values(26,20);

insert into cadeira values(27,'Engenharia de Software I',4,5,4,'padrao');
insert into cadeira_requisito values(27,17);
insert into cadeira_requisito values(27,7);
insert into cadeira_requisito values(27,8);

insert into cadeira values(28,'Análise e Técnicas de Algoritmos',4,9,5,'padrao');
insert into cadeira_requisito values(28,13);
insert into cadeira_requisito values(28,14);
insert into cadeira_requisito values(28,15);
insert into cadeira_requisito values(28,25);

insert into cadeira values(29,'Redes de Computadores',4,5,5,'padrao');
insert into cadeira_requisito values(29,23);
insert into cadeira_requisito values(29,24);

insert into cadeira values(30,'Compiladores',4,9,5,'padrao');
insert into cadeira_requisito values(30,22);
insert into cadeira_requisito values(30,23);
insert into cadeira_requisito values(30,24);

insert into cadeira values(31,'Banco de Dados I',4,5,5,'padrao');
insert into cadeira_requisito values(31,26);

insert into cadeira values(32,'Sistemas de Informação II',4,5,5,'padrao');
insert into cadeira_requisito values(32,26);

insert into cadeira values(33,'Laboratório de Engenharia de Software',4,5,5,'padrao');
insert into cadeira_requisito values(33,27);

insert into cadeira values(34,'Informática e Sociedade',2,5,5,'padrao');

insert into cadeira values(35,'Sistemas Operacionais',4,5,6,'padrao');
insert into cadeira_requisito values(35,23);
insert into cadeira_requisito values(35,24);

insert into cadeira values(36,'Interconexão de Redes de Computadores',4,5,6,'padrao');
insert into cadeira_requisito values(36,29);

insert into cadeira values(37,'Lab. de Interconexão de Redes de Computadores',4,5,6,'padrao');
insert into cadeira_requisito values(37,29);

insert into cadeira values(38,'Inteligência Artificial I',4,5,6,'padrao');
insert into cadeira_requisito values(38,21);
insert into cadeira_requisito values(38,22);
insert into cadeira_requisito values(38,28);

insert into cadeira values(39,'Banco de Dados II',4,5,6,'padrao');
insert into cadeira_requisito values(39,31);
insert into cadeira_requisito values(39,32);

insert into cadeira values(40,'Direito e Cidadania',4,5,6,'padrao');

insert into cadeira values(41,'Métodos e Software Númericos',4,5,7,'padrao');
insert into cadeira_requisito values(41,16);
insert into cadeira_requisito values(41,28);

insert into cadeira values(42,'Aval. de Desempenho de Sist. Discretos',4,5,7,'padrao');
insert into cadeira_requisito values(42,17);

insert into cadeira values(43,'Projeto em Computação I',4,5,7,'padrao');
insert into cadeira_requisito values(43,10);
insert into cadeira_requisito values(43,33);

insert into cadeira values(44,'Projeto em Computação II',6,5,8,'padrao');
insert into cadeira_requisito values(44,43);

insert into cadeira values(45,'Optativa 1',4,3,6,'padrao');

insert into cadeira values(46,'Optativa 2',4,3,6,'padrao');

insert into cadeira values(47,'Optativa 3',4,3,7,'padrao');

insert into cadeira values(48,'Optativa 4',4,3,7,'padrao');

insert into cadeira values(49,'Optativa 5',4,3,7,'padrao');

insert into cadeira values(50,'Optativa 6',4,3,7,'padrao');

insert into cadeira values(51,'Optativa 7',4,3,8,'padrao');

insert into cadeira values(52,'Optativa 8',4,3,8,'padrao');

insert into cadeira values(53,'Optativa 9',4,3,8,'padrao');

insert into cadeira values(54,'Optativa 10',4,3,8,'padrao');

insert into cadeira values(55,'Optativa 11',2,3,8,'padrao');




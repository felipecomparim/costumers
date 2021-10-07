DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    nome     VARCHAR(250) NOT NULL,
    cpf      VARCHAR(250) NOT NULL,
    telefone VARCHAR(70)  NOT NULL,
    endereco VARCHAR(350) NOT NULL,
    cidade VARCHAR(20) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    cep      VARCHAR(9) NOT NULL,
    data_nascimento     DATE
);
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('1', '3', '18', '13, 14', '12', '16', '17','5')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('nome', 'cpf', 'telefone_fixo', 'endereco, numero', 'cep', 'cidade', 'estado','data_nasc')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Rafael Luiz Alves', '882.393.027-85', '(67) 3621-5021', 'Rua Jamil Nachif, 834', '79006-510', 'Campo Grande', 'MS','1999-05-02')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Mirella Stefany Gabrielly Assunção', '698.979.768-17', '(47) 2578-5733', 'Rua Aldo Locatelli, 627', '88302-275', 'Itajaí', 'SC','1975-06-06')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Hadassa Jennifer Teixeira', '923.428.370-89', '(95) 3791-0752', 'Rua Pau-rainha, 938', '69307-160', 'Boa Vista', 'RR','1956-08-26')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Daniel Kaique Victor Farias', '555.370.548-76', '(82) 3941-3480', 'Rua Antônio Honorato, 309', '57071-750', 'Maceió', 'AL','1968-06-02')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Cláudio Gustavo Santos', '884.354.547-70', '(61) 2851-3663', 'SHS Quadra 2 Bloco B Térreo, 123', '70312-971', 'Brasília', 'DF','1994-12-03')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Raimundo Sérgio Thomas Drumond', '138.502.142-06', '(92) 3674-3830', 'Rua Dona Laurina Marinho, 589', '69098-335', 'Manaus', 'AM','1971-09-10')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Geraldo Diego Vicente Aragão', '756.554.434-57', '(83) 3689-8198', 'Rua Maria Minervina de Figueiredo, 797', '58410-118', 'Campina Grande', 'PB','2003-11-02')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Vera Josefa Baptista', '559.613.322-17', '(85) 2866-2757', 'Rua 8, 272', '60863-135', 'Fortaleza', 'CE','1969-03-04')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Igor Daniel Nunes', '001.019.304-96', '(73) 3910-8334', 'Caminho 40, 668', '45656-560', 'Ilhéus', 'BA','1999-03-04')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Francisco Alexandre Bernardes', '056.831.796-37', '(71) 2649-5227', 'Avenida Deus me Deu, 254', '40327-025', 'Salvador', 'BA','2000-04-26')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Breno Danilo Otávio Castro', '546.289.188-13', '(71) 3639-2634', 'Avenida Paraguaçu, 464', '40240-150', 'Salvador', 'BA','1946-06-27')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Elisa Isabelly Giovanna Rezende', '190.004.836-11', '(68) 3550-1541', 'Rua Antonio Pinheiro de Moraes, 347', '69908-856', 'Rio Branco', 'AC','1993-10-18')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Pietra Elza Galvão', '878.893.695-30', '(67) 2537-1054', 'Corredor Público J, 355', '79833-660', 'Dourados', 'MS','1968-12-14')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Raul Jorge Caio Nascimento', '908.409.962-17', '(62) 2559-8717', 'Rua Luiza M. Coimbra Bueno, 168', '74491-471', 'Goiânia', 'GO','1966-04-25')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Gustavo Emanuel Benjamin Lima', '068.592.136-04', '(19) 2862-4544', 'Rua Lúcio Alves, 789', '13473-690', 'Americana', 'SP','1945-04-21')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Bruno Filipe Pedro Henrique Pinto', '390.808.252-80', '(85) 2924-2076', 'Vila Serpa, 201', '60872-572', 'Fortaleza', 'CE','1960-05-05')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Ricardo Isaac Drumond', '168.374.371-78', '(68) 3959-2747', 'Rua Cerejeira, 267', '69915-868', 'Rio Branco', 'AC','1953-10-10')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Geraldo Tiago Caio Duarte', '139.676.362-75', '(86) 2701-4494', 'Quadra K3, 348', '64216-802', 'Parnaíba', 'PI','1970-04-09')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Oliver André da Conceição', '261.236.843-45', '(96) 2586-3181', 'Rua Odilardo Silva, 610', '68900-151', 'Macapá', 'AP','1964-02-21')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Rosa Ana Mendes', '286.617.428-38', '(65) 3752-6232', 'Rua Hamilton Benevides, 253', '78120-817', 'Várzea Grande', 'MT','1968-04-13')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Sueli Bruna Costa', '426.282.556-69', '(67) 2819-4527', 'Rua Marajoara, 181', '79073-120', 'Campo Grande', 'MS','1941-02-14')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Luan Enrico Gonçalves', '341.168.008-30', '(79) 2548-2982', 'Rua Beira-Mar, 893', '49090-393', 'Aracaju', 'SE','1985-03-12')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Enrico Hugo Sales', '883.457.289-01', '(34) 2724-7760', 'Rua Um, 458', '38071-710', 'Uberaba', 'MG','1969-07-23')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Benjamin Caio Castro', '186.809.877-00', '(68) 3675-5504', 'Rua Rio Moa, 518', '69915-786', 'Rio Branco', 'AC','1987-05-23')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Natália Maya Carvalho', '876.259.042-10', '(81) 3896-7792', 'Rua Marechal Costa e Silva, 343', '55014-670', 'Caruaru', 'PE','1965-10-22')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Stefany Pietra Tânia da Cunha', '727.961.648-88', '(96) 2895-9736', 'Avenida Coelho Neto, 992', '68925-183', 'Santana', 'AP','2003-08-11')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Tiago Bento Santos', '125.663.780-70', '(48) 3803-1614', 'Rua Pedro Botega, 546', '88702-575', 'Tubarão', 'SC','1966-04-11')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Paulo Emanuel Leonardo Pinto', '980.474.997-18', '(95) 2531-2747', 'Rua Santa Lúcia, 565', '69312-590', 'Boa Vista', 'RR','1952-05-26')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Brenda Rosa Dias', '946.226.461-96', '(96) 2774-0686', 'Avenida Jardin América, 915', '68906-463', 'Macapá', 'AP','1985-07-21')
insert into cliente (nome,cpf,telefone,endereco,cep,cidade,estado,data_nascimento) values  ('Erick Caleb Francisco Lopes', '833.374.826-00', '(62) 2755-7314', 'Rua C 1, 517', '74470-850', 'Goiânia', 'GO','1992-09-11')

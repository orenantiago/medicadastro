# MediCadastro
O banco de dados da aplicação foi criado com as seguintes configurações:  
  * Banco de dados: medicadastro
  * user: root
  * password: 123
  * table paciente:  
    ```
    create table paciente(
    id bigint not null auto_increment,
    nome varchar(255),
    idade int,
    sexo varchar(9),
    );
  * table exame:  
      ```
      create table exame(
      id bigint not null auto_increment,
      nome varchar(255),
      especialidade varchar(255),
      descricao varchar(255),
      data date,
      idPaciente bigint
      );

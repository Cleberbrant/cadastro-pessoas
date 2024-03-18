# Desafio técnico Sinerji - Cleber Brant

## Decisões técnicas e Arquitetura do desafio

A ideia foi ser o mais fiel possível diante das instruções do desafio(Arquitetura e Modelo de Dados), utilizando as tecnologias citadas, porém com versões mais atuais,
então criei uma aplicação Web para gerenciar os dados de uma pessoa.

### Funções
As funções do sistema são: 
- Registrar uma nova Pessoa(onde vinculamos um Endereco nela)
- Editar uma pessoa
- Buscar uma pessoa por nome(Caso busque sem nenhum nome, irá trazer todas pessoas cadastradas)
- Remover uma pessoa
- Listar pessoas cadastradas

### Arquitetura
Escolhi utilizar arquitetura MVC por facilitar a organização do projeto nas pastas: Controller, Entities, Repository, Service e Util.
Separando assim, a responsabilidade de cada um dos arquivos.

## Tecnologias usadas:

### Aplicação
- jdk-8u202 (Java 8)
- JSF 2.2.14
- JPA
- Hibernate 5.2.4.Final
- PrimeFaces 12
- Maven 4

### Servidor da Aplicação
- Tomcat 9

### Banco de dados da Aplicação
- PostgreSQL 16.2
- PostgreSQL driver JDBC 42.2.20

### Testes da Aplicação
- JUnit 4.13.2
- Mockito 4.11.0

### Ferramentas
- Eclipse IDE for Enterprise Java and Web Developers(Recomendo fortemente por facilitar os processos para execução do projeto/testes)
- pgAdmin4

## Execução do Sistema

Abaixo teremos o passo a passo para execução da aplicação.

### JDK8
Inicialmente temos que baixar e instalar o JDK8 disponivel em https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html, após isso, adicionar o caminho do JDK8/bin na JAVA_HOME e o caminho da JDK na PATH das variaveis de ambiente do seu sistema.

### IDE - Eclipse
Após configurar o JDK no seu sistema, eu indico baixar e instalar o Eclipse IDE for Enterprise Java and Web Developers, versão mais recente disponivel em https://www.eclipse.org/downloads/packages/ para utilizarmos como IDE para execução do projeto.

### PostgreSQL
Será necessário baixar e instalar o PostgreSQL 16.2, onde ele virá com o pgAdming4, você terá que criar a base de dados que por padrão é="cadastropessoas", a senha que por padrão é="root", e caso seja necessário mudar alguma configuração de banco, vá em, main/resources/META-INF/persistence, clique em Source no menu inferior para aparecer o código, dentro dele aparecerão as propertys do banco, como user, porta, nome da base de dados e etc. Deixei o generation.database.action setado como drop-and-create por padrão, onde sempre que iniciar o servidor, ele irá dropar e criar novamente.

### Tomcat 9
Após instalar o Eclipse e configurar o banco de dados, precisamos baixar o Tomcat 9 para execução do nosso projeto WEB, download disponivel em https://tomcat.apache.org/download-90.cgi, assim que for baixado, é necessário extrair o .rar do tomcat, voltamos ao eclipse, na tela inicial irá aparecer Servers, com botão direito do mouse, clique em new e depois em Server, irá aparecer uma tela de New Server, no campo de pesquisa, pesquise por Tomcat e selecione o Tomcat v9.0 Server, clique em next, ele irá pedir para inserir o diretorio de instalação do Tomcat e o JRE pode deixar Workbench default JRE, apos isso, next, em available irá aparecer o projeto disponivel, adicione ele em configured e clique em finish. Após isso, de um duplo clique no servidor criado, em Server Locations selecione Use Tomcat installation e assim nosso Tomcat está configurado.

### Maven Install
Após todas as configurações, clique com botão direito em cima da pasta do projeto, vá em run as, e depois em Maven Install, ele irá rodar a nossa pom.xml baixando as dependencias necessárias.

### Rodando o projeto
Para rodar o projeto, basta selecionar o Tomcat v9.0 Server at localhost e inicia-lo, após isso, entre no navegador de preferencia, e acesse http://localhost:8080/cadastro-pessoas/

### Rodando testes unitários
Para rodar os testes unitários, clique com botão direito em cima da pasta do projeto, vá em run as, e depois em JUnit Test, assim ele rodará os testes unitários.

## Notas adicionais
Decidi fazer a modelagem de dados do jeito que estava no arquivo, onde temos 2 entidades(Pessoa, Endereco), e existe uma relação de muitos pra um, onde vinculei um endereço na entidade pessoa, passei por muitos problemas até conseguir efetivar isso, mas no final deu certo, foi um desafio onde passei bastante tempo trabalhando, mas como o nome já diz, é um desafio mesmo, aprendi bastante com os empecilhos e quaisquer dúvidas, me chamem no WhatsApp!

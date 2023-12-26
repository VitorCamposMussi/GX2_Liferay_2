# Tutorial de instalação do portal Liferay bundle

## Instalando o JDK

### Primeiro vamos baixar a versão 11 do jdk no link:

Oracle 
[Java Archive Downloads - Java SE 11 | Oracle Brasil](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)

Zulu
[Azul jdk 11 Download](https://www.azul.com/downloads/?package=jdk#zulu)

<aside>
💡 Role a página para achar a versão jdk 11 LTS. Lembrando que tem a opção para windows/ linux e mac.

</aside>

<br>

### Adicionando o JDK baixado no caminho padrão:

- Depois de fazer o download do jdk 11, vamos descompactar a pasta e renomear para “jdk_11_zulu” (Podemos por qualquer nome, mas eu resolvi adotar esse para o tutorial fluir).
- Agora vamos adicionar adicionar a pasta “jdk_11_zulu” no caminho: C:\Program Files\Java. O caminho completo fica: C:\Program Files\Java\jdk_11_Zulu.

### Adicionando jdk nas variáveis de sistema:

- Vamos na lupa do windows e escrever: edit the system enviroment, caso o windows esteja em ingles, ou: variáveis de ambiente, caso o windows esteja em português. 

- Vamos abir o icone
<img src="/Conteudo/1 - Trilha Inicial/Arquivos/img/01.jpg" alt="" width="350">

- Após clicar, seremos levados para:
<img src="/Conteudo/1 - Trilha Inicial/Arquivos/img/02.jpg" alt="" width="350">

- Aqui vamos clicar em “Environment variables” no fim da página
<img src="/Conteudo/1 - Trilha Inicial/Arquivos/img/03.jpg" alt="" width="350">

- Em “system vaiables” vamos clicar em new
<img src="/Conteudo/1 - Trilha Inicial/Arquivos/img/04.jpg" alt="" width="400">

- Agora vamos criar o java home (com letras em maiúsculo) e inserir o caminho do nosso jdk na parte de baixo “variable value”. Neste caso fica:
<img src="/Conteudo/1 - Trilha Inicial/Arquivos/img/05.jpg" alt="" width="500">

- Depois de criar o java home, vamos adicionar o bin na parte de path do sistema. O path fica no menu de “environment variables” na parte de baixo, conforme figura:
<img src="/Conteudo/1 - Trilha Inicial/Arquivos/img/06.jpg" alt="" width="500">

- Vamos dar 2 clicks no path, em seguida veremos um menu com algumas variáveis de ambiente. Conforme figura:
<img src="/Conteudo/1 - Trilha Inicial/Arquivos/img/07.jpg" alt="" width="500">

- Agora vamos clicar em “new” e adicionar o caminho do bin do nosso jdk. O caminho completo do bin fica: C:\Program Files\Java\jdk_11_zulu. Confirme se o seu esta igual ao da figura abaixo:
<img src="/Conteudo/1 - Trilha Inicial/Arquivos/img/08.jpg" alt="" width="500">

- Agora é só clicar nos “ok”s e fechar tudo. 
  
<br>

### Confirmando instalação do JDK
Se vc fez tudo certo até aqui, irá confirmar se o jdk esta nas variáveis do sistema abrindo o terminal ou powershell e digitando o comando:

```powershell
java --version

# ou

java -v
```

<aside>
💡 Após inserir o comando e dar enter, você irá visualizar a versão do java da sua máquina. No caso da JDK 11 deve mostrar java 1.8, ou algo assim.

</aside>

<br>

## Abrindo o liferay
- Vamos fazer o download do liferay no link: [Liferay bundle dowload](https://github.com/liferay/liferay-portal/releases/download/7.4.3.93-ga93/liferay-ce-portal-tomcat-7.4.3.93-ga93-20230907122939567.tar.gz)  

- Depois de baixar, vamos descompactar o arquivo. Neste caso, vou descompactar já na pasta “downloads” mas vc pode por na pasta que quiser.

- Agora vamos entra no caminho: Downloads\liferay-ce-portal-7.4.3.93-ga93\tomcat-9.0.75\bin 

- Em seguida é só abrir o arquivo “startup” (versão batch) se for windows ou startup.sh se for linux ou mac.

<aside>
💡 Depois de abrir o Liferay, um terminal irá aparecer e startar o servidor. Lembrando, deixe o terminal aberto enquanto estiver usando o Liferay.

</aside>

### Confirmando pra ver se deu tudo certo:

Depois que o serviço do liferay iniciar, você pode ir no navegador e digitar: 
```
localhost:8080
```
e verá a carinha dele.

<br>

### Passo complementar (Criar usuário administrador do liferay)

Entrar em: [http://localhost:8080](http://localhost:8080/)

Usuário padrão geralmente é: test@liferay.com
Senha padrão geralmente fica: 12345


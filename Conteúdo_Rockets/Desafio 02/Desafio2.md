# Desafio 2 Rockets GX2

### Requisitos:

[Documento do desafio](/Conteúdo_Rockets/Desafio%2002/Arq/Desafio%20Rockets%20II_%20Intranet.pdf)

<details>
  <summary>Instruções do desafio</summary>
  
# Desafios Técnicos Rocket II <br>

### Instruções gerais:

- O desafio será aberto ao final da call do dia 20/08/2024 e a entrega será no dia 16/09/2024, até 23h59. Durante esse período, dúvidas pontuais podem ser tiradas via Chat da Google no grupo com os padrinhos.

- O desafio consiste em 1) realizar os exercícios, registrar no Github e enviar o link para avaliação; 2) Apresentar o que foi feito para o Comitê de Padrinhos (Data a Marcar).

- A apresentação deve abranger todos os tópicos requeridos.

- Importante: O cumprimento do prazo (16/09/2024) faz parte da avaliação e eventuais intercorrências devem ser avisadas com antecedência.


### Instruções do Desafio:

Envie o link do git contendo os tópicos solicitados e apresente em reunião tópicos mencionados abaixo, demonstrando o que foi feito, com duração máxima de 15 minutos. Certifique-se de demonstrar e explicar os conceitos de forma clara e concisa.

A avaliação será baseada na qualidade dos códigos, na clareza da explicação, na precisão das informações e na demonstração prática dos conceitos. Certifique-se de ter internet, câmera e luz adequadas na hora da apresentação.

Esta avaliação testará seu conhecimento prático do Liferay, qualidade de código e sua capacidade de comunicar eficazmente os conceitos aos outros. Boa sorte! 

<br>

#### Desafio Geral:
Desafio: Implementar um de Processo de Aprovação de Reembolso no
Liferay

Objetivo: Desenvolver um processo de aprovação de reembolso dentro da
plataforma Liferay que permite a um funcionário submeter uma
solicitação de reembolso, incluindo um comprovante e informações
específicas. O processo deve incluir etapas de validação e aprovação por
parte de um gerente e um diretor, antes do envio para a área financeira
para o processamento final e pagamento do reembolso.

Requisitos Detalhados do Processo
Submissão da Solicitação pelo Funcionário:

##### Campos Obrigatórios:
- Valor: Campo obrigatório.
- Data: Campo obrigatório.
- Fornecedor: Campo obrigatório se o valor for igual ou superior a R$
100,00.
- Descrição: Campo obrigatório se o valor for igual ou superior a R$
100,00.
- Comprovante: Anexar comprovante de despesa. Campo obrigatório.
Revisão pelo Gerente.

<br>
O gerente pode aprovar e encaminhar a solicitação para o diretor ou
rejeitar a solicitação.
Em caso de rejeição, deve ser possível fornecer um feedback sobre os
motivos da rejeição ao funcionário.

O diretor pode aprovar a solicitação para envio ao departamento
financeiro ou rejeitá-la.
Em caso de rejeição, deve ser possível fornecer um feedback sobre os
motivos da rejeição ao funcionário.

Após a aprovação pelo diretor, a solicitação é enviada para a área
financeira.
O departamento financeiro processa o pagamento e envia um email ao
funcionário informando que o reembolso foi pago.
O email deve especificar o valor pago.

<br>
<br>

#### Desafios Backend (escolher 2 de 3):
##### Desafio: Criar um Portlet Básico

<b> Objetivo:</b>
- Desenvolver um portlet simples que exiba a data e hora atual de
brasilia, dando a opção para o usuário informar o UTC.

<br>

##### Desafio: Criação de Serviços Locais Simples
<br> Objetivo:</b>
- Criar um serviço local que permite registrar e listar tarefas.


##### Desafio: Desafio: Criar uma REST API no Liferay para Consultar Informações de Clima

<b> Objetivo:</b>
- Desenvolver uma REST API no Liferay que consulta uma API externa de
previsão do tempo e retorna esses dados ao frontend de forma
formatada e segura.
</details>

<br>

### Resolução:

[Documento do desafio](/Conteúdo_Rockets/Desafio%2001/Arq/Backend%20_%20Desafios%20Técnicos%20Rocket%20I%20.pdf) <br>
[Desafio 2.1 - Integrar o Liferay com uma API de cotação do Dólar](/Conteúdo_Rockets/Desafio%2002/01/) <br>
[Desafio 2.2 - Desenvolver um CRUD de tarefas pendentes utilizando o Service Builder no Liferay](/Conteúdo_Rockets/Desafio%2002/02/) <br>
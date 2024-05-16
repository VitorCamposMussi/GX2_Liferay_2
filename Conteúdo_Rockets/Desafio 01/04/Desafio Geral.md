# Desafio geral
<img src="/Conteúdo_Rockets/Desafio 01/04/Arq/Forms.jpg" alt="Forms de reembolso" width="1000">

<br>

## Passo a passo da resolução:

### Versões:
- [Liferay dxp 7.4 u80](https://www.liferay.com/pt/free-trial)
- [JDK 1.8 (Java 8 LTS)](https://www.azul.com/core-post-download/?endpoint=zulu&uuid=54ab6927-1f22-4612-beab-49617246ffd3)
- [Liferay workspace installer](https://github.com/liferay/liferay-ide/releases/download/3.9.7-ga8/LiferayWorkspace-202207131011-windows-installer.exe)

<details>
  <summary>Roadmap de fluxo </summary>
  <img src="/Conteúdo_Rockets/Desafio 01/04/Arq/Workflow.jpg" alt="Diagrama de fluxo" width="1000">
</details>

<br> 


### 1 - Criação do forms para reembolso:
- Menu site → Content and data → Forms
- Nome do forms: Formulário de reembolso

#### Campos:

- Numeric (Campo obrigatório)→ ValorCompra
- Simple date (Campo obrigatório)→ DataCompra
- Text (Se torna obrigatório a partir de compras de R$ 100.00 ou mais)→ Fornecedor
- Text (Se torna obrigatório a partir de compras de R$ 100.00 ou mais) → Descricao
- Upload (Campo obrigatório) → EnviarComprovante

##### Rules (Para o form criado)

```text
If Field ValorCompra is greater than or equal to Value 100.00

Require
Fornecedor, AND

Require
Descricao
```
<br>

### 2 - Criação do workflow para adequar no forms:

- Menu global → Process builder → Botão “plus” para criar novo workflow

- Nome do workflow: Workflow reembolso

##### Regras do workflow:
- <b> Start → Pedido de Reembolso </b>
Action → Nome: Pedido de Reembolso Criado/ Type: update status/ Status: Pending/ Execution Type: on entry

<br>

- <b> Taks → Gerente </b>
  - Action1 → Nome: Aprovar Proposta/ Type: update status/ Status: Pending/ Execution Type: on exit/ Notification Type: User (Role - Asset Creator)
  - Action2 → Nome: Reprovar Proposta/ Type: update status/ Status: Denied/ Execution Type: on exit/ Notification Type: User (Role - Asset Creator)

<br>

- <b> Task → Diretor </b>
  - Action1 → Nome: Aprovar Proposta/ Type: update status/ Status: Pending/ Execution Type: on exit/ Notification Type: User (Role - Asset Creator)
  - Action2 → Nome: Reprovar Proposta/ Type: update status/ Status: Denied/ Execution Type: on exit/ Notification Type: User (Role - Asset Creator)

<br>

- <b> Task → Financeiro </b>
  - Action → Nome: Aprovar Proposta/ Type: update status/ Status: Approved/ Execution Type: on exit/ Notification Type: User (Role - Asset Creator)
  
<br>

- <b> End1 (Pedido de Reembolso Aprovado) → PedidoAprovado </b>
  - Action → Nome: Pedido Aprovado/ Type: update status/ Status: Approved/ Execution Type: on entry/ Notification Type: User (Role - Asset Creator)

<br>

- <b> End2 (Pedido de Reembolso Reprovado) → PedidoReprovado </b>
  - Action → Nome: Pedido Reprovado/ Type: update status/ Status: Denied/ Execution Type: on entry/ Notification Type: User (Role - Asset Creator)
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <meta charset="UTF-8">
    <style>
        /* Estilos Gerais */
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f0f0f0; /* Fundo neutro da página */
            padding: 20px;
        }

        /* Container principal para manter os boxes organizados */
        .portlet-container {
            display: flex;
            flex-direction: column;
            align-items: center; /* Centralizar os boxes horizontalmente */
            gap: 20px; /* Espaçamento entre os boxes */
            max-width: 800px; /* Largura máxima */
            margin: 0 auto; /* Centralizar o container na página */
        }

        /* Box do cabeçalho */
        .portlet-header-box {
            width: 100%;
            background-color: #4CAF50; /* Fundo verde */
            color: white;
            padding: 15px;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            border-radius: 8px; /* Bordas arredondadas */
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Sombra leve */
        }

        /* Box do conteúdo */
        .portlet-content-box {
            width: 100%;
            border: 1px solid #ddd; /* Borda ao redor da caixa de conteúdo */
            padding: 20px;
            border-radius: 8px; /* Bordas arredondadas */
            background-color: #e0e0e0; /* Fundo cinza claro */
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Sombra leve */
        }

        /* Box do rodapé */
        .portlet-footer-box {
            width: 100%;
            background-color: #f8f8f8; /* Fundo claro do rodapé */
            padding: 15px;
            text-align: center;
            font-size: 14px;
            color: #777; /* Texto cinza suave */
            border-radius: 8px; /* Bordas arredondadas */
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); /* Sombra leve */
        }

        /* Estilo para a cotação */
        .dollar-rate {
            font-size: 20px; /* Tamanho maior para a cotação */
            color: #333; /* Cor escura para destaque */
            font-weight: bold; /* Negrito para destacar o valor */
            margin-top: 10px;
        }

        /* Estilo para mensagens de erro */
        .error-message {
            color: red; /* Mensagem de erro em vermelho */
            font-size: 16px;
            font-weight: bold;
            margin-top: 20px;
            text-align: center;
        }

        /* Estilo para a legenda */
        .caption {
            font-weight: bold;
            font-size: 22px;
            margin-bottom: 10px;
            color: #333; /* Legenda em uma cor mais forte */
            text-align: center;
        }

        /* Estilo para o botão (caso seja necessário) */
        .action-button {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
            text-align: center;
            transition: background-color 0.3s ease;
        }

        .action-button:hover {
            background-color: #45a049; /* Cor mais escura ao passar o mouse */
        }
    </style>
</head>

<!-- Container principal do portlet -->
<div class="portlet-container">

    <!-- Box do Cabeçalho -->
    <div class="portlet-header-box">
        <liferay-ui:message key="desafioportletdolar.caption" />
    </div>

    <!-- Box do Conteúdo -->
    <div class="portlet-content-box">
        <div class="caption">
            Cotação Atual do Dólar (USD para BRL)
        </div>

        <!-- Se a cotação estiver disponível, exibe o valor -->
        <div class="dollar-rate">
            <%
                // Pegando o valor da cotação passada pelo portlet como atributo da request
                Double dollarRate = (Double) request.getAttribute("dollarRate");

                if (dollarRate == null) {
            %>
                <!-- Exibe uma mensagem de erro se não for possível recuperar a cotação -->
                <p class="error-message">Não foi possível recuperar a cotação no momento.</p>
            <%
                } else {
            %>
                <!-- Exibe a cotação recuperada -->
                <p>Cotação Atual: <%= dollarRate %> BRL</p>
            <%
                }
            %>
        </div>

        <!-- Botão de ação (opcional) -->
        <div class="action">
            <a href="#" class="action-button">Atualizar Cotação</a>
        </div>
    </div>

    <!-- Box do Rodapé -->
    <div class="portlet-footer-box">
        Fonte dos dados: CurrencyLayer API
    </div>

</div>

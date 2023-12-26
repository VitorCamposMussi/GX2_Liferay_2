# Desafio 2 Gx2

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/home.jpg" alt="" width="700">

##Instruções do desafio

<details>
<summary>Instruções</summary>
2º Desafio Pré-Rocket Talents | Trilha Liferay Back-End 2023

Instruções gerais:
    • O desafio será aberto ao final da Live do dia 11/12/23 e a entrega ficará disponível até o dia 22/12/23, às 23h59. Durante esse período, dúvidas pontuais podem ser tiradas via Discord.
    • O desafio consiste em 1 - realizar os exercícios, registrar no Github e enviar o link para avaliação; 2 - gravar um vídeo da tela do seu computador, com base nas orientações descritas no próximo tópico, salvar o vídeo no seu Drive Pessoal (acesso público) e subir o link no seguinte documento do Google Forms: https://forms.gle/eQrxCe11Lma3XFZi6
    • O vídeo deve abranger todos os tópicos requeridos.
    • O vídeo poderá ser gravado com o auxílio do Google Meet, Zoom ou outro gravador de tela de sua preferência.
    • O vídeo deve conter áudio (narração/explicação), conforme a orientação.
    • O vídeo precisa ser contínuo. Então, se você cortar o vídeo, precisa editar e juntar as partes antes de nos enviar.
    • Importante: O não envio do vídeo ou o envio após o prazo estabelecido (22/12/23, 23h59) acarretará em eliminação automática do programa, sem exceções. 

Instruções do Desafio: 
Envie o link do git contendo os tópicos solicitados e grave um vídeo explicativo para todos os tópicos mencionados abaixo e demonstrando o que foi feito, com duração máxima de 15 minutos. Certifique-se de demonstrar e explicar os conceitos de forma clara e concisa.

A avaliação será baseada na qualidade dos códigos, na clareza da explicação, na precisão das informações e na demonstração prática dos conceitos. Certifique-se de que o áudio e o vídeo estejam de boa qualidade.

Esta avaliação testará seu conhecimento prático do Liferay, qualidade de código e sua capacidade de comunicar eficazmente os conceitos aos outros. Boa sorte!

Tópicos para o Desafio: 
O objetivo desse desafio é compreender e consolidar todo o entendimento que foi passado durante esses 3 meses de conteúdo. 

Cenário:

Um cliente solicitou a criação de um mini portal de notícias e eventos, que deve conter pelo menos 4 páginas, sendo 1 página home e 3 páginas de detalhes e um layout minimamente customizado (sugerido pelo desenvolvedor).

Para a criação deste cenário, os requisitos são:

1- Home

A página home deve conter uma lista das notícias mais recentes, organizadas por cards (com thumb da notícia), e com o máximo de 4 notícias nessa listagem. O texto do card deve ser um breve resumo da notícia, de no máximo 50 caracteres.

Também deve conter uma lista de eventos mais recentes (com thumb do evento), sendo obrigatoriamente este componente um portlet, contendo também a lista de no máximo 4 itens. O texto do card deve ser um breve resumo da notícia, de no máximo 50 caracteres.

Ao clicar em uma notícia ou evento, ele deverá ser linkado com a página de detalhe deste conteúdo.

2- Detalhe da notícia

Nesta página de detalhe, a notícia deverá conter 1 imagem, o detalhe completo da notícia, a data de publicação do conteúdo e a listagem de tags para esta notícia.

3- Detalhe do evento

Nesta página de detalhe, o evento deverá conter a data de início e fim do evento, a listagem de tags deste evento, a descrição do evento e o local desse evento.

4- Usuários

Deverá existir 2 tipos de usuários: 1 usuário que pode ver os eventos da localidade Rio de Janeiro e outro usuário que pode ver somente os eventos da localidade São Paulo. 

Dica: Para este desafio deverá ser criado um campo customizado para o usuário com a sua localidade que será filtrada na exibição dos eventos.

</details>

<br>

<br>

## Passos que usei

### 1° passo - Criação do site "Desafio2" 

Acessei menu global na guia sites e criei o novo site conforme print.

<details>
<summary>Print da criação do site</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/01.jpg" alt="" width="700">

</details>

<br>

### 2° passo - Criação de Estrutura para noticia/ template para noticia/widget da noticia/ criação de noticias

1 - Vamos criar uma estrutura para noticia para padronizar os campos que vamos usar:

<details>
<summary>Print da criação da estrutura</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/02.jpg" alt="" width="700">

</details>

<br>

<br>

2 - Agora vamos criar um template para mostrar a noticia na tela. Aqui usei um card bootstrap para encapsular cada campo. 

<details>
<summary>Print da criação da estrutura</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/03.jpg" alt="" width="700">

</details>

<details>
<summary>Código freemarker usado</summary>

```freemarker

<div class="card hover" style="width: 18rem; padding-right: 15px; border: 1px solid #ccc; border-radius: 8px; margin-right: 15px; margin-left: 15px;">
    <div class="card-body">
        <!-- Imagem da noticia -->
        <#if (imagem_noticia.getData())?? && imagem_noticia.getData() != "" >
            <img class="card-img-top" 
                 alt="${imagem_noticia.getAttribute("alt")}" 
                 data-fileentryid="${imagem_noticia.getAttribute("fileEntryId")}" 
                 src="${imagem_noticia.getData()}" />
        </#if>

        <!-- Data da noticia -->
        <div class="card-body">
            <#assign data_noticia_Data = getterUtil.getString(data_noticia.getData())>

            <#if validator.isNotNull(data_noticia_Data)>
                <#assign data_noticia_DateObj = dateUtil.parseDate("yyyy-MM-dd", data_noticia_Data, locale)>
                ${dateUtil.getDate(data_noticia_DateObj, "dd MMM yyyy", locale)}
            </#if>
        </div>
    </div>

    <div class="card-body">
        <!-- Titulo da noticia -->
        <#if (titulo_noticia.getData())??>
            <h2 class="card-title" style="font-size: larger;">${titulo_noticia.getData()}</h2>
        </#if>

        <!-- Descricao da noticia (maximo 50 caracteres) -->
        <p class="card-text">
            <#if (descricao_noticia.getData())??>
                <#assign limitedDescription = descricao_noticia.getData()>
                <#if limitedDescription?length gt 50>
                    <#assign limitedDescription = limitedDescription?substring(0, 50) + "..." />
                </#if>
                ${limitedDescription}
            </#if>
        </p>
    </div>

    <!-- Inserir URL -->
    <#if (url_noticia.getData())??>
        <!-- Store the URL in a variable -->
        <#assign urlAmigavel = url_noticia.getData()>

        <div class="card-body">
            <!-- Crie um link com o URL -->
            <a href="${urlAmigavel}" class="btn btn-primary">LEIA MAIS</a>
        </div>
    </#if>
</div>


```

</details>

<br>

<br>

3 - Pra finalizar, criei um widget template para utilizar o template da noticia criado no passo anterior (usando o DDM do template criado no passo anterior).

<details>
<summary>Print da criação do widget</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/05.jpg" alt="" width="700">

</details>

<details>
<summary>Código freemarker usado</summary>

```freemarker

<#if entries?has_content>
    <div class="container-all d-flex">
        <#list entries as curEntry>
            <#assign article=curEntry.getAssetRenderer().getArticle() />
            <@liferay_journal["journal-article"]
                articleId=article.getArticleId()
                groupId=article.getGroupId()
                ddmTemplateKey="34976" />
        </#list>
    </div>
</#if>

```

</details>

<br>

<br>

4 - Agora criei 5 noticias a partir da estrutura para testar a exibição em tela.

<details>
<summary>Print da criação de noticias</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/04.jpg" alt="" width="700">

</details>

<br>

<br>

### 3° passo - Criação de estrutura para eventos/ template para expor os campos ta estrutura de eventos/ criação de ventos teste

1 - Vamos criar uma estrutura para eventos para padronizar os campos que vamos usar:

<details>
<summary>Print da criação da estrutura</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/07.jpg" alt="" width="700">

</details>

<br>

<br>

2 - Criação de template para eventos para expor os campos da estrutura (Neste caso vamos apenas expor os campos. Não precisaremos criar o widget pois a exibição será feita pelo portlet)

<details>
<summary>Print da criação do template para evento</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/08.jpg" alt="" width="700">

</details>

<details>
<summary>Código freemarker usado</summary>

```freemarker

<#if (titulo_evento.getData())??>
	${titulo_evento.getData()}
</#if>

<#if (imagem_evento.getData())?? && imagem_evento.getData() != "">
	<img alt="${imagem_evento.getAttribute("alt")}" data-fileentryid="${imagem_evento.getAttribute("fileEntryId")}" src="${imagem_evento.getData()}" />
</#if>

<#if (descricao_evento.getData())??>
	${descricao_evento.getData()}
</#if>

<#if (data_inicio_evento.getData())??>
	${data_inicio_evento.getData()}
</#if>

<#if (data_fim_evento.getData())??>
	${data_fim_evento.getData()}
</#if>

<#if (local_evento.getData())??>
	${local_evento.getData()}
</#if>

<#if (url_evento.getData())??>
	${url_evento.getData()}
</#if>

```

</details>

<br>

<br>

3 - Agora criei 5 eventos a partir da estrutura criada em um dos passos anteriores. 

<details>
<summary>Print da criação de eventos</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/13.jpg" alt="" width="700">

</details>

<br>

<br>

### 4° passo - Criação do portlet para exibição de eventos
Aqui, com a ajuda do LDS, vamos criar um portlet para mostrar os eventos. Também vamos formatar a forma que os eventos serão exibidos utilizando um card bootstrap.

<details>
<summary>Classe View.jsp</summary>

```java
<%@ include file="/init.jsp" %>

<%
	EventoDTO eventoDTO = (EventoDTO) request.getAttribute("eventoDTO");
%>

<%@ page import="java.util.List" %>
<%@ page import="br.com.portlet.EventoDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
</head>

<body>
    <div class="container mt-4">
        <div class="row">
            <%
                List<EventoDTO> eventos = (List<EventoDTO>) request.getAttribute("eventos");
                if (eventos != null && !eventos.isEmpty()) {
                    for (EventoDTO evento : eventos) {
            %>
                        <div class="col-md-4 mb-4">
                            <div class="card" style="width: 18rem;">
                                
																											

                                <div class="card-body">
                                    <h5 class="card-title"><%= evento.getTitulo_evento() %></h5>
                                    <p class="card-text"><%= evento.getDescricao_evento() %></p>
                                    <p class="card-text"><small class="text-muted">Data do início do evento: <%= evento.getData_inicio_evento() %></small></p>
                                    <p class="card-text"><small class="text-muted">Data do fim do evento: <%= evento.getData_fim_evento() %></small></p>
                                    <p class="card-text"><small class="text-muted">Local: <%= evento.getLocal_evento() %></small></p>
                                    <% if (evento.getUrl_evento() != null && !evento.getUrl_evento().isEmpty()) { %>
                                        <a href="<%= evento.getUrl_evento() %>" class="btn btn-primary">LEIA MAIS</a>
                                    <% } %>
                                </div>
                            </div>
                        </div>
            <%
                    }
                } else {
            %>
                    <div class="col-12">
                        <p>Nenhum evento disponível.</p>
                    </div>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>
```

</details>

<details>
<summary>Classe Temp_eventosPorlet.java</summary>

```java
package br.com.portlet;

//Imports
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Component;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.journal.util.comparator.ArticleModifiedDateComparator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.com.constants.Temp_eventosPortletKeys;
import br.com.portlet.EventoDTO;

/**
 * @author joshp
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Temp_eventos",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + Temp_eventosPortletKeys.TEMP_EVENTOS,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
	public class Temp_eventosPortlet extends MVCPortlet {
		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			
			
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				
				long groupId = PortalUtil.getScopeGroupId(renderRequest);
				long folderId = getFolderIdByName(groupId, "Eventos");
				
				OrderByComparator<JournalArticle> orderByComparator = new ArticleModifiedDateComparator(false); 
				List<JournalArticle> articles = JournalArticleLocalServiceUtil.getArticles(groupId, folderId, 0, 4, orderByComparator);
		        List<EventoDTO> eventos = new ArrayList<>();
		        
		        for (JournalArticle article : articles) {
		            EventoDTO eventoDTO = new EventoDTO();
		        	         	            
		        
		            //Chamando atributos da estrutura
		            eventoDTO.setTitulo_evento(getStructureContentByName(article.getArticleId(), groupId, "titulo_evento"));
		            eventoDTO.setData_inicio_evento(getStructureContentByName(article.getArticleId(), groupId, "data_inicio_evento"));
		            eventoDTO.setData_fim_evento(getStructureContentByName(article.getArticleId(), groupId, "data_fim_evento"));
		            eventoDTO.setImagem_evento(getStructureContentByName(article.getArticleId(), groupId, "imagem_evento"));
		            eventoDTO.setDescricao_evento(getStructureContentByName(article.getArticleId(), groupId, "descricao_evento"));
		            eventoDTO.setUrl_evento(getStructureContentByName(article.getArticleId(), groupId, "url_evento"));
		            eventoDTO.setLocal_evento(getStructureContentByName(article.getArticleId(), groupId, "local_evento"));
		            
		          
		            // Regra para exibir 50 caracteres
		            String descricaoCompleta = getStructureContentByName(article.getArticleId(), groupId, "descricao_evento");
		            if (descricaoCompleta != null && descricaoCompleta.length() > 50) {
		                descricaoCompleta = descricaoCompleta.substring(0, 50) + "...";
		            }
		            eventoDTO.setDescricao_evento(descricaoCompleta);
		                                                                                                                        
		            eventos.add(eventoDTO);
		            
		            // Parar se já adicionou 4 eventos únicos
		            if (eventos.size() == 4) {
		                break; 
		            }
		                                        
		        }
		                
		        
		        //Regras para localidade do usuário
		        renderRequest.setAttribute("eventos", eventos);
		        renderRequest.setAttribute("user", user);

		    } catch (PortalException | DocumentException e) {
		        e.printStackTrace();
		    }
			
			super.doView(renderRequest, renderResponse);
		}

		private long getFolderIdByName(long groupId, String folderName) throws PortalException {
		    List<JournalFolder> folders = JournalFolderLocalServiceUtil.getFolders(groupId, 0);

		    for (JournalFolder folder : folders) {
		        if (folder.getName().equalsIgnoreCase(folderName)) {
		            return folder.getFolderId();
		        }
		    }

		    return 0; // Retorna 0 ou lança uma exceção se a pasta não for encontrada
		}	

		public static String getStructureContentByName(String articleId, long groupId, String name)
				throws PortalException, DocumentException {
			final JournalArticle article = JournalArticleLocalServiceUtil.getArticle(groupId, articleId);
			final Document document = SAXReaderUtil.read(article.getContent());
			final Node node = document
					.selectSingleNode("/root/dynamic-element[@field-reference='" + name + "']/dynamic-content");

			return node != null ? node.getText() : null;
		}	
	}
```

</details>

<details>
<summary>EventoDTO.java</summary>

```java
package br.com.portlet;

public class EventoDTO {

	//Atributos da minha estrutura
    private String titulo_evento;
	private String imagem_evento;
	private String descricao_evento;
	private String data_inicio_evento;
	private String data_fim_evento;
	private String url_evento;
	private String local_evento;
	
	//Getters e setters 
	public String getTitulo_evento() {
		return titulo_evento;
	}
	public void setTitulo_evento(String titulo_evento) {
		this.titulo_evento = titulo_evento;
	}
	public String getImagem_evento() {
		return imagem_evento;
	}
	public void setImagem_evento(String imagem_evento) {
		this.imagem_evento = imagem_evento;
	}
	public String getDescricao_evento() {
		return descricao_evento;
	}
	public void setDescricao_evento(String descricao_evento) {
		this.descricao_evento = descricao_evento;
	}
	public String getData_inicio_evento() {
		return data_inicio_evento;
	}
	public void setData_inicio_evento(String data_inicio_evento) {
		this.data_inicio_evento = data_inicio_evento;
	}
	public String getData_fim_evento() {
		return data_fim_evento;
	}
	public void setData_fim_evento(String data_fim_evento) {
		this.data_fim_evento = data_fim_evento;
	}
	public String getUrl_evento() {
		return url_evento;
	}
	public void setUrl_evento(String url_evento) {
		this.url_evento = url_evento;
	}
	public String getLocal_evento() {
		return local_evento;
	}
	public void setLocal_evento(String local_evento) {
		this.local_evento = local_evento;
	}
	
}
```

</details>

<br>

<br>

### 5° passo - Criação de 2 usuários com um campo a mais para localização

Aqui vamos criar o usuários "Joao" e "Maria". João tem a localidade marcada com SP e Maria como RJ

<details>
<summary>Print da criação de usuários</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/09.jpg" alt="" width="700">

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/10.jpg" alt="" width="700">

</details>

<br>

<br>

### 6° passo - Criação de tags para noticias e eventos
Agora vamos criar as tags para categorizar os eventos e noticias por assunto.

<details>
<summary>Print da criação das tags</summary>

<img src="/Conteudo/3 - Trilha Back/Desafio%202/img/14.jpg" alt="" width="700">

</details>

<br>

<br>

[Voltar para Back-End](/Conteudo/3%20-%20Trilha%20Back/3%20Back.md)
[Voltar para inicio](/README.md)
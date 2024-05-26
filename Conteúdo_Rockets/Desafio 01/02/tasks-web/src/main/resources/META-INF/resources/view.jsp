<%@ include file="/init.jsp" %>

<%@ page import="tasks.model.Task" %>
<%@ page import="java.util.List" %>
<portlet:defineObjects />

<jsp:useBean id="tasks" type="java.util.List" scope="request" />

<h2>Add Task</h2>
<form action="<portlet:actionURL name='addTask'>" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br>
    <button type="submit">Add Task</button>
</form>

<h2>Tasks</h2>
<table border="1">
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Completed</th>
            <th>Create Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td><c:out value="${task.title}" /></td>
                <td><c:out value="${task.description}" /></td>
                <td><c:out value="${task.completed}" /></td>
                <td><c:out value="${task.createDate}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
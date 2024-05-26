<%@ include file="/init.jsp" %>



<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<style>
    .time-box {
        border: 2px solid #ccc;
        padding: 20px;
        margin: 20px 0;
        border-radius: 5px;
        background-color: #f9f9f9;
    }
    form {
        margin-top: 20px;
    }
    input[type="text"] {
        padding: 10px;
        margin-right: 10px;
        width: 200px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button {
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        background-color: #4CAF50;
        color: white;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
</style>

<div class="time-box">
    <h2>Current Time: ${currentTime}</h2>
    <form action="<portlet:actionURL/>">
        <input type="text" name="userZone" placeholder="Enter UTC (Ex., 'UTC+3')">
        <button type="submit">Update Time</button>
    </form>
</div>
<%--
  Created by IntelliJ IDEA.
  User: evdodima
  Date: 26/03/16
  Time: 01:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<form name="process" method="post" action="/result">
    <input type="text" name="string">
    <select name="processType">
        <option value="1">Number of symbols</option>
        <option value="2">Number of words</option>
        <option value="3">Number of sentences</option>
        <option value="4">Number of paragraphs</option>
    </select><Br>
    <input type="submit" value="Process">
</form>
</body>
</html>

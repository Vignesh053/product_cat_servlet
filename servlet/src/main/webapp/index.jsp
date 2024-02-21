<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Feedback Form</title>
</head>
<body>
    <h2>Feedback Submission</h2>
    <form action="insertdata" method="post">
        Your Name: <input type="text" name="username"><br>
        Book Name: <input type="text" name="book"><br>
        Feedback: <textarea name="feed"></textarea><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Zakusylo.p
  Date: 28.03.2017
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="ua.kiev.prog.Apartment" import="ua.kiev.prog.ApartmentList" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Apartments</title>
</head>
<body>
<table width='30%' align='right' border='2' cellpadding='5'>
    <caption><h3>The list of apartments</h3></caption>
    <tr>
        <th>ID</th>
        <th>Number rooms</th>
        <th>Address</th>
        <th>Floor</th>
        <th>Prise</th>
    </tr>
    <%
        ApartmentList list = (ApartmentList) request.getAttribute("list");
        if (list != null) {
            for (Apartment apartment : list.getList()) {
                out.println("<tr>");
                out.println("<td>" + apartment.getId() + "</td>" +
                        "<td>" + apartment.getRooms() + "</td>" +
                        "<td>" + apartment.getAddress() + "</td>" +
                        "<td>" + apartment.getFloor() + "</td>" +
                        "<td>" + apartment.getPrise() + "</td>");
                out.println("</tr>");
            }
        }
    %>
</table>

Add new apartment to the list
<form name='addApartment' action='/apartment' method='POST'>
    ID: <input type='text' name='idA' size='5'>&nbsp;&nbsp;&nbsp;
    Number rooms: <input type='text' name='roomsA' size='5'>&nbsp;&nbsp;&nbsp;
    Address: <input type='text' name='addressA' size='15'>&nbsp;&nbsp;&nbsp;
    Floor: <input type='text' name='floorA' size='5'>&nbsp;&nbsp;&nbsp;
    Price: <input type='text' name='priceA' size='10'>&nbsp;&nbsp;&nbsp;
    <br/><input type='submit' value='Add'/>&nbsp;&nbsp;&nbsp;
</form>
<br>

Delete apartment from the list
<form action='/apartment' method='POST'>
    ID:<input type='text' name='idD' size='5'>
    <br/><input type='submit' value='Delete'/>
</form>
<br>

Reduse/Increase apartment price
<form action='/apartment' method='POST'>
    ID: <input type='text' name='idC' size='5'>&nbsp;&nbsp;&nbsp;
    New price: <input type='text' name='priceC' size='10'>
    <br/><input type='submit' value='Change'/>
</form>
<br>

Search apartment in the range
<form action='/apartment' method='POST'>
    Price from: <input type='text' name='priceR1' size='10'>&nbsp;&nbsp;&nbsp;
    Price up to: <input type='text' name='priceR2' size='10'>
    <br/><input type='submit' value='Search'/>
</form>
<br>

Search apartment by rooms
<form action='/apartment' method='POST'>
    Number rooms: <input type='text' name='roomsN' size='5'>&nbsp;&nbsp;&nbsp;
    <br/><input type='submit' value='Search'/>
</form>
<br>

Specify the path to save (D:\\Other\\File.xml):
<form action='/apartment' method='POST'>
    Path: <input type='text' name='path' size='15'>
    <br/><input type='submit' value='Save'/>
</form>
<br>

<table width='30%' align='center' border='2' cellpadding='5'>
    <caption><h3>The result of search</h3></caption>
    <tr>
        <th>ID</th>
        <th>Number rooms</th>
        <th>Address</th>
        <th>Floor</th>
        <th>Prise</th>
    </tr>
    <%
        ApartmentList listResult = (ApartmentList) request.getAttribute("listResult");
        if (listResult != null) {
            for (Apartment apartment : listResult.getList()) {
                out.println("<tr>");
                out.println("<td>" + apartment.getId() + "</td>" +
                        "<td>" + apartment.getRooms() + "</td>" +
                        "<td>" + apartment.getAddress() + "</td>" +
                        "<td>" + apartment.getFloor() + "</td>" +
                        "<td>" + apartment.getPrise() + "</td>");
                out.println("</tr>");
            }
        }
    %>
</table>
</body>
</html>

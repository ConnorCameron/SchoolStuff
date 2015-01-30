<%@ page import="java.util.*, unl.cse.music.Album" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Album List</title>
</head>
<body>

<jsp:useBean id="myAlbums" class="unl.cse.music.AlbumBean" scope="session" />

<h1>My Albums</h1>
<table>
<tr>
  <th>Title</th>
  <th>Band</th>
  <th>Release Year</th>
</tr>
<% for(Album a : myAlbums.getAlbums()){%>
  <tr>
    <td><a href="./albumDetail.jsp?albumId=<%=a.getAlbumId()%>"><%=a.getTitle()%></a></td>
    <td><a href="./bandDetail.jsp?bandId=<%=a.getBand().getBandId()%>"><%=a.getBand().getName()%></a></td>
    <td><%=a.getYear() %></td>
  </tr>
<%}%>
</table>

</body>
</html>
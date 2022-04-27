<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%
/* 	//커넥션 얻기
	Connection con=JdbcUtil.getConnection();
	bookDAO dao= new bookDAO(con);
	
	//전체 멤버 얻어오기
	List<bookDTO> list=dao.getList(); */
	
	//db 연결을 안했음.. listpro 페이지를 들렸다 가는걸로 바꿨음
	//List<bookDTO> list=(List<bookDTO>)request.getAttribute("list");
%>
<h1>도서 목록 보기</h1>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">code</th>
      <th scope="col">title</th>
      <th scope="col">writer</th>
      <th scope="col">price</th>
    </tr>
  </thead>
  <tbody>
  <%--도서 목록--%>
<%--   <%for(bookDTO dto:list){ %>
  <tr>
  	<td> <%=dto.getCode()%> </td>
  	<td> <%=dto.getTitle() %></td>
  	<td> <%=dto.getWriter() %></td>
  	<td> <%=dto.getPrice() %></td>
  </tr> <%} %> --%>
<c:forEach var="dto" items='${list}'>
  <tr>
  	<td>${dto.code} </td>
  	<td>${dto.title}</td>
  	<td>${dto.writer}</td>
  	<td>${dto.price}</td>
  </tr>
</c:forEach>
  </tbody>
  </table>
<%@ include file="../layout/footer.jsp" %>
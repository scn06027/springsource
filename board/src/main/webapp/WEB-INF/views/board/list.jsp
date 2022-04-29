<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- 특정 포맷을 바꾸고싶다? 그럴때 써먹으면됨. -->

<%@include file="../includes/header.jsp" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board List</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        Board List Page
        <button id="regBtn" type="button" class="btn btn-xs pull-right">
          Register New Board
        </button>
      </div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <table class="table table-striped table-bordered table-hover">
          <thead>
            <tr>
              <th>번 호</th>
              <th>제 목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>수정일</th>
            </tr>
          </thead>
          <tbody>
          <!-- 게시판 리스트 반복문 -->
         
          	<c:forEach var="dto" items="${list}">
          	 <tr>
          	<td>${dto.bno}</td>
          	<td><a href="/board/read?bno=${dto.bno}">${dto.title}</a></td>
          	<td>${dto.writer}</td>
          	<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.regdate}"/></td>
          	<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dto.updatedate}"/>  </td>
          	</tr>
          	</c:forEach>
          
          </tbody>
          
        </table>
        <div class="row">
          <!-- start search -->
          <div class="col-md-12">
            <div class="col-md-8"><!--search Form--></div>
            <div class="col-md-2 col-md-offset-2">
              <!--페이지 목록 갯수 지정하는 폼-->
              <select name="" id="amount" class="form-control" width="10px">
              	<option value="10" <c:out value="${cri.amount==10?'selected':''}"/>>10</option>
              	<option value="20" <c:out value="${cri.amount==20?'selected':''}"/>>20</option>
              	<option value="10" <c:out value="${cri.amount==30?'selected':''}"/>>30</option>
              	<option value="40" <c:out value="${cri.amount==40?'selected':''}"/>>40</option>
              </select>
            </div>
          </div>
        </div>
        <!-- end search -->
        <!-- start Pagination -->
        <div class="text-center">
          <ul class="pagination">
            <c:if test="${pageDto.prev}">
            <li class="paginate_button previous"><a href="${pageDto.startPage-1}">Previous</a></li>
            </c:if>
            <c:forEach var="idx" begin="${pageDto.startPage}" end="${pageDto.endPage}">
            	<li class="paginate_button ${pageDto.cri.pageNum==idx?'active':''}"><a href="${idx}">${idx}</a></li>
            </c:forEach>
            
             <c:if test="${pageDto.next}">
            <li class="paginate_button next"><a href="${pageDto.endPage+1}">Next</a></li>
          	</c:if>
          </ul>
        </div>
        <!-- end Pagination -->
      </div>
      <!-- end panel-body -->
    </div>
    <!-- end panel -->
  </div>
</div>
<!-- /.row -->
<%-- 페이지링크를 처리할 폼 --%>
<form action="/board/list" id="actionForm">
<!-- pageNum,amount,type,keyword 값을 부를때 - 1) pageDto(pageDto.cri.pageNum) 
2)바로 Cri에서 끌어다 쓰기(criteria.pageNum)
(cri.pageNum) < -이건 modelAttribute -->
	<input type="hidden" name="pageNum" value="${cri.pageNum}" />
	<input type="hidden" name="amount" value="${cri.amount}" />
</form>
<!-- 모달 추가 -->
<div class="modal" tabindex="-1" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">게시글 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>처리가 완료되었습니다..</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- 스크립트 -->
<script>
//게시글 등록 성공하면 result 확인해라
let result='${result}'; //아주 잠깐의 세션을 가져와주자

</script>
<script src="/resources/js/list.js"></script>
<%@include file="../includes/footer.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="contract_date">契約日</label><br />
<input type="date" name="contract_date" value="<fmt:formatDate value='${company.contract_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="name">企業名</label><br />
<input type="text" name="company_name" value="${company.company_name}" />
<br /><br />

<label for="president">代表者</label><br />
<input type="text" name="president" value="${company.president}" />
<br /><br />

<label for="tellnumber">電話番号</label><br />
<input type="text" name="tellnumber" value="${company.tellnumber}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>
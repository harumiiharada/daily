<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>企業　一覧</h2>
        <table id="company_list">
            <tbody>
                <tr>
                    <th class="company_name">企業名</th>
                    <th class="comtract_date">契約日</th>
                    <th class="president">代表者</th>
                    <th class="company_action">操作</th>
                </tr>
                <c:forEach var="company" items="${companys}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="company_name">${company.company_name}</td>
                        <td class="contract_date"><fmt:formatDate value='${company.contract_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="president">${company.president}</td>
                        <td class="company_action"><a href="<c:url value='/companys/show?id=${company.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${companys_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((companys_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/companys/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/companys/new' />">新契約先企業の登録</a></p>

    </c:param>
</c:import>
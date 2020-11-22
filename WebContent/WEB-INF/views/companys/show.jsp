<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

                <h2>契約企業　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>企業名</th>
                            <td><c:out value="${company.company_name}" /></td>
                        </tr>
                        <tr>
                            <th>契約日</th>
                            <td><fmt:formatDate value="${company.contract_date}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>代表者</th>
                            <td>
                                <pre><c:out value="${company.president}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>電話番号</th>
                            <td>
                                <c:out value="${company.tellnumber}" />
                            </td>
                        </tr>

                    </tbody>
                </table>


        <p><a href="<c:url value="/companys/edit?id=${company.id}"/>">この企業情報を編集する</a></p>
        <p><a href="<c:url value="/companys/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>
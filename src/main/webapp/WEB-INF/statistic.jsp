<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>
<div class="lex-content">
    <div class="lex-table-wrapper">
        <table class="table table-striped table-hover" style="width: 80%">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">All Games</th>
                    <th scope="col">InProgress</th>
                    <th scope="col">Won</th>
                    <th scope="col">Lost</th>
                    <th scope="col">Created Quests</th>
                </tr>
            </thead>
            <tbody class="table-group-divider">
                <c:forEach var="statUser" items="${requestScope.statistic.users}">
                    <tr>
                        <td>${statUser.name}</td>
                        <td>${statUser.allGames}</td>
                        <td>${statUser.inProgressGames}</td>
                        <td>${statUser.winGames}</td>
                        <td>${statUser.lostGames}</td>
                        <td>${statUser.createdQuests}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="footer.jsp" %>
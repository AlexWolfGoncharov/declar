<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Поиск записей. Удержание</title>

    <%--<link rel="icon" href="<c:url value="/img/favicon.ico" />" type="image/x-icon">--%>


    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <%--<link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">--%>
    <link href="<c:url value="/css/main.css" />" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>




    <%--DatePicker JA and CSS--%>
    <%--<link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.4.5/jquery.datetimepicker.min.css"  rel="stylesheet">--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.4.5/jquery.datetimepicker.min.js"></script>--%>
    <link href="<c:url value="/css/bootstrap-datetimepicker.min.css" />" rel="stylesheet">


    <%--<script--%>
    <%--src="<c:url value="/pages/js/jquery.js" />"></script>--%>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
    <%--<link href="<c:url value="/pages/js/bootstrap.js" />" rel="text/javascript">--%>


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script> -->


</head>
<body>
<%@include file="header.jsp" %>
<div class="container">

    <div class="page-header">

        <h2>Удержание - Все записи</h2>

    </div>




    <ul class="nav nav-tabs" role="tablist">

        <li role="presentation"  class="active">
            <a href="#date" aria-controls="date" role="tab" data-toggle="tab" id="date-tab"><i style="vertical-align:middle; font-size: 2em;" class="material-icons">date_range</i>Выбор за дату</a></li>

        <li role="presentation">
            <a href="#all" aria-controls="all" role="tab" data-toggle="tab" id="all-tab"><i style="vertical-align:middle; font-size: 2em;" class="material-icons">view_module</i>Отображение всех</a></li>

    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="date" aria-labelledby="date-tab">

            <h2>Выбор записей за период </h2>


            <form:form method="get" action=""  class="form-inline">


                <div class="form-group">
                    <label for="start">с </label>
                    <input name="start" class="form-control" type="datetime" id="start" placeholder="дд.мм.гггг" value="<%= request.getParameter("start") %>"/>
                </div>
                <div class="form-group">
                    <label for="end">по </label>
                    <input name="end" class="form-control" type="datetime" id="end" placeholder="дд.мм.гггг" value="<%= request.getParameter("end") %>"/>
                </div>
                <button type="submit" class="btn btn-success text-center">Поиск</button>


            </form:form>



        </div>

        <div role="tabpanel" class="tab-pane" id="all" aria-labelledby="all-tab">


            <h2>Поиск всех записей</h2>

            <form:form method="get" action=""  class="form">

                <div class="form-group">
                    <div class="col-md-3 control-label">
                        <label for="okpo"> Укажите ОКПО для поиска:</label>
                    </div>
                    <div class="col-md-10">
                        <input type='text' class="form-control" name='OKPO'  size=15 maxlength=10 id='okpo'/>


                    </div>
                </div>




                <div class="form-group">
                    <div class="col-md-12 control-label">
                        <label>  Показать все записи   <input type='checkbox' name='all'  id = 'all'></label>
                    </div>


                </div>
                <div class="form-group">
                    <div class="col-md-10 text-center">
                        <button type='reset' id='reset' class="btn btn-danger "> Сброс</button>
                        <button type="submit" class="btn btn-success  ">Поиск</button>
                    </div>
                </div>
            </form:form>
        </div>




    </div>

</div>




<c:if test="${!empty clientList}">
    <div class="container">
        <h2>Список записей:</h2>
        <h3>Всего найдено ${clientList.size()} записей</h3>
        <table class="table table-striped">
            <tr>
                <th>№п/п</th>
                <th>ID записи</th>
                <th>ОКПО</th>
                <th>Дата добавления</th>
                <th>Событие</th>

            </tr>

            <c:forEach items="${clientList}" var="client" varStatus="myIndex">
                <tr>
                    <td>${myIndex.index + 1}</td>
                    <td>${client.ID}</td>
                    <td>${client.OKPO}</td>

                    <td><fmt:formatDate pattern="dd.MM.yyyy"
                                        value="${client.date}" /></td>

                    <td>${client.event}</td>
                </tr>
            </c:forEach>
        </table>

    </div>

</c:if>

</div>


<script type="text/javascript" src="<c:url value="js/bootstrap-datetimepicker.min.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="js/bootstrap-datetimepicker.ru.js" />" charset="UTF-8"></script>

<script type="text/javascript">
    $('#${tab}-tab').tab('show')


    $("#start").datetimepicker({format: 'dd.mm.yyyy', autoclose: true,
        todayBtn: true, keyboardNavigation: true, language: 'ru', minView: 2});


    $("#end").datetimepicker({format: 'dd.mm.yyyy', autoclose: true,
        todayBtn: true, keyboardNavigation: true, language: 'ru', minView: 2});





    function formatDate(today){
        var year = today.getFullYear();
        var mounth = today.getMonth() +1;
        var day = today.getDate();
        var hours = today.getHours();
        var minutes = today.getMinutes();
        var seconds = today.getSeconds();

        //"dd.mm.yyyy"

        var formated = (day < 10 ? "0"+day : day) + "."
                + (mounth < 10 ? "0"+mounth : mounth) + "."
                +year

        return formated;

    }

    var startDate = document.getElementById('start');
    if (startDate.value == 'null') {
        startDate.value = formatDate(new Date());
    }

    var endDate = document.getElementById('end');
    if (endDate.value == 'null') {
        endDate.value = formatDate(new Date());
    }






</script>
</body>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Справки для Деклараций</title>

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

        <h2>Формирование справок для деклараций</h2>

    </div>




    <form:form method="get" action="declar"  class="form-inline">


        <div class="form-group">
            <label class="sr-only" for="sid">Сессия Проминя</label>
            <input type="text" class="form-control" id="sid" placeholder="SID" name="SID">
        </div>
        <div class="form-group">
            <label class="sr-only" for="idEKB">ID ЕКБ клиента</label>
            <input type="text" class="form-control" id="idEKB" placeholder="ИНН клиента" name="INN">
        </div>
        <div class="form-group">
            <label class="sr-only" for="datestart">DATE_FROM</label>
            <input type="text"  name="start" class="form-control" id="datestart" placeholder="DATE_FROM" value="01.01.2015">
        </div>
        <div class="form-group">
            <label class="sr-only" for="dateend">DATE_TO</label>
            <input type="text"  name="end" class="form-control" id="dateend" placeholder="DATE_TO" value="31.12.2015">
        </div>
        <button type="submit" class="btn btn-primary" >Сформировать</button>



    </form:form>







<c:if test="${!empty SaldoODeclarList}">
    <div class="container">
        <h2>Інформація про залишки коштів та нараховані відсотки клієнта</h2>
        <table class="table table-bordered" id="saldo">
            <tr>
                <th rowspan="2">№ рахунку</th>
                <th rowspan="2">Найменування рахунку</th>
                <th rowspan="2">Валюта рахунку</th>
                <th colspan="2">Залишки</th>
                <th colspan="2">Сума вкладених коштів на рахунок</th>
                <th colspan="2">Сума нарахованих % (всього без вирахування податків)</th>
                <th colspan="2">Сума перерахованих податків</th>
                <th colspan="2">Сума перерахованого військового збіру</th>
                <th colspan="2">Сума зарахованих % після сплати податків</th>


            </tr>
            <tr>

                <td>в валюті рахунку</td>
                <td>в грн</td>
                <td>в валюті рахунку</td>
                <td>в грн</td>
                <td>в валюті рахунку</td>
                <td>в грн</td>
                <td>в валюті рахунку</td>
                <td>в грн</td>
                <td>в валюті рахунку</td>
                <td>в грн</td>
                <td>в валюті рахунку</td>
                <td>в грн</td>

            </tr>

            <c:forEach items="${SaldoODeclarList}" var="ODeclar" varStatus="myIndex">
                <tr class="text-center">
                    <td>${ODeclar.REF}</td>
                    <td>${ODeclar.TYPE}</td>
                    <td>${ODeclar.CURR}</td>
                    <td><fmt:formatNumber value="${ODeclar.OSTATOK}"
                                          type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.OSTATOK_EQ}"
                                          type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.CLIENT_MONEY}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.CLIENT_MONEY_EQ}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.NACH_PROC}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.NACH_PROC_EQ}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.NALOG}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.NALOG_EQ}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.VOEN_SBOR}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.VOEN_SBOR_EQ}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.ZACH_PROC}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.ZACH_PROC_EQ}" type="currency" currencySymbol="" /></td>
                </tr>
            </c:forEach>
        </table>

    </div>

</c:if>





<c:if test="${!empty credoDeclarList}">
    <div class="container table-responsive">
        <h2>Інформація про кредитні операції (у валюті рахунку)</h2>
        <table class="table  table-bordered" id="credo">
            <tr>
                <th rowspan="2">№ рахунку</th>
                <th rowspan="2">Найменування рахунку</th>
                <th rowspan="2">Валюта рахунку</th>
                <th rowspan="2">Встановлений кредитний ліміт</th>
                <th colspan="2">Заборгованість на 31 грудня</th>
                <th colspan="2">Кошти на погашення основної суми позики</th>
                <th colspan="2">Кошти на погашення суми процентів за позикою</th>



            </tr>
            <tr>
                <td>в валюті рахунку</td>
                <td>в грн</td>
                <td>в валюті рахунку</td>
                <td>в грн</td>
                <td>в валюті рахунку</td>
                <td>в грн</td>


            </tr>

            <c:forEach items="${credoDeclarList}" var="ODeclar" varStatus="myIndex">
                <tr class="text-center">
                    <td>${ODeclar.REF}</td>
                    <td>${ODeclar.TYPE}</td>
                    <td>${ODeclar.CURR}</td>
                    <td>${ODeclar.CRED_LIM}</td>
                    <td><fmt:formatNumber value="${ODeclar.DOLG}"
                                          type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.DOLG_EQ}"
                                          type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.DOLG_POGASH}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.DOLG_POGASH_EQ}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.PROC_POGASH}" type="currency" currencySymbol="" /></td>
                    <td><fmt:formatNumber value="${ODeclar.PROC_POGASH_EQ}" type="currency" currencySymbol="" /></td>
                </tr>
            </c:forEach>
        </table>

    </div>

</c:if>


</div>


<script type="text/javascript" src="<c:url value="js/bootstrap-datetimepicker.min.js" />" charset="UTF-8"></script>
<script type="text/javascript" src="<c:url value="js/bootstrap-datetimepicker.ru.js" />" charset="UTF-8"></script>

<script type="text/javascript">



    $("#datestart").datetimepicker({format: 'dd.mm.yyyy', autoclose: true,
        todayBtn: true, keyboardNavigation: true, language: 'ru', minView: 2});


    $("#dateend").datetimepicker({format: 'dd.mm.yyyy', autoclose: true,
        todayBtn: true, keyboardNavigation: true, language: 'ru', minView: 2});




    var INN = '<%= request.getParameter("INN") %>';
    if (INN.value !== 'null') {
        var idEKB = document.getElementById('idEKB');

        idEKB.value = INN;
    }


    var SID = '<%= request.getParameter("SID") %>';
    if (SID.value !== 'null') {
        var sid = document.getElementById('sid');

        sid.value = SID;
    }





    var saldoTable = document.getElementById("saldo");
    var cells = saldoTable.getElementsByTagName('td')
    for (var i = 0; i < cells.length; i++){

        if(cells[i].textContent == "") {
            cells[i].innerHTML = "&#8212;"
        }

    }








</script>
</body>
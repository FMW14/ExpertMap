<#import "parts/common.ftl" as c>

<@c.page>
<#--<form action="/logout" method="post">-->
    <#--<input type="hidden" name="_csrf" value="${_csrf.token}" />-->
<#--</form>-->

<h5 align="center">Hello, guest</h5>

<a href="/login">Login page</a>



<#--<script>-->
    <#--$(document).ready(function () {-->
        <#--$("#get_time").click(function () {-->
            <#--// alert("clicked");-->
            <#--$.ajax({-->
                <#--url : '/gettime',-->
                <#--success : function (data) {-->
                    <#--$("#test_time").html(data);-->
                <#--}-->
            <#--})-->
        <#--})-->

    <#--});-->

<#--</script>-->

<#--<p id="test_time"></p>-->

<#--<button id="get_time">Get time</button>-->

<#--<script type="text/javascript">-->

    <#--$(document).ready(function(){-->
        <#--$("#msgid").html("This is Hello World by JQuery");-->
    <#--});-->

<#--</script>-->

<#--<div id="msgid">-->
<#--</div>-->

<#--<div>-->
    <#--<form action="/logout" method="post">-->
        <#--<input type="submit" value="Sign Out"/>-->
        <#--<input type="hidden" name="_csrf" value="{{_csrf.token}}" />-->
    <#--</form>-->
<#--</div>-->


<#--<div align="center">Hello</div>-->
<#--<div>Hello</div>-->

    <#--<div>-->
        <#--<a href="/login">Login page</a>-->
        <#--&lt;#&ndash;<a href="/solution">Solution</a>&ndash;&gt;-->
        <#--<a href="/businessInfo">Business Info</a>-->
        <#--<a href="/expertList">Expert list</a>-->
        <#--<span><a href="/user">Userlist</a></span>-->
    <#--</div>-->

<#--<div id="app">-->
    <#--{{ msg }}-->
<#--</div>-->

<#--<script>-->
<#--var app = new Vue({-->
    <#--el: '#app',-->
    <#--data: {-->
        <#--msg: 'Привет, Vue!'-->
    <#--}-->
<#--})-->
<#--</script>-->

<#--<script src="/static/js/main.js"></script>-->
<#--<script type="text/javascript" src="/static/js/12.js"></script>-->

<#--<script type="application/javascript" src="/js/12.js"></script>-->
</@c.page>
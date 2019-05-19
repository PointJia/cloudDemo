<!--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/12
  Time: 10:23
  To change this template use File | Settings | File Templates.
-->
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
    <script src="static/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.min.css"/>
    <style>
        .main{
            width: 60%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<!--    template    -->
<div id="app">
    {{ message }}
</div>
<div class="main">
    <form id="event_form">
        <div class="row">
            <label for="eventName">EventName</label>
            <input type="text" class="form-control" id="eventName" placeholder="EventName">
        </div>
        <div class="row">
            <div>
                <label>Time</label>
            </div>
            <div class="col-lg-2">
                <input type="text" class="form-control" placeholder="start">
            </div>
            <div class="col-lg-2">
                <input type="text" class="form-control" placeholder="end">
            </div>
        </div>
        <div class="row">
            <label for="event_desc">desc</label>
            <textarea class="form-control" rows="3" id="event_desc"></textarea>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> Check me out
            </label>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            message: 'Hello Vue!'
        }
    })
</script>
</body>
</html>
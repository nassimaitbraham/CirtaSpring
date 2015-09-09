<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
	body {background: #555; width: 400px; border: 1px solid #fff; padding: 0px;}
    div {padding: 5px; margin: 0px;}
    h1, h2, p {padding: 0px; margin: 0px;}
	#banner-style {background: #3B3E37;}
	#title-style {background: #665845;}
	#subtitle-style {background: #9F8158;}
	#primary-style {background: #EBC785;}
	#footer-style {background: #733027;}
</style>

<title>Layout Detail</title>
</head>
<body>

<div id="banner-style"><tiles:insertAttribute name="banner-content" /></div>

<div id="title-style"><h2><tiles:insertAttribute name="title-content" /></h2></div>

<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
<div id="subtitle-style"><tiles:insertAttribute name="subtitle-content" /></div>
</sec:authorize>

<div id="primary-style""><tiles:insertAttribute name="primary-content" /></div>
<div id="footer-style"><tiles:insertAttribute name="footer-content" /></div>

</body>
</html>
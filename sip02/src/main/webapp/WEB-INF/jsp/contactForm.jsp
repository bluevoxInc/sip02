<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/jsp/urls.jspf" %>

<c:url var="formAction" value="${requestScope.action}" />

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>Contact details</title>
  </head>
  <body>
    <ul id="breadcrumbs">
      <li><a href="${homeUrl}">Home</a></li>
      <li><a href="${contactListUrl}">Contacts</a></li>
    </ul>
      
    <h1 class="vcard icon">Contact details</h1>
    
    <form:form action="${formAction}" method="${requestScope.method}" modelAttribute="contact" cssClass="main">
      <form:errors class="warning" element="div" />
          
      <div class="panel grid">
        <div class="gridRow yui-gf">
          <div class="fieldLabel yui-u first">First name:</div>
          <div class="yui-u">
            <div><form:input path="firstName" cssClass="short" /></div>
            <div>
            	</div><form:errors path="firstName" class="errorMessage" element="div" />
            </div>
        </div>
        <div class="gridRow yui-gf">
          <div class="fieldLabel yui-u first">Middle initial:</div>
          <div class="yui-u">
            <div><form:input path="middleInitial" cssClass="short" /></div>
            <div>
            	<form:errors path="middleInitial" class="errorMessage" element="div" />
            </div>
          </div>
        </div>
        <div class="gridRow yui-gf">
          <div class="fieldLabel yui-u first">Last name:</div>
          <div class="yui-u">
            <div><form:input path="lastName" cssClass="short" /></div>
            <div>
            	<form:errors path="lastName" class="errorMessage" element ="div" />
            </div>
          </div>
        </div>
        <div class="gridRow yui-gf">
          <div class="fieldLabel yui-u first">E-mail:</div>
          <div class="yui-u">
            <div><form:input path="email" cssClass="medium" /></div>
            <div>
            	<form:errors path="email" class="errorMessage" element="div" />
            </div>
          </div>
        </div>
        <div class="gridRow yui-gf">
          <div class="yui-u first"></div>
          <div class="yui-u">
            <input type="submit" value="Save" />
          </div>
        </div>
      </div>
    </form:form>
  </body>
</html>
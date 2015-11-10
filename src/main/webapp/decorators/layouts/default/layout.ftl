<#-- some /WEB-INF/view/inc/.ftl can come from canadensys-web-core project -->
<#include "/WEB-INF/view/inc/global-functions.ftl">
<!DOCTYPE html>
<html lang="${rc.getLocale().getLanguage()}" prefix="og: http://ogp.me/ns#">
<head>
<meta charset="UTF-8">
<title><sitemesh:write property='title'>Sistema de información sobre biodiversidad de Uruguay</sitemesh:write></title>
<link rel="stylesheet" href="/explorer/assets/styles/common.css" media="screen,print">
<!--<link rel="shortcut icon" href="http://data.canadensys.net/common/images/favicon.png"/>-->

<!-- jQuery 2.1.3 -->
<script type="text/javascript" src="/explorer/assets/js/jquery/jQuery-2.1.3.min.js" ></script>
<!-- jquery-ui 1.10.3 -->
<script type="text/javascript" src="/explorer/assets/js/jqueryui/jquery-ui-1.10.3.min.js" ></script>
        
<sitemesh:write property='head'/>
<#include "/WEB-INF/view/inc/ga.ftl">
</head>
<body class="skin-red sidebar-collapse">
    <div class="wrapper">
        <div id="skip-link">
            <a href="#main-content" class="skipnav">${rc.getMessage("header.skip")}</a>
        </div>
        <#if feedbackURL?? && feedbackURL?has_content>
        <div id="feedback_bar"><a href="${feedbackURL}" target="_blank" title="${rc.getMessage("feedback.hover")}">&nbsp;</a></div>
        </#if>
        <#include "include/header-div_bootstrap.ftl">

        <#include "include/navigation.ftl">

        <sitemesh:write property='body'/>
        <#include "include/footer.ftl">
        <sitemesh:write property='page.local_script'/>
    </div>
    
    
    <!-- Bootstrap Adaptation -->

        <link rel="stylesheet" type="text/css" href="/explorer/assets/styles/bootstrap/css/bootstrap_adaptation.css" >

        <!-- Bootstrap 3.3.2 -->

        <link rel="stylesheet" type="text/css" href="/explorer/assets/styles/bootstrap/css/bootstrap.min.css" >

        <!-- Font Awesome Icons -->

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

        <!-- Ionicons -->

        <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />

        <!-- Theme style -->

        <link rel="stylesheet" type="text/css" href="/explorer/assets/styles/dist/css/AdminLTE.min.css" >

        <link rel="stylesheet" type="text/css" href="/explorer/assets/styles/dist/css/skins/skin-red.min.css" >
        
        <!-- Bootstrap 3.3.2 JS -->

        <script type="text/javascript" src="/explorer/assets/styles/bootstrap/js/bootstrap.min.js" ></script>

        <!-- AdminLTE App -->

        <script src="/explorer/assets/styles/dist/js/app.min.js" type="text/javascript"></script>
        
</body>
</html>
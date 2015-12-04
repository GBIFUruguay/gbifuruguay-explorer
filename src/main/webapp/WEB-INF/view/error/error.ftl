<#ftl strip_whitespace=true>
<#include "../inc/functions.ftl">
<#include "../inc/global-functions.ftl">
<head>
<title>${rc.getMessage("cwt.error.title")}</title>
<@cssAsset fileName="occportal" version=(page.currentVersion)! useMinified=false/>
</head>
<div id="body" style="min-height: 269px;">
	<div id="content" class="no_side_bar">
		<h1>${rc.getMessage("cwt.error.title")}</h1>
		<p>${rc.getMessage("cwt.error.message")}
		<#if feedbackURL?? && feedbackURL?has_content>
			<a href="${feedbackURL}" target="_blank">${rc.getMessage("cwt.error.message.linkpart")}</a>
		<#else>
			${rc.getMessage("cwt.error.message.linkpart")}
		</#if>
		.</p>
	</div>
</div>

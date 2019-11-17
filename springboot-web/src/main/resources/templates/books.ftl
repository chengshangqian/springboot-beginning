<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编程语言书籍列表</title>
</head>
<body>
<table>
<thead>
<tr><th>编号</th><th>作者</th><th>书名</th><th>价格</th></tr>
</thead>
<tbody>
<#if books ??&& (books ? size > 0)>
<#list books as book>
<tr>
	<td>${book.id}</td>
	<td>${book.author}</td>
	<td>${book.name}</td>
	<td>${book.price}</td>
	
</tr>
</#list>
</#if>
</tbody>
</table>
</body>
</html>
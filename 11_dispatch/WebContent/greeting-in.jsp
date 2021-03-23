<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="Bean.BookBean" %>
<%@page import="java.util.Arrays" %>
<% BookBean bbean=(BookBean)session.getAttribute("bookdata");
	if(bbean == null){
		bbean = new BookBean();
		bbean.setGenreList(Arrays.asList(new String[] {"","","","",""}));
	}
%>

<%String erors = bbean.getErrorMsg();%>
<!DOCTYPE html>
<html>
<head>
    <title>書籍登録画面</title>
</head>

<body>
    <h2>■書籍在庫管理システム</h2>
    <h2><%=bbean.getErrorMsg()==null? "":bbean.getErrorMsg()%></h2>
        <h3>　【書籍登録画面】</h3>
        
        
        <form action="http://localhost:8080/11_dispatch/kadai11/sts"　method="Get">
            <table>
                <tr><td>　　</td><td>タイトル</td><td><input type="text" name="title" value="<%= bbean.getTitle()%>" /></td></tr>
                <tr><td></td><td>著者</td><td><input type="text" name="writer" value="<%=bbean.getWritter()%>" /></td></tr>
                <tr><td></td><td>出版社</td><td><input type="text" name="publisher" value="<%=bbean.getPublisher()%>" /></td></tr>
                <tr><td></td><td>価格</td><td><input type="text" name="price" value="<%=bbean.getPrice()%>" /></td></tr>
                <tr><td></td><td>ジャンル</td><td>
                    <input type="checkbox" name="genre" value="0" <%=bbean.getGenreList().get(0) %>/>文芸
                    <input type="checkbox" name="genre" value="1" <%=bbean.getGenreList().get(1) %>/>実用
                    <input type="checkbox" name="genre" value="2" <%=bbean.getGenreList().get(2) %>/>ビジネス
                    <input type="checkbox" name="genre" value="3" <%=bbean.getGenreList().get(3) %>/>教養
                    <input type="checkbox" name="genre" value="4" <%=bbean.getGenreList().get(4) %>/>趣味</td></tr>
                <tr><td></td><td>在庫</td><td>
                    <input type="radio" name="stock" value="1" <%=bbean.isStock()?"checked":"" %>/>あり
                    <input type="radio" name="stock" value="0" <%=bbean.isStock()? "":"checked"%>/>なし</td></tr>
                <tr><td></td><td>備考</td><td><textarea name="remarks" cols="40" rows="4"></textarea></td></tr>
                <tr><td></td><td height="30"></td><td></td></tr>
                <tr><td></td><td></td><td align="right">
                    <input type="submit" value="登録" /></td></tr>
            </table>
        </form>
</body>
</html>
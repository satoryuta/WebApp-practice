<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="Bean.BookBean" %>
<% BookBean bbean=(BookBean)request.getAttribute("bookdata");%>

<!-- 正常入力時の確認画面のjsp -->
<!DOCTYPE html>
<html>
<head>
    <title>書籍登録画面</title>
</head>

<body>
    <h2>■書籍在庫管理システム</h2>
        <h3>　【書籍登録画面】</h3>
         <form action="<%=request.getContextPath()%>/greeting-in.jsp">
            <table>
                <tr><td>　　</td><td>タイトル</td><td><input type="text" name="title" disabled="disabled" value="<%=bbean.getTitle()%>" /></td></tr>
                <tr><td></td><td>著者</td><td><input type="text" name="writer" disabled="disabled" value="<%=bbean.getWritter()%>" /></td></tr>
                <tr><td></td><td>出版社</td><td><input type="text" name="publisher" disabled="disabled" value="<%=bbean.getPublisher()%>" /></td></tr>
                <tr><td></td><td>価格</td><td><input type="text" name="price" disabled="disabled" value="<%=bbean.getPrice()%>" /></td></tr>
                <tr><td></td><td>ジャンル</td><td>
                    <input type="checkbox" name="genre" value="0" disabled="disabled" "  <%=bbean.getGenreList().get(0) %>/>文芸
                    <input type="checkbox" name="genre" value="1" disabled="disabled" "  <%=bbean.getGenreList().get(1) %>/>実用
                    <input type="checkbox" name="genre" value="2" disabled="disabled" "  <%=bbean.getGenreList().get(2) %>/>ビジネス
                    <input type="checkbox" name="genre" value="3" disabled="disabled" "  <%=bbean.getGenreList().get(3) %>/>教養
                    <input type="checkbox" name="genre" value="4" disabled="disabled" "  <%=bbean.getGenreList().get(4) %>/>趣味</td></tr>
                <tr><td></td><td>在庫</td><td>
                    <input type="radio" name="stock" value="1"<%=bbean.isStock()?"checked":"" %>/>あり
                    <input type="radio" name="stock" value="0" <%=bbean.isStock()? "":"checked"%>/>なし</td></tr>
                    
                <tr><td></td><td>備考</td><td><textarea name="remarks" cols="40" rows="4"><%=bbean.getRemarks() %></textarea></td></tr>
                <tr><td></td><td height="30"></td><td></td></tr>
                <tr><td></td><td></td><td align="right">
                    <input type="submit" value="キャンセル" /></td></tr>
            </table>
        </form>
</body>
</html>

# サーブレットとJSPを使った課題

### 開発環境
* JDK（AdoptOpenJDK 8.0.202.08）​

* Tomcat(9.0.19）​

* Eclipse（2018-09 (4.9.0)）


#### 参考書籍
* 基礎からのサーブレット/JSP　新版

## awsを使いデプロイ(AWS Elastic Beanstalkを使用)
###### 以下のリンクから確認できます

* 1_index
Webアプリのフォルダ構成（こちらはフォルダ構成の確認だけのためリンクはないです）

* [2_test_servlet](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/2_test_servlet/HelloServlet)
サーブレットの動作確認
* [3_status](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/3_status/sts)
URL指定時にランダムでステータス(very good/bad/good/very bad）を表示
* [3_2_charcode](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/3_2_charcode/sts)
文字コードの設定
・setContentTypeで文字コードUTF-8​、ファイル保存時の文字コードUTF-8​
→文字化けなし
setContetTypeで文字コードUTF-8​、ファイル保存時の文字コードShift-JIS​
→文字化けあり

* [4_htmloutput](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/4_htmloutput/kadai4/sts)
  ランダム文字列を生成し、「白い」が含まれるときは表示される文字色を白に「赤い」が含まれるときは文字色を赤で出力。（白いが含まれる時は背景色と同化し文字は見えません）
* [5_entry](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/5_entry/hello.jsp)
JSPの作成
JSPは「スクリプトレット、暗黙的オブジェクト、ディレクティブ」
* [6_jsp](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/6_jsp/omojan.jsp)
4_htmloutputの内容をjspを使って作成
今回はservretを使用しない

* [7_contextpath](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/7_contextpath/servlet/Hello)
JSP＋サーブレットでコンテキストのパス指定​
* [8_addpagelogic](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/8_addpagelogic/greeting-in.jsp)
JSP＋サーブレットで役割分担
書籍登録画面（JSP）から受け取った結果を表示（サーブレット）する
* [9_addpagelogic2](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/9_addpagelogic2/pages/greeting-in.jsp)
8_addpagelogicに処理を追加
JSPでの入力内容を表示される（各入力項目の操作不能）

* [10_addpagevalidate](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/10_addpagevalidate/greeting-in.jsp)
9_addpagelogic2に処理追加
入力項目のエラーチェック（validate)
validate(チェック内容）
・「タイトル」は必須入力
・「著者」は１０文字以内
・「価格」は数値入力（マイナス不可）
・「ジャンル」は1つ以上3つ以下選択

* [11_dispatch](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/11_dispatch/greeting-in.jsp)
10_addpagevalidate
今回はフォワードを使用
JSP→サーブレット→JSPへ画面遷移
受け渡す値をBeanを使って管理

* [13_session](http://testserver-env.eba-fd8mjnqp.us-east-1.elasticbeanstalk.com/13_session/greeting-in.jsp)
11_dispatchを改良
セッションを使い、値を受け渡し

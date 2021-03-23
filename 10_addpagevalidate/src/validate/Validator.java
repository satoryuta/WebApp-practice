package validate;


public class Validator {

    StringBuffer errors;

    public Validator() {
        errors = new StringBuffer();
    }

    /**
     * 必須チェック
     */
    public boolean requireCheck(String title, String writer,String price,String genre[]) {
        boolean result = true;
        
        int priceint ;
        int cnt = 0;
        
        
        if(title.length() == 0) {
            errors.append("■タイトルは必須入力です。<br>");
        	result = false;
        }else {
        	System.out.print("エラー");
        }
        
        if(writer.length() > 10) {	
        	errors.append("■著者は10文字以内です。<br>");
        	result = false;
        }
		
        try {
        	priceint = Integer.parseInt(price,10);
            if (priceint < 0) {
            	errors.append("■価格は0以上です<br>");
            	result = false;
            }
        }catch(NumberFormatException e) {
        	if(price.length() != 0) {
        		errors.append("■価格は数値入力です<br>");
            	result = false;
        	}
        }
        
    		
		if(genre == null) 
		{
			cnt = -1;
		}else {
			if (genre.length >= 4 ) {
				errors.append("■ジャンルの選択は3つまでです。<br>");
				result = false;
			}
			try {
				cnt = Integer.parseInt(genre[0]);
			}catch(NullPointerException e) {
				cnt = -1;
			}
		}	
		if (cnt == -1) {
			errors.append("■ジャンルが未選択です<br>");
			result = false;
		}        
  
		//*	try {
		//priceint = Integer.parseInt(price,10);
		//}catch(NumberFormatException e) {
		//}
		//try{なんか変数　 = 文字を取得.parseInt(それ);}
		//if(マイナス判定)
		//catch(文字の場合はparseでintにへんかんできないのでエラーがでる) {
		//こっちで値を返
		//}
        
        return result;
    }
    
    public String errorsResult() {
    	String rederrors = errors.toString();
    	rederrors = String.format("<font color=\"red\">%s</font>",rederrors);
    	return rederrors;
    }
    

    
    
    
}

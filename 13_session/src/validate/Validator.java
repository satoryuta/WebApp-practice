package validate;

import java.util.List;

public class Validator {

    StringBuffer errors;

    public Validator() {
        errors = new StringBuffer();
    }

    /**
     * 必須チェック
     */
    public boolean requireCheck(String title, String writer,String price,Integer genre_cnt) {
        boolean result = true;
        
        int priceint ;
        int cnt = 0;
        
        
        if(title.length() == 0) {
            errors.append("■タイトルは必須入力です。<br>");
        	result = false;
        }
        
        if(writer.length() > 10) {	
        	errors.append("■著者は10文字以内で入力してください。<br>");
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
        
    		
        if (genre_cnt == 0 ) {
        	errors.append("■ジャンルが未選択です<br>");
			result = false;
        } else if (genre_cnt >= 4) {
        	errors.append("■ジャンルの選択は3つまでです。<br>");
			result = false;
        }
        
        
        
	    
        return result;
    }
    
    public String errorsResult() {
    	String rederrors = errors.toString();
    	rederrors = String.format("<font color=\"red\">%s</font>",rederrors);
    	return rederrors;
    }
}
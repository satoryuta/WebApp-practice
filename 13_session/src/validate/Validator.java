package validate;

import java.util.List;

public class Validator {

    StringBuffer errors;

    public Validator() {
        errors = new StringBuffer();
    }

    /**
     * �K�{�`�F�b�N
     */
    public boolean requireCheck(String title, String writer,String price,Integer genre_cnt) {
        boolean result = true;
        
        int priceint ;
        int cnt = 0;
        
        
        if(title.length() == 0) {
            errors.append("���^�C�g���͕K�{���͂ł��B<br>");
        	result = false;
        }
        
        if(writer.length() > 10) {	
        	errors.append("�����҂�10�����ȓ��œ��͂��Ă��������B<br>");
        	result = false;
        }
		
        try {
        	priceint = Integer.parseInt(price,10);
            if (priceint < 0) {
            	errors.append("�����i��0�ȏ�ł�<br>");
            	result = false;
            }
        }catch(NumberFormatException e) {
        	if(price.length() != 0) {
        	errors.append("�����i�͐��l���͂ł�<br>");
        	result = false;
        	}
        }
        
    		
        if (genre_cnt == 0 ) {
        	errors.append("���W�����������I���ł�<br>");
			result = false;
        } else if (genre_cnt >= 4) {
        	errors.append("���W�������̑I����3�܂łł��B<br>");
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
package validate;


public class Validator {

    StringBuffer errors;

    public Validator() {
        errors = new StringBuffer();
    }

    /**
     * �K�{�`�F�b�N
     */
    public boolean requireCheck(String title, String writer,String price,String genre[]) {
        boolean result = true;
        
        int priceint ;
        int cnt = 0;
        
        
        if(title.length() == 0) {
            errors.append("���^�C�g���͕K�{���͂ł��B<br>");
        	result = false;
        }else {
        	System.out.print("�G���[");
        }
        
        if(writer.length() > 10) {	
        	errors.append("�����҂�10�����ȓ��ł��B<br>");
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
        
    		
		if(genre == null) 
		{
			cnt = -1;
		}else {
			if (genre.length >= 4 ) {
				errors.append("���W�������̑I����3�܂łł��B<br>");
				result = false;
			}
			try {
				cnt = Integer.parseInt(genre[0]);
			}catch(NullPointerException e) {
				cnt = -1;
			}
		}	
		if (cnt == -1) {
			errors.append("���W�����������I���ł�<br>");
			result = false;
		}        
  
		//*	try {
		//priceint = Integer.parseInt(price,10);
		//}catch(NumberFormatException e) {
		//}
		//try{�Ȃ񂩕ϐ��@ = �������擾.parseInt(����);}
		//if(�}�C�i�X����)
		//catch(�����̏ꍇ��parse��int�ɂւ񂩂�ł��Ȃ��̂ŃG���[���ł�) {
		//�������Œl���
		//}
        
        return result;
    }
    
    public String errorsResult() {
    	String rederrors = errors.toString();
    	rederrors = String.format("<font color=\"red\">%s</font>",rederrors);
    	return rederrors;
    }
    

    
    
    
}

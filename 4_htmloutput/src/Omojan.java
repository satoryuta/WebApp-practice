import java.util.Random;

public class Omojan {
	final static String[] words = new String[]{
			"�V���[��p","�U�N","�͂��߂Ă�","�`���[",
			"�ɓ���","�Ȃ���","����Ȃ�","�O�p","���͂悤",
			"101��ڂ�","�v���|�[�Y","�r������","80�L��",
			"�o����","�s���`�ł�","����","�Ԃ�",
	};
	
	private String getSingleWord(){
		int index =new Random().nextInt(words.length);
		return words[index];
		
		

	}
	
	public String getWord(){

		String word = getSingleWord() + " " + getSingleWord();
		if (word.indexOf("����") != -1){
			word = String.format("<font color=\"white\">%s</font>",word);
		}else if(word.indexOf("�Ԃ�") != -1){
			word = String.format("<font color=\"red\">%s</font>",word);
		}
		return word;
	}
}
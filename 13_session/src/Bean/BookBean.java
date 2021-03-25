package Bean;

import java.util.Arrays;
import java.util.List;

/**
 * ����Bean�N���X
 * 
 * @author t.kawana
 *
 */
public class BookBean extends BaseBean {
	
	// �^�C�g��
	String title = "";
	// ����
	String writter = "";
	// �o�Ŏ�
	String publisher = "";
	// ���i
	String price ="";
	// �W������
	List<String> genreList = Arrays.asList(new String[] {"","","","",""});
	// �݌�
	boolean stock = true;
	// ���l
	String remarks = "";
	
	//�G���[
	
	
	
	/**
	 * �^�C�g���擾
	 * 
	 * @return �^�C�g��
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * �^�C�g���ݒ�
	 * 
	 * @param title �^�C�g��
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * ���Ҏ擾
	 * 
	 * @return ����
	 */
	public String getWritter() {
		return writter;
	}
	
	/**
	 * ���Ґݒ�
	 * 
	 * @param writter ����
	 */
	public void setWritter(String writter) {
		this.writter = writter;
	}
	
	/**
	 * �o�ŎЎ擾
	 * 
	 * @return �o�Ŏ�
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * �o�ŎАݒ�
	 * 
	 * @param publisher �o�Ŏ�
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * ���i�擾
	 * 
	 * @return ���i
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * ���i�ݒ�
	 * 
	 * @param price ���i
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * �W�������擾
	 * 
	 * @return �W������
	 */
	public List<String> getGenreList() {
		return genreList;
	}
	
	/**
	 * �W�������ݒ�
	 * 
	 * @param genreList �W������
	 */
	public void setGenreList(List<String> genreList) {
		this.genreList = genreList;
	}
	
	/**
	 * �݌ɗL������
	 * 
	 * @return �݌ɗL���ifalse�F�Ȃ��Atrue�F����j
	 */
	public boolean isStock() {
		return stock;
	}
	
	/**
	 * �݌ɗL���ݒ�
	 * 
	 * @param stock �݌ɗL���ifalse�F�Ȃ��Atrue�F����j
	 */
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	
	/**
	 * ���l�擾
	 * 
	 * @return ���l
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * ���l�ݒ�
	 * 
	 * @param remarks ���l
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

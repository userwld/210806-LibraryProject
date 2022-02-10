package allDTO;

import java.sql.Date;

public class RentalDTO {
	private int num;
	private String id;
	private String bookname;
	private Date rentaldate;
	private Date returndate;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Date getRentaldate() {
		return rentaldate;
	}
	public void setRentaldate(Date rentaldate) {
		this.rentaldate = rentaldate;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	
}


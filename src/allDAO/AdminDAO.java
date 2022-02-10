/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package allDAO;


public class AdminDAO {
	private int num;
    private String name;
    private String author;
    private String genre;
    private String day;
    private String map;
    private String review;
    private int good;
    private String img;
    private String nation;
    private String story;
    private int total;
    
	public AdminDAO(int num, String name, String author, String genre, String day, String map, 
			String review ,int good,String img, String nation,String story, int total) {
		this.num = num;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.day = day;
		this.map = map;
		this.review = review;
		this.good = good;
		this.img = img;
		this.nation = nation;
		this.story = story;
		this.total = total;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	

	public String getAuthor() {
		return author;
	}

	

	public String getGenre() {
		return genre;
	}



	public String getDay() {
		return day;
	}

	

	public String getMap() {
		return map;
	}
	
	public String getReview() {
		return review;
	}

	

	public int getGood() {
		return good;
	}

	

	public String getImg() {
		return img;
	}

	public String getNation() {
		return nation;
	}
	public String getStory() {
		return story;
	}

	public int getTotal() {
		return total;
	}

	
    
	
    
    

}


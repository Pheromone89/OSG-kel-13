package kelompok.tiga.osgk3.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserResponse {

	@SerializedName("per_page")
	private int perPage;

	@SerializedName("total")
	private int total;

	@SerializedName("data")
	private List<Data> data;

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	public int getPerPage(){
		return perPage;
	}

	public int getTotal(){
		return total;
	}

	public List<Data> getData(){
		return data;
	}

	public int getPage(){
		return page;
	}

	public int getTotalPages(){
		return totalPages;
	}

}
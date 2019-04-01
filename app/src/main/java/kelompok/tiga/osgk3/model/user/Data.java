package kelompok.tiga.osgk3.model.user;


import android.widget.ImageView;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import androidx.databinding.BindingAdapter;

public class Data{

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("id")
	private int id;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("first_name")
	private String firstName;


	public String getLastName(){
		return lastName;
	}



	public int getId(){
		return id;
	}



	public String getAvatar(){
		return avatar;
	}

	@BindingAdapter({"avatar"})
	public static void loadImage(ImageView view, String imageUrl){
		Picasso.get()
				.load(imageUrl)
				.into(view);
	}

	public String getFirstName(){
		return firstName;
	}
}
import com.google.gson.annotations.SerializedName

data class FlutterWaveSender (

	@SerializedName("FullName") val fullName : String,
	@SerializedName("FirstName") val firstName : String,
	@SerializedName("LastName") val lastName : String,
	@SerializedName("Country") val country : String,
	@SerializedName("State") val state : String,
	@SerializedName("Address1") val address1 : String,
	@SerializedName("PhoneNo") val phoneNo : String
)
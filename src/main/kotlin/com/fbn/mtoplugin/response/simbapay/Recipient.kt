import com.google.gson.annotations.SerializedName

data class Recipient (

	@SerializedName("name") val name : String,
	@SerializedName("mobile") val mobile : String,
	@SerializedName("address1") val address1 : String,
	@SerializedName("city") val city : String,
	@SerializedName("state") val state : String,
	@SerializedName("postCode") val postCode : String,
	@SerializedName("country") val country : String,
	@SerializedName("idNumber") val idNumber : String,
	@SerializedName("idExpiry") val idExpiry : String
)
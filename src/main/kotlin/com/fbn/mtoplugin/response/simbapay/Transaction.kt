import com.google.gson.annotations.SerializedName

data class Transaction (

	@SerializedName("sendAmount") val sendAmount : Double,
	@SerializedName("receiveAmount") val receiveAmount : Double,
	@SerializedName("sendCurrency") val sendCurrency : String,
	@SerializedName("receiveCurrency") val receiveCurrency : String,
	@SerializedName("status") val status : String,
	@SerializedName("transRef") val transRef : String
)
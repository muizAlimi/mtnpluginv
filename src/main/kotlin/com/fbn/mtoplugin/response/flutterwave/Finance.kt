import com.google.gson.annotations.SerializedName


data class Finance (

	@SerializedName("SendAmount") val sendAmount : Int,
	@SerializedName("SendCurrency") val sendCurrency : String,
	@SerializedName("ReceiveAmount") val receiveAmount : Int,
	@SerializedName("ReceiveCurrency") val receiveCurrency : String,
	@SerializedName("ExchangeRate") val exchangeRate : Int
)
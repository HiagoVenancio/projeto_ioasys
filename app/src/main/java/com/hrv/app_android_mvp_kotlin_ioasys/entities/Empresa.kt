import com.google.gson.annotations.SerializedName
import com.hrv.app_android_mvp_kotlin_ioasys.entities.TipoEmpresa
import java.io.Serializable

class Empresa(
    @SerializedName("id") var id: Int=0,
    @SerializedName("enterprise_name") var enterprise_name: String="",
    @SerializedName("description") var description: String="",
    @SerializedName("email_enterprise") var email_enterprise: String="",
    @SerializedName("facebook") var facebook: String="",
    @SerializedName("twitter") var twitter: String="",
    @SerializedName("linkedin") var linkedin: String="",
    @SerializedName("phone") var phone: String="",
    @SerializedName("own_enterprise") var own_enterprise: String="",
    @SerializedName("photo") var photo: String="",
    @SerializedName("value") var value: Int=0,
    @SerializedName("shares") var shares: Int=0,
    @SerializedName("share_price") var share_price: Double=0.0,
    @SerializedName("own_shares") var own_shares: Int=0,
    @SerializedName("city") var city: String="",
    @SerializedName("country") var country: String="",
    @SerializedName("enterprise_type") var enterprise_type: TipoEmpresa,
    @SerializedName("enterprise") var enterprise: String="",
    @SerializedName("success") var success: String=""
) : Serializable

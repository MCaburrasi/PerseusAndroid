package segundo.caburrasi.marcos.perseus.network

import coil3.Image
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import segundo.caburrasi.marcos.perseus.data.ConfigUtils
import segundo.caburrasi.marcos.perseus.data.ImageID
import java.io.File
import kotlin.getValue

private var BASE_URL = "http://" + ConfigUtils.getProperty("ip").toString() + ":8000/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface PhotoAPIService {
    @OptIn(InternalSerializationApi::class)
    @POST("uploadimage/")
    suspend fun postPhoto(@Body img: ByteArray, @Body type: String, @Body id: Int)

    @OptIn(InternalSerializationApi::class)
    @GET("getimage/?type=pfp&id=sentId")
    suspend fun getPfp(@Query("sentId") id: Int): Image

    @OptIn(InternalSerializationApi::class)
    @GET("getimage/")
    suspend fun getBanner(@Body id: Int): Image

    @OptIn(InternalSerializationApi::class)
    @GET("getimage/")
    suspend fun getPost(@Body id: Int): Image

    @OptIn(InternalSerializationApi::class)
    @GET("getimage/")
    suspend fun getEvent(@Body id: Int): Image
}

object PhotoAPI {
    val retrofitService: PhotoAPIService by lazy {
        retrofit.create(PhotoAPIService::class.java)
    }
}
package segundo.caburrasi.marcos.perseus.data

import android.app.Activity
import android.content.Context
import java.io.FileOutputStream
import java.util.Properties

private const val CONFIG = "client.properties"

object ConfigUtils{
    private val properties = Properties()

    fun init(context: Context) {
        properties.load(context.assets.open(CONFIG))
    }

    fun getProperty(key: String): String = properties.getProperty(key)

    fun setIp(ip: String){
        properties.setProperty("ip", ip)
    }
}
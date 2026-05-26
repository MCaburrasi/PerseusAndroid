package segundo.caburrasi.marcos.perseus

import android.R.attr.port
import androidx.annotation.Nullable
import kotlinx.serialization.BinaryFormat
import java.io.BufferedReader
import java.io.InputStream
import java.io.OutputStream
import java.net.Socket
import java.util.Scanner
import kotlin.concurrent.thread

class Client(address: String, port: Int) {
    private var connection: Socket = Socket(address, port)
    private var connected: Boolean = false

    private var answer: String = ""
    private var answered: Boolean = false

    private val reader: BufferedReader = BufferedReader(connection.inputStream.reader())
    private val writer: OutputStream = connection.getOutputStream()

    fun run(){
        connected = true
        println("Succesful connection to ${connection.port}")
        thread { read() }
    }

    fun write(message: String): String{
        if ("exit" in message){
            connected = false
            reader.close()
            connection.close()
        }
        writer.write((message + '\n').toByteArray())

        while (!answered){
            println("Waiting")
        }

        answered = false
        return answer.substring(1, answer.length - 1)

    }
    private fun read(){
        while (connected){
            answer = reader.readLine()
            answered = true
        }
    }
}

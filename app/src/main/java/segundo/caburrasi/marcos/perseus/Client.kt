package segundo.caburrasi.marcos.perseus

import java.io.OutputStream
import java.net.Socket
import java.util.Scanner
import kotlin.concurrent.thread

class Client(address: String, port: Int) {
    private var connection: Socket = Socket(address, port)
    private var connected: Boolean = true

    fun init() {
        println("Succesful connection to ${connection.port}")
    }

    private val reader: Scanner = Scanner(connection.getInputStream())
    private val writer: OutputStream = connection.getOutputStream()

    fun run(){
        thread { read() }
    }

    fun write(message: String){
        if ("exit" in message){
            connected = false
            reader.close()
            connection.close()
        } else if (message != ""){
            writer.write((message + '\n').toByteArray())
        }

    }
    private fun read(){
        while (connected){
            println(reader.nextLine())
        }
    }
}

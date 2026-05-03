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
        while (connected){
            val input = readlnOrNull() ?: ""
            if ("exit" in input){
                connected = false
                reader.close()
                connection.close()
            } else if (input != ""){
                write(input)
            }
        }
    }

    private fun write(message: String){
        writer.write((message + '\n').toByteArray())
    }
    private fun read(){
        while (connected){
            println(reader.nextLine())
        }
    }
}

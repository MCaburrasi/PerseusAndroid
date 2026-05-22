package segundo.caburrasi.marcos.perseus

import kotlinx.serialization.BinaryFormat
import java.io.OutputStream
import java.net.Socket
import java.util.Scanner
import kotlin.concurrent.thread

class Client(address: String, port: Int) {
    private var connection: Socket = Socket(address, port)
    private var connected: Boolean = true

    private var answer: String = ""
    private var answered: Boolean = false

    private val reader: Scanner = Scanner(connection.getInputStream())
    private val writer: OutputStream = connection.getOutputStream()

    fun run(){
        thread { read() }
        println("Succesful connection to ${connection.port}")
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
            answer = reader.nextLine()
            answered = true
        }
    }
}

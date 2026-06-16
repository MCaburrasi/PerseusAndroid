package segundo.caburrasi.marcos.perseus

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.internal.wait
import okio.Timeout
import segundo.caburrasi.marcos.perseus.ui.PerseusViewModel
import java.io.BufferedReader
import java.io.OutputStream
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketAddress
import kotlin.concurrent.thread
import kotlin.concurrent.timer

@OptIn(DelicateCoroutinesApi::class)
class Client (
    address: String = "",
    port: Int = 0,
    viewModel: PerseusViewModel
) {
    private val viewModel = viewModel

    private var connection: Socket? = null
    private var connected: Boolean = false

    private var answer: String = ""
    private var answered: Boolean = false

    private var reader: BufferedReader? = null
    private var writer: OutputStream? = null


    init {
        connection = Socket()
        connection?.connect(InetSocketAddress(address, port), 2000)
        reader = BufferedReader(connection?.inputStream?.reader())
        writer = connection?.getOutputStream()
    }

    fun run(){
        connected = true
        println("Succesful connection to ${connection?.port}")
        thread { read() }
    }

    fun write(message: String): String {
        if ("exit" in message){
            connected = false
            reader?.close()
            connection?.close()
        }

        writer?.write((message + '\n').toByteArray())

        while (!answered && (!message.startsWith("Add") && !message.startsWith("login"))){
            //println("Waiting")
        }

        answered = false
        return answer

    }
    private fun read(){
        while (connected){
            answer = reader?.readLine().toString()
            answered = true
        }
    }
}

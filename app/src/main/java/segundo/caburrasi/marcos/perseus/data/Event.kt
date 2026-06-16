package segundo.caburrasi.marcos.perseus.data

import java.time.LocalDateTime

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val place: String,
    val image: String,
    val author: String,
    var showEvent: Boolean
) {
    fun setShowEvent(){
        showEvent = !showEvent
    }
}

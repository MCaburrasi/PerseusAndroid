package segundo.caburrasi.marcos.perseus.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.window.DialogWindowProvider
import androidx.compose.ui.window.Popup
import segundo.caburrasi.marcos.perseus.R
import java.sql.Time
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.min

var localStartDate: LocalDate? = null
var localEndDate: LocalDate? = null
var localStartTime: LocalTime? = null
var localEndTime: LocalTime? = null

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewEventScreen(
    modifier: Modifier = Modifier,
    viewModel: PerseusViewModel
){
    var localNameText by remember{mutableStateOf(viewModel.uiState.value.newEventName)}
    var localDescText by remember{mutableStateOf(viewModel.uiState.value.newEventDesc)}
    var localPlaceText by remember{mutableStateOf(viewModel.uiState.value.newEventDesc)}
    var localStart: LocalDateTime = LocalDateTime.of(localStartDate?: LocalDate.now(), localStartTime?: LocalTime.now())
    var localEnd: LocalDateTime = LocalDateTime.of(localEndDate?: LocalDate.now(), localEndTime?: LocalTime.now())

    Box(Modifier.fillMaxWidth()) {
        Column(
            Modifier.align(Alignment.Center)
        ){
            TextField(
                value = localNameText,
                onValueChange = {newDescText -> localNameText = newDescText},
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.size(18.dp))

            TextField(
                value = localDescText,
                onValueChange = {newText -> localDescText = newText},
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.size(18.dp))

            TextField(
                value = localPlaceText,
                onValueChange = {newText -> localPlaceText = newText},
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.size(18.dp))

            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
            )

            Spacer(Modifier.size(18.dp))

            Row(Modifier
                .fillMaxWidth(0.95f)
                .align(Alignment.CenterHorizontally)
            ) {
                Column(Modifier.weight(0.5f)) {
                    PerseusDatePicker(Modifier, "Start date", true)
                    Spacer(Modifier.size(4.dp))
                    PerseusTimePicker(Modifier, "Start time", true)
                }

                Spacer(Modifier.size(12.dp))

                Column(Modifier.weight(0.5f)) {
                    PerseusDatePicker(Modifier, "End date", false)
                    Spacer(Modifier.size(4.dp))
                    PerseusTimePicker(Modifier, "End time", false)
                }
            }

            Spacer(Modifier.size(12.dp))

            Button(
                onClick = {
                    viewModel.uiState.value.client.write("Add|Event|$localNameText|$localDescText|$localStart|$localEnd|$localPlaceText|null")
                },
                Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(stringResource(R.string.app_name))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PerseusDatePicker(
    modifier: Modifier = Modifier,
    text: String,
    isStart: Boolean
){
    val datePickerState = rememberDatePickerState(
        initialSelectedDate = LocalDate.now(),

        )
    var showStartDatePicker by remember { mutableStateOf(false) }
    var selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    val date = selectedDate.split("/")
    if (isStart) localStartDate = LocalDate.of(date[2].toInt(), date[1].toInt(), date[0].toInt())
    else localEndDate = LocalDate.of(date[2].toInt(), date[1].toInt(), date[0].toInt())

    TextField(
        value = date[1] + "/" + date[0] + "/" + date[2],
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text) },
        placeholder = { Text("DD/MM/YYYY") },
        trailingIcon = {
            IconButton (onClick = {
                showStartDatePicker = true
            }) {
                Icon(Icons.Default.DateRange, contentDescription = "Select date")
            }
        }
    )

    if (showStartDatePicker){
        Popup(
            onDismissRequest = { showStartDatePicker = false },
        ) {
            Box(
                Modifier.background(Color.White)
            ){
                DatePicker(
                    state = datePickerState,
                    showModeToggle = false,
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .fillMaxHeight(0.65f)
                        .padding(12.dp)
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerseusTimePicker(
    modifier: Modifier = Modifier,
    text: String,
    isStart: Boolean
){
    val currentTime = Calendar.getInstance()
    val hour = currentTime.get(Calendar.HOUR_OF_DAY)
    val minute = currentTime.get(Calendar.MINUTE)
    if (isStart) localStartTime = LocalTime.of(hour, minute, 0)
    else localEndTime = LocalTime.of(hour, minute, 0)

    val timePickerState = rememberTimePickerState(
        initialHour = hour,
        initialMinute = minute,
    )
    var showStartTimePicker by remember { mutableStateOf(false) }

    TextField(
        value = "$hour:$minute",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text) },
        placeholder = { Text("MM/DD/YYYY") },
        trailingIcon = {
            IconButton (onClick = {
                showStartTimePicker = true
            }) {
                Icon(Icons.Default.DateRange, contentDescription = "Select date")
            }
        }
    )

    if (showStartTimePicker){
        Popup(
            onDismissRequest = {showStartTimePicker = false},

        ) {
            Box(
                Modifier
                    .background(Color.White)
                    .fillMaxWidth(0.75f)
                    .fillMaxHeight(0.45f)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            ) {
                TimePicker(
                    state = timePickerState,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}
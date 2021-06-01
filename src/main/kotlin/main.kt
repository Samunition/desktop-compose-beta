import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.application
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private val log = mu.KotlinLogging.logger {}

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val isLoading = mutableStateOf(true)
    application {
        MaterialTheme(lightTheme) {
            log.info("Drawing application")
            if (isLoading.value) {
                Splash()
                GlobalScope.launch {
                    log.info("Loading...")
                    delay(5000L)
                    isLoading.value = false
                    log.info("Loading complete")
                }
            } else {
                MainView()
            }
        }
    }
}

// fun app() {
//     val count = remember { mutableStateOf(0) }
//     val rectColour = MaterialTheme.colors.primary
//     Window(title = "My Window Title", icon = loadIconResource("pepega.png")) {
//         Surface {
//             Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
//                 Button(
//                     modifier = Modifier.align(Alignment.CenterHorizontally),
//                     onClick = { count.value++ }
//                 ) {
//                     Text(if (count.value == 0) "Hello World" else "Clicked ${count.value}!")
//                 }

//                 Button(
//                     modifier = Modifier.align(Alignment.CenterHorizontally),
//                     onClick = { count.value = 69 }
//                 ) {
//                     Text("Nice")
//                 }

//                 Canvas(Modifier.fillMaxSize()) {
//                     val rectWidth = size.width / 5F
//                     val rectHeight = size.height / 5F
//                     rotate(degrees = count.value * 10F) {
//                         drawRect(
//                             color = rectColour,
//                             topLeft = Offset(size.width / 2F - rectWidth / 2, size.height / 2F - rectHeight / 2),
//                             size = size / 5F
//                         )
//                     }
//                 }
//             }
//         }
//     }
// }

// val lightTheme = lightColors(
//     primary = Color(0xFF4C566A),
//     primaryVariant = Color(0xFF434C5E),
//     secondary = Color(0xFF8FBCBB),
//     secondaryVariant = Color(0xFF88C0D0),
//     background = Color(0xFF434C5E),
//     surface = Color(0xFF2E3440),
//     error = Color(0xFFBF616A),
//     onPrimary = Color(0xFF7CABBC),
//     onSecondary = Color(0xFFE5E9F0),
//     onBackground = Color(0xFFECEFF4),
//     onSurface = Color(0xFFECEFF4),
//     onError = Color.White
// )
val lightTheme = lightColors(
    primary = Color(0xFF44475A),
    primaryVariant = Color(0xFF6272A4),
    secondary = Color(0xFF50FA7B),
    secondaryVariant = Color(0xFF8BE9FD),
    background = Color(0xFF282A36),
    surface = Color(0xFF282A36),
    error = Color(0xFFFF5555),
    onPrimary = Color(0xFFF8F8F2),
    onSecondary = Color(0xFF282A36),
    onBackground = Color(0xFFF8F8F2),
    onSurface = Color(0xFFF8F8F2),
    onError = Color(0xFFF8F8F2)
)

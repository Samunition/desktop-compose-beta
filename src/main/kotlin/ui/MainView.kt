import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.delay
import androidx.compose.ui.graphics.Color

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun MainView() {
    Window(title = "My new fancier window", icon = loadIconResource("pepega.png"), initialAlignment = Alignment.Center) {
        Box {
            Row(Modifier.padding(bottom = 25.dp)) {
                sideBar()
                scrollableBody()
            }
            bottomBar(Modifier.align(Alignment.BottomCenter))
        }
    }
}

private fun loadIconResource(path: String): BufferedImage {
    val icon = Thread.currentThread().contextClassLoader.getResource(path)
    requireNotNull(icon) { "Icon $path not found" }
    return icon.openStream().use(ImageIO::read)
}

@Composable
fun sideBar() {
    Surface {
        Row {
            Column(Modifier.fillMaxHeight().width(250.dp).padding(10.dp), horizontalAlignment = Alignment.Start) {
                for (i in 1..10) Text("Side bar $i")
            }
            Divider(Modifier.fillMaxHeight().width(1.dp), MaterialTheme.colors.background)
        }
    }
}

@Composable
fun scrollableBody() {
    Surface() {
        Box(Modifier.fillMaxSize().padding(7.dp)) {
            val scrollState = rememberScrollState(0)
            Column(Modifier.verticalScroll(scrollState)) {
                for (i in 1..50) Text("Main body $i")
            }
            VerticalScrollbar(rememberScrollbarAdapter(scrollState), Modifier.align(Alignment.CenterEnd).fillMaxHeight())
        }
    }
}

@Composable
fun bottomBar(modifier: Modifier) {
    Row(modifier.fillMaxWidth().background(MaterialTheme.colors.primary), horizontalArrangement = Arrangement.SpaceBetween) {
        Row {
            Text("Tab Bar", Modifier.background(MaterialTheme.colors.secondary).padding(5.dp))
            Text("Tab 1", Modifier.background(MaterialTheme.colors.primaryVariant).padding(5.dp), color = MaterialTheme.colors.onPrimary)
            Text("Tab 2", Modifier.padding(5.dp), color = MaterialTheme.colors.onPrimary)
        }
        Row {
           liveTime(
               "E dd/MM HH:mm:ss", 
               Modifier.background(MaterialTheme.colors.primaryVariant).padding(5.dp), 
               MaterialTheme.colors.onPrimary
           ) 
        }
    }
}

@Composable
fun liveTime(format: String, modifier: Modifier, color: Color) {
    var time by remember { mutableStateOf(LocalDateTime.now()) }
    LaunchedEffect(0) {
       while (true) {
           time = LocalDateTime.now()
           delay(1000)
       }
    }
    Text(
        "${time.format(DateTimeFormatter.ofPattern(format))}", 
        modifier,
        color
    ) 

}

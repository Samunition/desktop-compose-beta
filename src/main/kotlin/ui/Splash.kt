import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun Splash() {
    Window(title = "My Window Title", icon = loadIconResource("pepega.png"), undecorated = true, initialAlignment = Alignment.Center) {
        Surface(Modifier.fillMaxSize()) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text("Loading...")
            }
        }
    }
}

private fun loadIconResource(path: String): BufferedImage {
    val icon = Thread.currentThread().contextClassLoader.getResource(path)
    requireNotNull(icon) { "Icon $path not found" }
    return icon.openStream().use(ImageIO::read)
}

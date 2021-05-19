import controller.GameController
import view.View

class Application {
}

fun main() {
    val gameController = GameController(View())
    gameController.gameStart();
}
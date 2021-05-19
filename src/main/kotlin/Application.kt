import controller.GameController
import exception.InvalidCarNameException
import view.View

class Application {
}

fun main() {
    val gameController = GameController(View())

    try {
        gameController.gameStart();
    } catch (e: IllegalArgumentException) {
        View().printInvalidGameInfo();
        gameController.gameStart();
    } catch (e: InvalidCarNameException) {
        View().printInvalidGameInfo()
        gameController.gameStart();
    }

}
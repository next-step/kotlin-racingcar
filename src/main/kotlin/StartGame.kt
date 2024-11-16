import ui.InputView

fun main() {
    val gameManager = GameManager()
    gameManager.inputView = InputView { readln() }
    gameManager.start()
}

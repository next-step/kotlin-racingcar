package racing

fun main() {
    val inputView = InputView()
    val carNumberInput = inputView.showCarInput()
    val turnNumberInput = inputView.showTurnInput()

    val game = Game()
    game.run(carNumberInput, turnNumberInput)
    game.clearCarList()
}

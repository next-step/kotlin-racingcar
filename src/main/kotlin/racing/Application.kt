package racing

fun main() {
    val carNumberInput = InputView().showCarInput()
    val turnNumberInput = InputView().showTurnInput()

    val game = Game()
    game.run(carNumberInput, turnNumberInput)
    game.clearResult()
}



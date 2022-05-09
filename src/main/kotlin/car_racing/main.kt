package car_racing

fun main() {
    val numCar: Int = InputView.numCar()
    val numMovement: Int = InputView.numMovement()

    ResultView.printTitle()
    val game = Game(numCar, numMovement)
    game.run()
}

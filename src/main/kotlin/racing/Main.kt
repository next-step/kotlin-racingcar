package racing

fun main() {
    val car = InputView.getCar()
    val round = InputView.getRound()
    val game = Game(carCount = car, roundCount = round, pedal = Pedal(4))
    game.start()
}

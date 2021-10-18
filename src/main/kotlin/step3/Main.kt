package step3

fun main() {
    val car = InputView.getCar()
    val round = InputView.getRound()
    val game = Game(carCount = car, roundCount = round, canMoveForward = canMoveForward, movingCondition = 4)
    game.start()
}

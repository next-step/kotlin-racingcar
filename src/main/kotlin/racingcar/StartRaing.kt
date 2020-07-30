package racingcar

fun main(args: Array<String>) {
    try {
        startRace()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun startRace() {
    val inputCarNum = InputView.readCarName()
    val inputMoveTime = InputView.readMoveTime()
    val game = Game(inputCarNum, inputMoveTime)
    while (!game.isEndGame()) {
        game.race()
        val result = ResultView(inputMoveTime - game.moveTime, game.cars)
        result.view()
        viewWinner(game, result)
    }
}

fun viewWinner(game: Game, result: ResultView) {
    if (game.isEndGame()) {
        result.viewWinner()
    }
}

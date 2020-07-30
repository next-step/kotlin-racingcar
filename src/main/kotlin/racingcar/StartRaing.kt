package racingcar

fun main(args: Array<String>) {
    try {
        val inputCarNum = InputView.readCarNum()
        val inputMoveTime = InputView.readMoveTime()
        val game = Game(inputCarNum, inputMoveTime)
        while (!game.isEndGame()) {
            game.race()
            val result = ResultView(inputMoveTime - game.moveTime, game.cars)
            result.view()
        }
    } catch (e: Exception) {
        println(e.message)
    }
}

package racingcar

fun main(args: Array<String>) {
    try {
        val inputCarNum = InputView.getCarNum()
        val inputMoveTime = InputView.getMoveTime()
        val game = Game(inputCarNum, inputMoveTime)
        while (!game.isEndGame()) {
            game.race()
            val result = ResultView(inputMoveTime - game.getMoveTime(), game.getCars())
            result.view()
        }
    } catch (e: Exception) {
        println(e.message)
    }
}

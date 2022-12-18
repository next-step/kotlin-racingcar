package racingcar.interfaces.ui.controller.console

object RacingCarOutputConsole {

    private const val RESULT_COMMENT = "처리 결과"
    private const val LITERAL_POSITION = "-"
    private const val NAME_DELIMITER = ": "

    fun initRace(data: List<Pair<String, Int>>) {
        println(RESULT_COMMENT)
        printCurrentData(data)
        println()
    }

    fun printCurrentData(data: List<Pair<String, Int>>) {
        data.forEach { (name: String, position: Int) ->
            printCurrentPosition(name = name, position = position)
        }
        println()
    }

    private fun printCurrentPosition(name: String, position: Int) {
        print("$name $NAME_DELIMITER")
        repeat(position) {
            print(LITERAL_POSITION)
        }
        println()
    }

    fun printWinners(winnerNames: List<String>) {
        println()
        println("우승자 발표")
        println("두구두구두구----")
        println()
        println("${winnerNames}가 최종 우승했습니다 !!!")
    }
}

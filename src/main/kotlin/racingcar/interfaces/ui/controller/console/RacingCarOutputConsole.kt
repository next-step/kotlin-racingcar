package racingcar.interfaces.ui.controller.console

object RacingCarOutputConsole {

    private const val RESULT_COMMENT = "처리 결과"
    private const val LITERAL_POSITION = "-"
    private const val NAME_DELIMITER = ": "

    fun printPrepareWin() {
        println("우승자 발표")
        println("두구두구두구----")
        println()
    }

    fun printNewLine() {
        println()
    }

    fun printPosition() {
        print(LITERAL_POSITION)
    }

    fun printWinners(winnerNames: List<String>) {
        println("${winnerNames}가 최종 우승했습니다 !!!")
    }

    fun printlnResult() {
        println(RESULT_COMMENT)
    }

    fun printName(name: String) {
        print("$name $NAME_DELIMITER")
    }
}

package racingcar.view

private const val STRING_JOINER = ", "

class WinnerView(private val winners: List<String>) {
    fun printResult() {
        val result = winners.joinToString(STRING_JOINER)
        println(">>>>> ${result}가 최종 우승했습니다. ")
    }
}

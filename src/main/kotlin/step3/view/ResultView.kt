package step3.view

object ResultView {

    private const val START_RACE_GAME = "실행 결과"
    private const val CAR_POSITION_MARK = "-"
    private const val EMPTY = ""

    fun printStartGame() = print(message = START_RACE_GAME)

    fun printCarsPosition(carsPosition: List<Int>) {
        carsPosition.forEach {
            println(it.mark())
        }

        println()
    }

    private fun Int.mark(): String {
        var result: String = EMPTY

        repeat(this) {
            result += CAR_POSITION_MARK
        }

        return result
    }
}

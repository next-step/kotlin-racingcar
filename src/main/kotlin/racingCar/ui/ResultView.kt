package racingCar.ui

object ResultView {

    private const val RESULT_MESSAGE = "실행 결과"
    private const val CAR_TRACK = "-"

    fun printResultMessage() {
        println(RESULT_MESSAGE)
    }

    fun printRaceResult(carMoves: List<CarMove>) {
        carMoves.forEach {
            val moveResult = CAR_TRACK.repeat(it.position)
            println(moveResult)
        }
        println(System.lineSeparator())
    }
}

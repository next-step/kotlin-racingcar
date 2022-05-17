package racingCar

object ResultView {
    fun show(raceResult: List<Int>) {
        println("Race 결과: ")
        println(convertDataToView(raceResult))
    }

    private fun convertDataToView(raceResult: List<Int>): String {
        return raceResult.joinToString(separator = "\n") { "-".repeat(it) }
    }
}

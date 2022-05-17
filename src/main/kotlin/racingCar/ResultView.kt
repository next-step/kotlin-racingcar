package racingCar

class ResultView() {
    fun show(carPositions: List<Int>) {
        println("RaceGame 결과: ")
        println(convertDataToView(carPositions))
    }

    private fun convertDataToView(carPositions: List<Int>): String {
        return carPositions.joinToString(separator = "\n") { "-".repeat(it) }
    }
}

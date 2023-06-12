class ResultView {

    companion object {
        const val DISPLAY_STRING = "-"
    }

    private fun resultMessage() {
        println("실행 결과")
    }

    private fun carsDistanceDisplay(distances: List<Int>) {
        distances.forEach { distance ->
            println(DISPLAY_STRING.repeat(distance))
        }
    }

    fun racingResultDisplay(distances: List<Int>) {
        resultMessage()
        carsDistanceDisplay(distances)
    }
}

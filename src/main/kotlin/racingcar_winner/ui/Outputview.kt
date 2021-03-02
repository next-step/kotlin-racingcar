package racingcar_winner.ui

class Outputview {

    fun printOneRound(progressCars: Map<String, Int>) {
        for (car in progressCars) {
            val progress = renderNumberToString(car.value)
            println("${car.key} : $progress")
        }
        println()
    }

    private fun renderNumberToString(progress: Int): String {
        var stringProgress = ""
        repeat(progress) { stringProgress += "-"}

        return stringProgress
    }
}
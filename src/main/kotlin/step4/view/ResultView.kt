package step4.view

import step4.Car

object ResultView {
    private const val CAR_NAME_SEPARATOR = " : "
    private const val ONE_BLOCK = "-"

    fun output(numberOfTrials: Int, cars: List<Car>) {
        for (i in 0 until numberOfTrials) {
            val actualTrial = i + 1

            println("trial$CAR_NAME_SEPARATOR$actualTrial")
            outputForTrials(actualTrial, cars)
        }
    }

    fun noticeWinner(cars: List<Car>): String {
        val arrangeCars = cars.sortedByDescending { car -> car.raceResult }

        var winner = arrangeCars[0].name

        for (i in 1 until arrangeCars.size) {
            if (arrangeCars[i].raceResult == arrangeCars[0].raceResult) {
                winner += ","
                winner += arrangeCars[i].name
            }
        }
        println("${winner}가 최종 우승했습니다.")

        return winner
    }

    private fun outputForTrials(actualTrial: Int, cars: List<Car>) {
        for (element in cars) {
            println("${element.name}$CAR_NAME_SEPARATOR" + visualize(actualTrial, element.raceHistory))
        }
    }

    fun visualize(numberOfTrials: Int, raceResult: List<Int>): String {
        var distance = 0

        for (i in 0 until numberOfTrials) {
            distance += raceResult[i]
        }
        return ONE_BLOCK.repeat(distance)
    }
}

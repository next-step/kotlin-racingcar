package racing

object RacingView {
    private const val DISPLAY_NUMBER = 1
    private const val HIGHEST_SCORE_INDEX = 1
    private const val GO_FORWARD = "-"
    private const val EMPTY_STRING = ""
    fun result(round: Int, cars: List<RacingCar>) {
        for (currentRound in 0 until round) {
            println("${currentRound + 1} round")
            showCarsDistance(currentRound, cars)
        }

        showRacingWinner(cars)
    }

    private fun showCarsDistance(round: Int, cars: List<RacingCar>) {
        for (car in cars) {
            showCarDistance(round, car.name, car.distances)
        }
    }

    private fun showCarDistance(round: Int, name: String, carDistance: List<Int>) {
        printCarName(name)

        for ((i, value) in carDistance.withIndex()) {
            printDistance(i, round, value)
        }
        println(EMPTY_STRING)
    }

    private fun printCarName(name: String) {
        print("$name:")
    }

    private fun printDistance(index: Int, round: Int, value: Int) {
        if (index > round) {
            return
        }

        if (value == DISPLAY_NUMBER) {
            print(GO_FORWARD)
        }
    }

    private fun showRacingWinner(cars: List<RacingCar>) {
        val cars = cars.map { it.name to it.distances.filter { value -> value == DISPLAY_NUMBER }.size }.sortedByDescending { it.second }
        val highestScore = cars[HIGHEST_SCORE_INDEX].second
        val winners = cars.filter { it.second == highestScore }.map { it.first }

        println("${winners.joinToString(", ")}가 최종 우승했습니다")
    }
}

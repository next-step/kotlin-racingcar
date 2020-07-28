package week1.step3

object ResultView {

    fun printRacingStep(racingCar: List<Car>, tryCount: Int) {
        for (step in 0 until tryCount) {
            printStep(racingCar, step)
        }
        printWinners(racingCar, tryCount)
    }

    private fun printWinners(racingCar: List<Car>, tryCount: Int) {
        val finalRound = racingCar.map { it.distanceCounts[tryCount] }
        val winners = mutableListOf<String>()
        for (index in finalRound.indices) {
            setupWinners(finalRound, index, winners, racingCar)
        }
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }

    private fun setupWinners(finalRound: List<Int>, index: Int, winners: MutableList<String>, racingCar: List<Car>) {
        if (finalRound[index] == finalRound.max()) {
            winners.add(racingCar[index].name)
        }
    }

    private fun printStep(racingCar: List<Car>, step: Int) {
        for (car in racingCar) {
            printDistance(car, step)
        }
        println()
    }

    private fun printDistance(car: Car, step: Int) {
        print("${car.name} : ")
        for (distance in 0..car.distanceCounts[step]) {
            print("-")
        }
        println()
    }
}

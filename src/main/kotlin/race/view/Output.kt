package race.view

import race.Car
import race.view.Message.RESULT_TITLE

class Output {
    fun printResult(cars: List<Car>) {
        println(RESULT_TITLE)
        val raceCount = cars.first().movementByRounds.size
        for (currentRace in 0 until raceCount) {
            println("${currentRace + 1}번째 레이스")
            cars.forEach {
                val isMovements = it.movementByRounds.slice(0 until currentRace + 1)
                printCarMovement(isMovements)
            }
        }
    }

    private fun printCarMovement(isMovements: List<Boolean>) {
        val movementCount = isMovements.count { it }
        println("-".repeat(movementCount))
    }
}

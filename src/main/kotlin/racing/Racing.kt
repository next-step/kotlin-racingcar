package racing

import kotlin.random.Random

object Racing {
    private const val MIN_PIVOT_VALUE = 0
    private const val MAX_PIVOT_VALUE = 10

    fun start(carNumber: Int, tryRound: Int): List<MutableList<Int>> {
        val racingCars = List(carNumber) { RacingCar(tryRound) }

        repeat(tryRound) {
            for (car in racingCars) {
                car.race(createMovePoint())
            }
        }

        return distances(racingCars)
    }

    private fun distances(racingCars: List<RacingCar>): ArrayList<MutableList<Int>> {
        val distances = ArrayList<MutableList<Int>>()

        for (car in racingCars) {
            distances.add(car.getDistances())
        }

        return distances
    }

    private fun createMovePoint(): Int {
        return Random.nextInt(MIN_PIVOT_VALUE, MAX_PIVOT_VALUE)
    }
}

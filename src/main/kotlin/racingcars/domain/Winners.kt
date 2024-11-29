package racingcars.domain

class Winners private constructor(val values: List<Car>) {
    companion object {
        fun find(racingCars: List<Car>): List<Car> {
            val maxPosition = racingCars.maxOfOrNull { it.position } ?: 0
            return racingCars.filter { it.position == maxPosition }
        }
    }
}

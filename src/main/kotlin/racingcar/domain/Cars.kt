package racingcar.domain

import racingcar.domain.move.MovingStrategy

private const val MINIMUM_NUMBER_OF_CARS = 2

class Cars(val values: List<Car>): Iterable<Car> {

    init {
        require(values.size >= MINIMUM_NUMBER_OF_CARS) { "자동차 경주는 적어도 ${MINIMUM_NUMBER_OF_CARS}대 이상의 자동차가 있어야 가능합니다." }
    }

    fun move(movingStrategy: MovingStrategy) {
        values.forEach { car -> car.move(movingStrategy) }
    }

    override fun iterator(): Iterator<Car> {
        return values.iterator()
    }

    companion object {
        fun of(numberOfCars: Int): Cars {
            return Cars(List(numberOfCars) { Car() })
        }
    }
}

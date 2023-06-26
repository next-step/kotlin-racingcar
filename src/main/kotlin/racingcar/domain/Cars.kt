package racingcar.domain

import racingcar.domain.movingstrategy.MovingStrategy

class Cars(private val cars: List<Car>) {

    fun moveAll() {
        cars.forEach { car -> car.move() }
    }

    fun getPositions(): List<Int> {
        return cars.map(Car::position)
    }

    fun getCurrentInfos(): List<CarInfo> {
        return cars.map(Car::getCurrentInfo)
    }

    companion object {
        private const val NAME_SPLIT_DELIMITER = ","

        fun of(names: String, movingStrategy: MovingStrategy): Cars {
            val splitCarNames = names.split(NAME_SPLIT_DELIMITER)

            val cars = List(splitCarNames.size) { Car(movingStrategy, splitCarNames[it]) }
            return Cars(cars)
        }
    }
}

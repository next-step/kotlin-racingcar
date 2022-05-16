package raicing.model

import raicing.Const
import raicing.strategy.MovingStrategy

class RaceCar(private val cars: List<Car>) {
    fun getCars() = cars

    fun raceOnce(movingStrategy: MovingStrategy): RaceCar {
        val afterRaceCars = cars.map { car ->
            car.moveForward(movingStrategy)
        }
        return RaceCar(afterRaceCars)
    }

    companion object {
        private const val INPUT_DELIMITER = ','
        private const val MAX_NAME_LENGTH = 5

        fun of(carNames: List<String>): RaceCar =
            RaceCar(List(carNames.size) { Car(carNames[it]) })

        fun splitCarNames(carNameStr: String): List<String> {
            val carNames = carNameStr.split(INPUT_DELIMITER)
            return carNames.map { carName ->
                require(carName.isNotBlank() && carName.length <= MAX_NAME_LENGTH) { Const.ErrorMsg.CAR_NAME_IS_TOO_LONG }
                carName.trim()
            }
        }
    }
}

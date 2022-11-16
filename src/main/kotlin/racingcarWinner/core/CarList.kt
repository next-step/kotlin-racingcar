package racingcarWinner.core

object CarList {

    fun setCars(carNames: List<String>): List<Car> =
        carNames.map { carName ->
            Car(carName.trim())
        }
}

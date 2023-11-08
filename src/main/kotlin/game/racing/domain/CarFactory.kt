package game.racing.domain

object CarFactory {
    private const val CAR_NAME_DELIMITER = ","

    fun generateCarByCarNames(carNames: String): List<Car> {
        val carNameList = carNames.split(CAR_NAME_DELIMITER)
        return carNameList.map { Car(it) }
    }
}

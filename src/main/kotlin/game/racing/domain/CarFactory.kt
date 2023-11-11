package game.racing.domain

object CarFactory {
    fun generateCarByCarNames(carNameList: List<String>): List<Car> = carNameList.map { Car(it) }
}

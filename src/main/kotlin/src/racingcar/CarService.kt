package src.racingcar

class CarService(
    private val carMoveRandomValue: Int
) {

    fun execute(carNames: String): MutableList<Car> {
        val race = Race().create(parseComma(carNames))
        return race.start(carMoveRandomValue)
    }
}
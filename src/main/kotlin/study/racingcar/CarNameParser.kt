package study.racingcar

object CarNameParser {

    fun requestParseCarNames(carNames: String): List<Car> {
        return carNames.split(",")
            .map { Car.newCar(it) }
    }
}

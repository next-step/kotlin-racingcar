package study.racingcar.domain

object CarNameParser {

    fun requestParseCarNames(carNames: String): List<Car> {
        return carNames.split(",")
            .map { Car.newCar(it) }
    }
}

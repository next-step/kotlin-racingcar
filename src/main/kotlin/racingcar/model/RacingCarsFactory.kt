package racingcar.model

fun interface RacingCarsFactory {

    fun createCars(carNames: List<CarName>): Cars
}

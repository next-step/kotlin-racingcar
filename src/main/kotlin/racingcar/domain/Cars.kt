package racingcar.domain

private const val MINIMUM_NUMBER_OF_CARS = 2

class Cars(cars: List<Car>) {
    val values: List<Car>

    init {
        require(cars.size >= MINIMUM_NUMBER_OF_CARS) { "자동차 경주는 적어도 ${MINIMUM_NUMBER_OF_CARS}대 이상의 자동차가 있어야 가능합니다." }
        this.values = cars
    }

    fun move(canMove: () -> Boolean) {
        values.forEach { car -> car.move(canMove) }
    }
}

package study.racingcar.car

class DefaultCarFactory : CarFactory {
    override fun createCars(carNames: List<String>, moveGenerator: MoveGenerator): List<Car> {
        return carNames.map { Car(it, moveGenerator) }
    }
}

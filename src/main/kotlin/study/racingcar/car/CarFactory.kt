package study.racingcar.car

interface CarFactory {
    fun createCars(carNames: List<String>, moveGenerator: MoveGenerator): List<Car>
}

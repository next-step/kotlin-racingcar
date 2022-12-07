package src.racingcar

class Race(
    private var cars: MutableList<Car> = mutableListOf()
) {

    fun create(carNames: List<String>): Race {
        for (carName in carNames) {
            cars.add(Car(carName))
        }

        return this
    }

    fun start(carMoveRandomValue: Int): MutableList<Car> {
        for (car in cars) {
            car.move(carMoveRandomValue)
        }
        return cars
    }
}
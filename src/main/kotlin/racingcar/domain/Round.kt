package racingcar.domain

class Round() {

    fun execute(cars: List<Car>) {
        controlEachCar(cars)
    }

    private fun controlEachCar(cars: List<Car>) {
        for (car in cars) {
            car.isMoveOrStop()
        }
    }
}

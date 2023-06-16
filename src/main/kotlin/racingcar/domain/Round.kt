package racingcar.domain

class Round() {

    fun execute(cars: MutableList<Car>) {
        controlEachCar(cars)
    }

    private fun controlEachCar(cars: MutableList<Car>) {
        for (car in cars) {
            car.isMoveOrStop()
        }
    }
}

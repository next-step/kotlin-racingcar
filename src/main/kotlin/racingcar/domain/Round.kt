package racingcar.domain

class Round() {

    fun execute(cars: ArrayList<Car>) {
        controlEachCar(cars)
    }

    private fun controlEachCar(cars: ArrayList<Car>) {
        for (car in cars) {
            car.isMoveOrStop()
        }
    }
}

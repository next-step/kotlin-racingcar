package racingcar.domain

class Round() {

    fun executeRound(cars: List<Car>) {
        for (car in cars) {
            car.isMoveOrStop()
        }
    }
}

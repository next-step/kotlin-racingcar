package study.racingcar.domain

class Racing(internal val cars: List<Car>, val totalRound: Int) {

    constructor(numOfCar: Int, totalRound: Int) : this((1..numOfCar).map { Car() }, totalRound)

    fun start() {
        cars.forEach {
            it.move((1..9).random())
        }
    }
}

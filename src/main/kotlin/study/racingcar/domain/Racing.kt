package study.racingcar.domain

class Racing(internal val cars: List<Car>, val totalRound: Int) {

    var round = 0
        private set

    constructor(numOfCar: Int, round: Int) : this((1..numOfCar).map { Car() }, round)

    fun start() {
        if (round >= totalRound) return

        cars.forEach {
            it.move((1..9).random())
        }
    }
}

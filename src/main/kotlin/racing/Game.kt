package racing

class Game(
    private val roundCount: Int,
    private val carCount: Int,
    private val pedal: Pedal
) {
    fun start() {
        val cars = Cars.make(count = carCount, pedal = pedal).cars
        val round = Round.make(count = roundCount).round

        OutPutView.printStart()
        for (i in 0..round) {
            cars.forEach(Car::moveForward)
            OutPutView.printRound(cars)
        }
    }
}

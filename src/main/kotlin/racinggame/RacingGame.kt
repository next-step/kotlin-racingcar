package racinggame

class RacingGame(
    private val cars: List<Car>,
    private val diceStrategy: () -> Int
) {

    fun play() {
        cars.forEach { car ->
            val num = Dice.pitch(diceStrategy)
            if (num >= 4) {
                car.forward()
            }
        }
    }

    fun currentPositions(): List<Int> = cars.map { it.position }
}

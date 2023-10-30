package racinggame

class RacingGame(
    private val cars: List<Car>,
    private val tryCount: Int,
    private val dice: Dice
) {

    fun play() = (1..tryCount).map {
        cars.map { car ->
            val num = dice.pitch()
            car.move(num)
            car.position
        }
    }.map { round ->
        PlayResult(round)
    }.let {
        RacingGameResult(it)
    }
}


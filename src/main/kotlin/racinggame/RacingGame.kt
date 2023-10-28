package racinggame

class RacingGame(
    private val cars: List<Car>,
    private val tryCount: Int,
    private val diceStrategy: () -> Int
) {

    fun play() = (1..tryCount).map {
        cars.map { car ->
            val num = Dice.pitch(diceStrategy)
            if (num >= 4) {
                car.forward()
            }
            car.position
        }
    }
}

fun List<List<Int>>.translate() = this.map { round ->
    round.map {
        (0..it).map {
            "-"
        }.reduce { s1, s2 ->
            s1 + s2
        }
    }
}

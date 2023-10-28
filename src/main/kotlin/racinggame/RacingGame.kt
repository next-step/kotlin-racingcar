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

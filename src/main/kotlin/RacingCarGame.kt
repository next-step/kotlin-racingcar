import kotlin.random.Random

class RacingCarGame {
    private val racingCarValue: List<Car>
    private val racingGameTryValue: Int

    init {
        println("Input : How many racing car?")
        racingCarValue =
            arrayOfNulls<Car>(readlnOrNull()?.toIntOrNull() ?: 0).mapIndexed { idx, _ ->
                Car(name = idx.toString())
            }

        println("\nInput : How many try racing?")
        racingGameTryValue = readlnOrNull()?.toIntOrNull() ?: 0

        check(racingCarValue.isNotEmpty() && racingGameTryValue != 0) {
            "Game End"
        }
    }

    fun gameStart() {
        println("\nGame Result is ...")
        repeat(racingGameTryValue) { _ ->
            racingCarValue.forEach { car ->
                val driveValue = Random.nextInt(10)
                car.goForward(driveValue)
                println(car.forwardValue)
            }
            println()
        }
    }

    data class Car(val name: String, val driveLength: Int = 0) {
        var forwardValue = "-"
            private set

        fun goForward(value: Int) {
            forwardValue = if (value > 4) "-$forwardValue" else forwardValue
        }
    }
}

fun main() {
    val game = RacingCarGame()
    game.gameStart()
}

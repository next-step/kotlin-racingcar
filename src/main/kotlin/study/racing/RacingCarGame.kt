package study.racing

import kotlin.random.Random

/**
 * @author 이상준
 */
class RacingCarGame(
    private val gameSettings: GameSettings,
) {
    private val random = Random
    private var carList = mutableListOf<Car>()

    private fun init() {
        this.carList = mutableListOf()
        repeat(gameSettings.carCount) {
            this.carList.add(Car())
        }
    }

    private fun playGame() {
        carList.forEach {
            it.position += move()
            gameMessageView(it)
        }
    }

    fun start() {
        init()

        repeat(gameSettings.racingCount) {
            playGame()
            println()
        }
    }

    private fun move(): Int {
        return if (random.nextInt(GameRule.MIN_RANDOM_POSITION, GameRule.MAX_RANDOM_POSITION) > 3) 1 else 0
    }

    private fun gameMessageView(car: Car) {
        repeat(car.position) {
            print(GameRule.RACING_CAR_MOVE_TEXT)
        }
        println()
    }
}

fun main() {
    val gameSettings = RacingCarGameSettings().inputBySettings()
    val racingCarGame = RacingCarGame(gameSettings)
    racingCarGame.start()
}

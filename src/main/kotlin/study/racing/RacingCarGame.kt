package study.racing

/**
 * @author 이상준
 */
class RacingCarGame(
    private val gameSettings: GameSettings,
) {
    private val carList = mutableListOf<Car>()

    private fun init() {
        repeat(gameSettings.carCount) {
            this.carList.add(Car())
        }
    }

    private fun playGame() {
        carList.forEach {
            it.move()
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

    private fun gameMessageView(car: Car) {
        repeat(car.getPosition()) {
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

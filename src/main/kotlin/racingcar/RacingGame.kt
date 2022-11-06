package racingcar

fun main() {
    RacingGame().start()
}

class RacingGame(
    private val settingView: SettingView = SettingView(),
    private val progressView: ProgressView = ProgressView(),
    private val goStop: GoStop = GoStop()
) {

    fun start(setting: Setting = settingView.setUp()): List<String> {
        var cars = generateCars(setting.numberOfCars)

        repeat(setting.numberOfLab) {
            cars = playTurn(cars)
        }

        return cars
    }

    private fun playTurn(cars: List<String>): List<String> {

        val progress = cars.map { s ->
            if (goStop.canGo()) "$s-"
            else s
        }

        progressView.display(progress)
        return progress
    }

    private fun generateCars(numberOfCars: Int): List<String> {
        return List(numberOfCars) { "" }
    }
}

package racingcar.application

import racingcar.CarManager
import racingcar.CarRacing

class Application {
    private val carManager = CarManager()
    private val carRacing = CarRacing()

    fun run() {
        println(GuideScript.PROGRAM_INFO)
        while (true) {
            println(GuideScript.BEGIN_GUIDE)
            val runCommand = readln()
            if (STOP_COMMAND == runCommand) {
                break
            }
            println(GuideScript.INPUT_PARTICIPANTS_GUIDE)
            val totalParticipants = readln().toInt()
            val cars = carManager.ready(totalParticipants)

            println(GuideScript.INPUT_TRY_COUNT_GUIDE)
            val tryCount = readln().toInt()
            carRacing.participate(cars, tryCount)
        }
        println(GuideScript.CLOSE_GUIDE)
    }

    companion object {
        private const val STOP_COMMAND = "0"
    }
}

package racing

import racing.controller.RacingController

fun main() {
    RacingApplication.run()
}

object RacingApplication {
    fun run() {
        RacingController.startRacing()
    }
}

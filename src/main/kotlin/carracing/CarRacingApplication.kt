package carracing

import carracing.controlller.CarRacingController

private val racingController = CarRacingController()

fun main() {
    val racing = racingController.organize()
    racingController.play(racing)
    racingController.finish(racing)
}

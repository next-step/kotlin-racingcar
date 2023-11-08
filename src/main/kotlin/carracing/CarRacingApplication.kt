package carracing

import carracing.controlller.CarRacingController

private val racingController = CarRacingController()

fun main() {
    val racing = racingController.organize()
    val snapshots = racingController.play(racing)
    racingController.printSnapshots(snapshots)
}

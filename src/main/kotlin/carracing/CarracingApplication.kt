package carracing

import carracing.controlller.RacingController

val racingController = RacingController()

fun main() {
    val racing = racingController.create()
    val snapshots = racingController.play(racing)
    racingController.printSnapshots(snapshots)
}

package carracing

import carracing.controlller.RacingController

lateinit var racingController: RacingController

fun init() {
    racingController = RacingController()
}

fun main() {
    init()
    val racing = racingController.create()
    val snapshots = racingController.play(racing)
    racingController.printSnapshots(snapshots)
}

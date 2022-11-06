package nexstep.mission

import nexstep.mission.racingcar.RacingCarConfig

fun main() {
    val racingCarController = RacingCarConfig.racingCarController()
    racingCarController.race()
}

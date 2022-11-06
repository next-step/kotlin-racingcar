package nexstep.mission.racingcar

import nexstep.mission.racingcar.io.ConsoleInput
import nexstep.mission.racingcar.io.ConsoleOutput

object RacingCarConfig {

    fun racingCarController() = RacingCarController(ConsoleInput, ConsoleOutput)
}

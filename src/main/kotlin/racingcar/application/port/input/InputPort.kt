package racingcar.application.port.input

import racingcar.application.model.RacingCarInputCommand
import racingcar.application.race.Race

class InputPort(
    private val race: Race
) {
    fun input(input: RacingCarInputCommand) {
        race.proceed(input)
    }
}

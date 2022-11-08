package racingcar.application.port.input

import racingcar.application.model.RaceInputCommand
import racingcar.application.race.Race

class InputPort(
    private val race: Race
) {
    fun input(input: RaceInputCommand) {
        race.proceed(input)
    }
}

package carRace.view

import carRace.domain.RaceIterationProvider

object UserInputRaceIterationProvider : RaceIterationProvider {
    override fun provide(): Int {
        return println("시도할 횟수는 몇 회인가요?").run { readln().trim().toInt() }
    }
}

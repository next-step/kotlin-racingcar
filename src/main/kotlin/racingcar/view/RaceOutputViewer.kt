package racingcar.view

import racingcar.domain.RaceStatus

interface RaceOutputViewer {
    fun view(raceStatus: RaceStatus)
}

class ConsoleRaceOutputViewer : RaceOutputViewer {
    override fun view(raceStatus: RaceStatus) {
        raceStatus.cars.forEach {
            println("-".repeat(it.location.location.toInt()))
        }
        newline()
    }

    private fun newline() = println("")
}

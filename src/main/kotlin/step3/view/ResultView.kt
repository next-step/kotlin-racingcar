package step3.view

import step3.domain.race.RaceResult

interface ResultView {
    fun drawResult(raceResult: RaceResult)
}

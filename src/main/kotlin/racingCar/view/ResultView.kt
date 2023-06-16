package racingCar.view

import racingCar.domain.race.RaceResult

interface ResultView {
    fun drawResult(raceResult: RaceResult)
}

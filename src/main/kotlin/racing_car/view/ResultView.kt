package racing_car.view

import racing_car.domain.race.RaceResult

interface ResultView {
    fun drawResult(raceResult: RaceResult)
}

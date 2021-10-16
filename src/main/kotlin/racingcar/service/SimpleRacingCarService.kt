package racingcar.service

import racingcar.domain.RacingCars
import racingcar.domain.vo.Lap
import racingcar.domain.vo.Laps
import racingcar.domain.vo.Scoreboard

class SimpleRacingCarService(
    private val scoreboard: Scoreboard = Scoreboard(),
) : RacingCarService {

    override fun race(
        racingCars: RacingCars,
        laps: Laps
    ): Scoreboard {
        var racingCarsPerLap: RacingCars = racingCars
        return laps.values.fold(scoreboard) { previous: Scoreboard, lap: Lap ->
            racingCarsPerLap = racingCarsPerLap.race()
            previous.record(lap, racingCarsPerLap)
        }
    }
}

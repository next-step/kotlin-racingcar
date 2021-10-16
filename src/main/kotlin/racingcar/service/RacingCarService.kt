package racingcar.service

import racingcar.domain.RacingCars
import racingcar.domain.vo.Laps
import racingcar.domain.vo.Scoreboard

interface RacingCarService {
    fun race(racingCars: RacingCars, laps: Laps): Scoreboard
}

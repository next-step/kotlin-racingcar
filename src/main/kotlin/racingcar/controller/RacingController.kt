package racingcar.controller

import racingcar.domain.CarFactory
import racingcar.domain.RaceResult
import racingcar.domain.RacingGame

/**
 * 레이싱을 시작하고, 계산하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
object RacingController {
    fun startGame(
        carNames: List<String>,
        repeatTime: Int
    ): List<RaceResult> {
        return RacingGame(
            CarFactory.createCars(carNames),
            repeatTime
        ).startGame()
    }
}

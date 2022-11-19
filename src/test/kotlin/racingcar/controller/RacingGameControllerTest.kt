package racingcar.controller

import io.kotest.core.spec.style.StringSpec
import racingcar.domain.strategy.RandomMoveStrategy
import racingcar.view.ParticipateCarName

internal class RacingGameControllerTest : StringSpec({
    "경주에 참여하는 자동차 이름, 시도할 횟수가 주어지면 게임을 진행할 수 있다." {
        val nameOfCars = listOf<ParticipateCarName>(
            ParticipateCarName("car1"),
            ParticipateCarName("car2"),
            ParticipateCarName("car3"),
        )
        val numberOfTry = 5
        RacingGameController.play(nameOfCars, numberOfTry, RandomMoveStrategy())
    }
})

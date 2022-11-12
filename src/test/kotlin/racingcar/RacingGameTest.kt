package racingcar

import io.kotest.core.spec.style.StringSpec

internal class RacingGameTest : StringSpec({
    "경주에 참여하는 자동차 이름, 시도할 횟수가 주어지면 게임을 진행할 수 있다." {
        val nameOfCars = listOf("car1, car2, car3")
        val numberOfTry = 5
        RacingGameController.play(nameOfCars, numberOfTry, RandomMoveStrategy())
    }
})

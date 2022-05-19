package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class RacingGameTest : StringSpec({
    "자동차 경주 게임을 시도횟수만큼 실행한다." {
        // given
        val cars = Cars(
            listOf(
                Car("k5"),
                Car("sm3"),
            ),
        )
        val tryNumber = TryNumber(2)
        val racingGame = RacingGame(
            cars = cars,
            tryNumber = tryNumber,
        )

        // when
        val actual = racingGame.play { 4 }

        // then
        actual.value.size shouldBe 2
        actual.value[0].cars.size shouldBe 2
        actual.value[1].cars.size shouldBe 2
    }
})

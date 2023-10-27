package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.view.CarRacingInput
import java.lang.IllegalArgumentException

class CarRacingInitialConfigurationTest : StringSpec({
    "자동차 대수와 시도 횟수가 모두 양수인 경우 레이싱 게임 설정 정보가 생성된다" {
        val carCount = 1
        val tryCount = 2

        val result = CarRacingInitialConfiguration.of(CarRacingInput(carCount, tryCount))

        result.carCount shouldBe carCount
        result.tryCount shouldBe tryCount
    }

    "자동차 대수가 양수가 아닌 경우 레이싱 게임 설정 정보 생성에 실패한다" {
        val carCount = 0
        val tryCount = 2

        shouldThrowExactly<IllegalArgumentException> {
            CarRacingInitialConfiguration.of(CarRacingInput(carCount, tryCount))
        }
    }

    "시도 횟수가 양수가 아닌 경우 레이싱 게임 설정 정보 생성에 실패한다" {
        val carCount = 2
        val tryCount = -1

        shouldThrowExactly<IllegalArgumentException> {
            CarRacingInitialConfiguration.of(CarRacingInput(carCount, tryCount))
        }
    }
})

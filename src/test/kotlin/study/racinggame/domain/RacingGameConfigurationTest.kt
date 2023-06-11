package study.racinggame.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class RacingGameConfigurationTest : StringSpec({

    "생성 시 자동차 갯수가 2대 이상이면 정상적으로 생성 된다." {
        // given
        val nameOfCars = listOf("1", "2")
        val numberOfTries = 3

        // when & then
        shouldNotThrow<Exception> { RacingGameConfiguration.of(nameOfCars, numberOfTries) }
    }

    "생성 시 자동차 갯수가 2대 미만이면 오류가 발생 한다." {
        // given
        val nameOfCars = listOf("1")
        val numberOfTries = 3

        // when & then
        shouldThrow<IllegalArgumentException> { RacingGameConfiguration.of(nameOfCars, numberOfTries) }
    }

    "생성 시 시도 횟수가 1회 이상이면 정상적으로 생성 된다." {
        // given
        val nameOfCars = listOf("1", "2")
        val numberOfTries = 1

        // when & then
        shouldNotThrow<Exception> { RacingGameConfiguration.of(nameOfCars, numberOfTries) }
    }

    "생성 시 시도 횟수가 1회 미만이면 오류가 발생 한다." {
        // given
        val nameOfCars = listOf("1", "2")
        val numberOfTries = 0

        // when & then
        shouldThrow<IllegalArgumentException> { RacingGameConfiguration.of(nameOfCars, numberOfTries) }
    }

    "자동차 게임을 정상적으로 생성 한다." {
        // given
        val nameOfCars = listOf("1", "2")
        val numberOfTries = 3
        val racingGameConfiguration = RacingGameConfiguration.of(nameOfCars, numberOfTries)

        // when & then
        shouldNotThrow<Exception> { racingGameConfiguration.build() }
    }
})

package study.step3.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import study.step3.util.RandomDigit
import study.step3.util.StaticDigit

internal class RacingCarTest : StringSpec({

    "주어진 레이싱 경기에, 참가하는 자동차 수가 0이면, 에러를 발생한다" {
        shouldThrow<IllegalArgumentException> {
            // expect
            RacingCar(0, 3, RandomDigit())
        }.shouldHaveMessage("참가 자동차 수는 0보다 커야 합니다")
    }

    "주어진 레이싱 경기에, 참가하는 자동차 수가 주어지면, 조회한 자동차 수도 같아야 한다" {
        listOf(
            3,
            10,
            111
        ).forAll {
            // given & when
            val racingCar = RacingCar(it, 3, RandomDigit())

            // then
            assertThat(racingCar.getCars().size).isEqualTo(it)
        }
    }

    "주어진 레이싱 경기에 시도하는 횟수를 주고, 레이스를 진행하면, 참여한 자동차의 레이스횟수가 시도하는 횟수와 같다" {
        listOf(
            1,
            10,
            30
        ).forAll {
            // given
            val racingCar = RacingCar(3, it, RandomDigit())

            // when
            racingCar.race()

            // then
            racingCar.getCars().forEach { car ->
                assertThat(car.getRacingTimes()).isEqualTo(it)
            }
        }
    }

    "주어진 레이싱 경기에, 주어진 숫자가 4 이상이면, Car 은 모두 시도 횟수만큼 전진한다" {
        listOf(
            4, 5, 6, 7, 8, 9
        ).forAll {
            // given
            val racingCar = RacingCar(3, 3, StaticDigit(it))

            // when
            racingCar.race()

            // then
            racingCar.getCars().forEach { car ->
                assertThat(car.getLocation()).isEqualTo(3)
            }
        }
    }

    "주어진 레이싱 경기에, 주어진 숫자가 4 미만, Car 은 모두 멈춰 있는다" {
        listOf(
            0, 1, 2, 3
        ).forAll {
            // given
            val racingCar = RacingCar(3, 3, StaticDigit(it))

            // when
            racingCar.race()

            // then
            racingCar.getCars().forEach { car ->
                assertThat(car.getLocation()).isEqualTo(0)
            }
        }
    }
})

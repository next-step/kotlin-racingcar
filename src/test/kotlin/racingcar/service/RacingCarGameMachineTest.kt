package racingcar.service

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll
import io.kotest.inspectors.forAtLeastOne
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.service.dto.GameResultDto
import racingcar.service.strategy.RandomNumberZeroToNineGenerate

class RacingCarGameMachineTest : ShouldSpec({

    context("게임을 진행한다.") {
        should("일반적인 게임을 진행한다.") {
            val sut = RacingCarGameMachine(RandomNumberZeroToNineGenerate())
            val expectedCarNames = listOf("pobi", "gump", "jason")
            val expectedTryCount = 5

            val actual = sut.play(expectedCarNames, expectedTryCount)

            actual.size shouldBe expectedTryCount
        }

        should("전체 이동되는 게임을 진행한다.") {
            val sut = RacingCarGameMachine { 9 }
            val expectedCarNames = listOf("pobi", "gump", "jason")
            val expectedTryCount = 5

            val actual = sut.play(expectedCarNames, expectedTryCount)

            actual.size shouldBe expectedTryCount
            actual.forAtLeastOne { result ->
                result.cars.cars.forAll { car ->
                    car.position shouldBe 6
                }
            }
        }

        should("전체 멈춰있는 게임을 진행한다.") {
            val sut = RacingCarGameMachine { 0 }
            val expectedCarNames = listOf("pobi", "gump", "jason")
            val expectedTryCount = 5

            val actual = sut.play(expectedCarNames, expectedTryCount)

            actual.size shouldBe expectedTryCount
            actual.forAtLeastOne { result ->
                result.cars.cars.forAll { car ->
                    car.position shouldBe 1
                }
            }
        }
    }

    context("결과를 확인한다") {
        should("우승자를 확인한다") {
            val sut = RacingCarGameMachine { 0 }
            val expected = listOf(
                GameResultDto(1, Cars(listOf(Car("pobi", 1), Car("gump", 1), Car("jason", 1)))),
                GameResultDto(2, Cars(listOf(Car("pobi", 1), Car("gump", 1), Car("jason", 1)))),
                GameResultDto(3, Cars(listOf(Car("pobi", 4), Car("gump", 3), Car("jason", 4)))),
            )
            sut.getWinners(expected).map { it }.shouldBe(listOf("pobi", "jason"))
        }
    }
})

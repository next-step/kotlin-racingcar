package step3

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import step3.domain.Game

class GameSpec : DescribeSpec({
    describe("게임 세팅(초기화)") {
        context("자동차 대수가 1 이하인 경우") {
            it("IllegalArgumentException이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    Game(numberOfCars = 0, numberOfTrials = 1)
                }
            }
        }

        context("시도 횟수가 1 이하인 경우") {
            it("IllegalArgumentException이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    Game(numberOfCars = 1, numberOfTrials = 0)
                }
            }
        }
    }

    describe("게임 실행") {
        context("자동차가 2대이고 시도 횟수가 3인 경우") {
            val game = Game(numberOfCars = 2, numberOfTrials = 3)

            it("3회 시도 결과를 반환한다") {
                val result = game.process()

                result.size shouldBe 3
                result.forEach { it.size shouldBe 2 }
            }
        }
    }
})

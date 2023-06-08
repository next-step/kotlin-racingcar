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
        context("자동차가 n(first)대이고 시도 횟수가 m(second)인 경우") {
            val cases = listOf(
                Pair(2, 3),
                Pair(7, 4),
                Pair(10, 23),
            )

            it("시도 횟수만큼 결과를 반환한다") {
                cases.forEach {
                    val numberOfCars = it.first
                    val numberOfTrials = it.second

                    val results = Game(numberOfCars = numberOfCars, numberOfTrials = numberOfTrials).process()

                    results.size shouldBe numberOfTrials
                }
            }

            it("각 시도 결과에는 자동차 대수만큼 결과가 포함된다") {
                cases.forEach {
                    val numberOfCars = it.first
                    val numberOfTrials = it.second

                    val results = Game(numberOfCars = numberOfCars, numberOfTrials = numberOfTrials).process()

                    results.forEach { result ->
                        result.size shouldBe numberOfCars
                    }
                }
            }
        }
    }
})

package step4.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class GameSpec : DescribeSpec({
    describe("게임 세팅(초기화)") {
        context("세팅할 자동차가 없는 경우") {
            it("IllegalArgumentException 이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    Game(nameOfCars = listOf(), numberOfTrials = 1)
                }
            }
        }

        context("게임의 시도 횟수가 1 이하인 경우") {
            it("IllegalArgumentException 이 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    Game(nameOfCars = listOf("test"), numberOfTrials = 0)
                }
            }
        }
    }

    describe("게임 실행") {
        context("자동차가 n(first)대이고 시도 횟수가 m(second)인 경우") {
            val cases = listOf(
                Pair(listOf("john", "mike"), 3),
                Pair(listOf("john", "mike", "lucas"), 7),
            )

            it("시도 횟수만큼 결과를 반환한다") {
                cases.forEach {
                    val nameOfCars = it.first
                    val numberOfTrials = it.second

                    val trials = Game(nameOfCars = nameOfCars, numberOfTrials = numberOfTrials).process()

                    trials.size shouldBe numberOfTrials
                }
            }

            it("각 시도 결과에는 현재 자동차의 정보를 반환한다") {
                cases.forEach {
                    val nameOfCars = it.first
                    val numberOfTrials = it.second

                    val trials = Game(nameOfCars = nameOfCars, numberOfTrials = numberOfTrials).process()

                    trials.forEach { cars ->
                        cars.size shouldBe nameOfCars.size
                    }
                }
            }
        }
    }
})

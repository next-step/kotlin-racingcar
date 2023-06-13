package step5.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
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
            val ts = listOf(
                Pair(listOf("john", "mike"), 3),
                Pair(listOf("john", "mike", "lucas"), 7),
            )

            withData(
                nameFn = { "시도 횟수(${it.second})만큼 게임 기록 결과를 반환한다." },
                ts = ts,
            ) { (nameOfCars, numberOfTrials) ->
                val game = Game(nameOfCars = nameOfCars, numberOfTrials = numberOfTrials).also { it.process() }

                game.getGameLogs().size shouldBe numberOfTrials
            }

            withData(
                nameFn = { "각 게임 기록에는 모든 자동차들의 정보(${it.first.size}개)를 반환한다." },
                ts = ts,
            ) { (nameOfCars, numberOfTrials) ->
                val game = Game(nameOfCars = nameOfCars, numberOfTrials = numberOfTrials).also { it.process() }

                game.getGameLogs().forEach { gameLog ->
                    gameLog.size shouldBe nameOfCars.size
                }
            }
        }

        context("게임이 실행되지 않았다면") {
            val game = Game(nameOfCars = listOf("john", "mike"), numberOfTrials = 3)

            it("게임 기록 결과 반환 시 IllegalStateException 이 발생한다") {
                shouldThrowExactly<IllegalStateException> {
                    game.getGameLogs()
                }
            }

            it("우승자 반환 시 IllegalStateException 이 발생한다") {
                shouldThrowExactly<IllegalStateException> {
                    game.getWinners()
                }
            }
        }
    }
})

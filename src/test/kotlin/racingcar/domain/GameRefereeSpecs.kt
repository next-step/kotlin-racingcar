package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class GameRefereeSpecs : DescribeSpec({

    describe("심판은") {
        context("게임 기록이 주어진다면") {
            val gameRecord = GameRecord(
                listOf(
                    RaceRecord(
                        listOf(
                            Car.State("car1", 0),
                            Car.State("car2", 1),
                            Car.State("car3", 0),
                        )
                    ),
                    RaceRecord(
                        listOf(
                            Car.State("car1", 1),
                            Car.State("car2", 2),
                            Car.State("car3", 0),
                        )
                    ),
                )
            )
            it("게임 결과를 확인할 수 있다.") {
                val gameResult = GameReferee.rank(gameRecord)
                gameResult.also {
                    it.raceResults.size shouldBe 2
                    it.winners shouldContainExactly listOf("car2")
                }
            }
        }

        context("빈 게임 기록이 주어진다면") {
            val gameRecord = GameRecord(emptyList())
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> { GameReferee.rank(gameRecord) }
            }
        }
    }
})

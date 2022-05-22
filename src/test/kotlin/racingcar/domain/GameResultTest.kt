package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.collection.RoundRecord

class GameResultTest : DescribeSpec({
    describe("winner 조회 테스트") {
        context("모두 움직이지 않으면") {
            it("우승자는 두개이다.") {
                val givenRecords = listOf(
                    RoundRecord(
                        listOf(
                            Record("car1", 0),
                            Record("car2", 0),
                            Record("car3", 0)
                        )
                    )
                )

                val gameResult = GameResult(givenRecords)

                gameResult.winners shouldBe listOf("car1", "car2", "car3")
            }
        }

        context("자동차 하나가 가장 앞에 있으면") {
            it("우승자는 하나이다.") {
                val givenRecords = listOf(
                    RoundRecord(
                        listOf(
                            Record("car1", 1),
                            Record("car2", 2),
                            Record("car3", 3)
                        )
                    )
                )

                val gameResult = GameResult(givenRecords)

                gameResult.winners shouldBe listOf("car3")
            }
        }

        context("모두가 동일하게 움직이면") {
            it("우승자는 모두이다.") {
                val givenRecords = listOf(
                    RoundRecord(
                        listOf(
                            Record("car1", 3),
                            Record("car2", 3),
                            Record("car3", 3)
                        )
                    )
                )

                val gameResult = GameResult(givenRecords)

                gameResult.winners shouldBe listOf("car1", "car2", "car3")
            }
        }
    }
})

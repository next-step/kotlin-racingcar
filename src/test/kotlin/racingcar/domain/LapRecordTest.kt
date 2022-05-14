package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class LapRecordTest : DescribeSpec({

    describe("winner") {
        context("가장 많이 움직인 자동차를 우승자로 조회할 수 있다") {
            it("우승자는 한명일 수 있다") {
                val winner = CarName("우승자")
                val lapRecord = LapRecord(
                    listOf(
                        CarNameWithLocation(winner to Location(5)),
                        CarNameWithLocation(CarName("비우승자") to Location(4)),
                        CarNameWithLocation(CarName("비우승자") to Location(3)),
                    )
                )

                lapRecord.winner() shouldBe listOf(winner)
            }

            it("우승자는 한명 이상일 수 있다") {
                val winner1 = CarName("우승자1")
                val winner2 = CarName("우승자2")
                val lapRecord = LapRecord(
                    listOf(
                        CarNameWithLocation(winner1 to Location(5)),
                        CarNameWithLocation(winner2 to Location(5)),
                        CarNameWithLocation(CarName("비우승자") to Location(3)),
                    )
                )

                lapRecord.winner() shouldBe listOf(winner1, winner2)
            }
        }
    }
})

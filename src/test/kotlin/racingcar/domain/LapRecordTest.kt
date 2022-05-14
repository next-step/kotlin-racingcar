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
                        CarRecord(winner, Location(5)),
                        CarRecord(CarName("비우승자"), Location(4)),
                        CarRecord(CarName("비우승자"), Location(3)),
                    )
                )

                lapRecord.winner() shouldBe listOf(winner)
            }

            it("우승자는 한명 이상일 수 있다") {
                val winner1 = CarName("우승자1")
                val winner2 = CarName("우승자2")
                val lapRecord = LapRecord(
                    listOf(
                        CarRecord(winner1, Location(5)),
                        CarRecord(winner2, Location(5)),
                        CarRecord(CarName("비우승자"), Location(3)),
                    )
                )

                lapRecord.winner() shouldBe listOf(winner1, winner2)
            }
        }
    }
})

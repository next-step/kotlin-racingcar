package racingcar.domain

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class RacingGameRecordTest : DescribeSpec({

    describe("add") {
        it("랩 기록(LapRecord)를 추가할 수 있다") {
            val racingGameRecord = RacingGameRecord()
            val lapRecord = LapRecord(emptyList())

            racingGameRecord.add(lapRecord)

            val lapRecords = racingGameRecord.lapRecords
            assertSoftly {
                lapRecords shouldBe listOf(lapRecord)
                lapRecords.size shouldBe 1
            }
        }
    }

    describe("winner") {
        context("마지막 랩에 가장 많이 움직인 자동차를 우승자로 조회할 수 있다") {
            it("우승자는 한명일 수 있다") {
                val winner = CarName("우승자")
                val lapRecords = listOf(
                    LapRecord(
                        listOf(
                            CarRecord(winner to Location(0)),
                            CarRecord(CarName("참가자1") to Location(4)),
                            CarRecord(CarName("참가자2") to Location(3)),
                        )
                    ),
                    LapRecord(
                        listOf(
                            CarRecord(winner to Location(5)),
                            CarRecord(CarName("참가자1") to Location(4)),
                            CarRecord(CarName("참가자2") to Location(3))
                        )
                    )
                )
                val racingGameRecord = RacingGameRecord(lapRecords)

                racingGameRecord.winner() shouldBe listOf(winner)
            }

            it("우승자는 한명 이상일 수 있다") {
                val winner1 = CarName("우승자1")
                val winner2 = CarName("우승자2")
                val lapRecords = listOf(
                    LapRecord(
                        listOf(
                            CarRecord(winner1 to Location(39)),
                            CarRecord(winner2 to Location(4)),
                            CarRecord(CarName("참가자") to Location(100))
                        )
                    ),
                    LapRecord(
                        listOf(
                            CarRecord(winner1 to Location(500)),
                            CarRecord(winner2 to Location(500)),
                            CarRecord(CarName("참가자") to Location(200))
                        )
                    )
                )

                val racingGameRecord = RacingGameRecord(lapRecords)

                racingGameRecord.winner() shouldBe listOf(winner1, winner2)
            }
        }
    }
})

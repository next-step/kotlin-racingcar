package racingcar.domain

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class RacingGameReportTest : DescribeSpec({

    describe("add") {
        it("랩 보고서(LapReport)를 추가할 수 있다") {
            val racingGameReport = RacingGameReport()
            val lapReport = LapReport(emptyList())

            racingGameReport.add(lapReport)

            val lapReports = racingGameReport.lapReports
            assertSoftly {
                lapReports shouldBe listOf(lapReport)
                lapReports.size shouldBe 1
            }
        }
    }

    describe("winner") {
        context("마지막 랩에 가장 많이 움직인 자동차를 우승자로 조회할 수 있다") {
            it("우승자는 한명일 수 있다") {
                val winner = CarName("우승자")
                val lapReports = listOf(
                    LapReport(
                        listOf(
                            CarNameWithLocation(winner to Location(0)),
                            CarNameWithLocation(CarName("참가자1") to Location(4)),
                            CarNameWithLocation(CarName("참가자2") to Location(3)),
                        )
                    ),
                    LapReport(
                        listOf(
                            CarNameWithLocation(winner to Location(5)),
                            CarNameWithLocation(CarName("참가자1") to Location(4)),
                            CarNameWithLocation(CarName("참가자2") to Location(3))
                        )
                    )
                )
                val racingGameReport = RacingGameReport(lapReports)

                racingGameReport.winner() shouldBe listOf(winner)
            }

            it("우승자는 한명 이상일 수 있다") {
                val winner1 = CarName("우승자1")
                val winner2 = CarName("우승자2")
                val lapReports = listOf(
                    LapReport(
                        listOf(
                            CarNameWithLocation(winner1 to Location(39)),
                            CarNameWithLocation(winner2 to Location(4)),
                            CarNameWithLocation(CarName("참가자") to Location(100))
                        )
                    ),
                    LapReport(
                        listOf(
                            CarNameWithLocation(winner1 to Location(500)),
                            CarNameWithLocation(winner2 to Location(500)),
                            CarNameWithLocation(CarName("참가자") to Location(200))
                        )
                    )
                )

                val racingGameReport = RacingGameReport(lapReports)

                racingGameReport.winner() shouldBe listOf(winner1, winner2)
            }
        }
    }
})

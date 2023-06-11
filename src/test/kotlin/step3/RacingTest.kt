package step3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldMatchInOrder
import io.kotest.matchers.shouldBe
import step3.test.toCarName

class RacingTest : FreeSpec(
    {
        "경주를 수행하면 소속된 자동차들이 이동 명령을 수행한다" - {
            val racingCars = listOf(
                buildAlwaysOperatingCar("5"),
                buildStationaryCar("3"),
                buildAlwaysOperatingCar("2"),
                buildAlwaysOperatingCar("4"),
                buildStationaryCar("1")
            )
            val sut = Racing(
                cars = racingCars
            )

            sut.race()

            racingCars shouldMatchInOrder listOf(
                { it.movedDistance shouldBe Distance(1) },
                { it.movedDistance shouldBe Distance(0) },
                { it.movedDistance shouldBe Distance(1) },
                { it.movedDistance shouldBe Distance(1) },
                { it.movedDistance shouldBe Distance(0) }
            )
            "경주 중인 차들의 이동 상태를 확인할 수 있다." - {
                val status = sut.currentStatus

                status shouldBe listOf(
                    CurrentCarStatus("5".toCarName(), Distance(1)),
                    CurrentCarStatus("3".toCarName(), Distance(0)),
                    CurrentCarStatus("2".toCarName(), Distance(1)),
                    CurrentCarStatus("4".toCarName(), Distance(1)),
                    CurrentCarStatus("1".toCarName(), Distance(0))
                )

                "추가 이동 2회" {
                    repeat(2) { sut.race() }

                    val secondStatus = sut.currentStatus

                    secondStatus shouldBe listOf(
                        CurrentCarStatus("5".toCarName(), Distance(3)),
                        CurrentCarStatus("3".toCarName(), Distance(0)),
                        CurrentCarStatus("2".toCarName(), Distance(3)),
                        CurrentCarStatus("4".toCarName(), Distance(3)),
                        CurrentCarStatus("1".toCarName(), Distance(0))
                    )
                }
            }
            "현재 게임의 우승자 이름을 확인할 수 있다" - {
                val winnerNames = sut.findCurrentWinnerNames()

                winnerNames shouldBe listOf(
                    "5", "2", "4"
                )
            }
        }
    }
)

private fun buildAlwaysOperatingCar(name: String): Car = Car(ConditionalOperatingCarEngine { true }, name.toCarName())
private fun buildStationaryCar(name: String): Car = Car(ConditionalOperatingCarEngine { false }, name.toCarName())

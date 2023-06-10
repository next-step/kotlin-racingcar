package step3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldMatchInOrder
import io.kotest.matchers.shouldBe

class RacingTest : FreeSpec(
    {
        "경주를 수행하면 소속된 자동차들이 이동 명령을 수행한다" - {
            val racingCars = listOf(
                buildAlwaysOperatingCar(),
                buildStationaryCar(),
                buildAlwaysOperatingCar(),
                buildAlwaysOperatingCar(),
                buildStationaryCar()
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
                val status = sut.showCurrentStatus()

                status shouldBe listOf(Distance(1), Distance(0), Distance(1), Distance(1), Distance(0))

                "추가 이동 2회" {
                    repeat(2) { sut.race() }

                    val secondStatus = sut.showCurrentStatus()

                    secondStatus shouldBe listOf(Distance(3), Distance(0), Distance(3), Distance(3), Distance(0))
                }
            }
        }
    }
)

private fun buildAlwaysOperatingCar(): Car = Car(ConditionalOperatingCarEngine { true })
private fun buildStationaryCar(): Car = Car(ConditionalOperatingCarEngine { false })

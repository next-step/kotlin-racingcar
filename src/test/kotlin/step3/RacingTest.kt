package step3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldMatchInOrder
import io.kotest.matchers.shouldBe

class RacingTest : FreeSpec(
    {
        "경주를 수행하면 소속된 자동차들이 이동 명령을 수행한다" {
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
                { it.showMovedDistance() shouldBe Distance(1) },
                { it.showMovedDistance() shouldBe Distance(0) },
                { it.showMovedDistance() shouldBe Distance(1) },
                { it.showMovedDistance() shouldBe Distance(1) },
                { it.showMovedDistance() shouldBe Distance(0) }
            )
        }
    }
)

private fun buildAlwaysOperatingCar(): Car = Car(ConditionalOperatingCarEngine { true })
private fun buildStationaryCar(): Car = Car(ConditionalOperatingCarEngine { false })

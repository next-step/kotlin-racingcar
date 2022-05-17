package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.CarRaceEvent
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldNotContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarTrackSnapshotTest {

    @DisplayName("자동차가 움직인 적 없는 경우 ⎼ 는 없다.")
    @Test
    fun shouldReturnOnlyCarName() {
        val carName = "tim"

        val events = listOf(
            CarRaceEvent(0, 0, false),
            CarRaceEvent(1, 0, false),
            CarRaceEvent(2, 0, false),
            CarRaceEvent(3, 0, false),
            CarRaceEvent(4, 0, false),
            CarRaceEvent(5, 0, false),
        )
        val carTraces = CarTrackSnapshot(Car(0, carName), events).toString()

        carTraces.shouldContain(carName)
        carTraces.shouldNotContain("⎼")
    }

    @DisplayName("자동차가 5번 움직인 경우 ⎼ 는 5개 이다.")
    @Test
    fun shouldReturnsTwoDash() {
        val carName = "tim"

        val events = listOf(
            CarRaceEvent(0, 0, true),
            CarRaceEvent(1, 0, true),
            CarRaceEvent(2, 0, true),
            CarRaceEvent(3, 0, false),
            CarRaceEvent(4, 0, true),
            CarRaceEvent(5, 0, true),
            CarRaceEvent(6, 0, false),
        )
        val carTraces = CarTrackSnapshot(Car(0, carName), events).toString()

        carTraces.shouldContain(carName)
        val dashCount = carTraces.count { it == '⎼' }
        dashCount.shouldBe(5)
    }
}

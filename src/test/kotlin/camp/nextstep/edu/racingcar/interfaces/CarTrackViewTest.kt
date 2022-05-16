package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.CarRaceEvent
import camp.nextstep.edu.racingcar.racing.InstantEngine
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldNotContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarTrackViewTest {

    @DisplayName("자동차가 트랙 5칸 중에 0칸을 달렸을때")
    @Test
    fun shouldReturnOnlyCarName() {
        val carName = "tim"
        val car = Car(0, carName, InstantEngine(0))
        val events = mutableListOf<CarRaceEvent>()

        events.add(car.race())
        events.add(car.race())
        events.add(car.race())
        events.add(car.race())
        events.add(car.race())

        val carTraces = CarTrackView(car, CarRaceEvent.merge(events)).toString()

        carTraces.shouldContain(carName)
        carTraces.shouldNotContain("⎼")
    }

    @DisplayName("자동차가 트랙 5칸 중에 2칸을 달렸을때")
    @Test
    fun shouldReturnsTwoDash() {
        val carName = "tim"
        val car = Car(0, carName, InstantEngine(2))
        val events = mutableListOf<CarRaceEvent>()

        events.add(car.race())
        events.add(car.race())
        events.add(car.race())
        events.add(car.race())
        events.add(car.race())

        val carTraces = CarTrackView(car, CarRaceEvent.merge(events)).toString()

        carTraces.shouldContain(carName)
        val dashCount = carTraces.count { it == '⎼' }
        dashCount.shouldBe(2)
    }

    @DisplayName("자동차가 트랙 5칸 중에 5칸을 달렸을때")
    @Test
    fun shouldReturnsFiveDash() {
        val carName = "tim"
        val car = Car(0, carName, InstantEngine(5))
        val events = mutableListOf<CarRaceEvent>()

        events.add(car.race())
        events.add(car.race())
        events.add(car.race())
        events.add(car.race())
        events.add(car.race())

        val carTraces = CarTrackView(car, CarRaceEvent.merge(events)).toString()

        carTraces.shouldContain(carName)
        val dashCount = carTraces.count { it == '⎼' }
        dashCount.shouldBe(5)
    }
}

package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.InstantEngine
import camp.nextstep.edu.racingcar.racing.Track
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
        val moveCount = 5
        val car = Car(0, carName, InstantEngine(0))
        val track = Track(moveCount)

        car.raceOn(track, moveCount)
        val carTraces = CarTrackView(car, track, moveCount).toString()

        carTraces.shouldContain(carName)
        carTraces.shouldNotContain("⎼")
    }

    @DisplayName("자동차가 트랙 5칸 중에 2칸을 달렸을때")
    @Test
    fun shouldReturnsTwoDash() {
        val carName = "tim"
        val moveCount = 5
        val car = Car(0, carName, InstantEngine(2))
        val track = Track(moveCount)

        car.raceOn(track, moveCount)
        val carTraces = CarTrackView(car, track, moveCount).toString()

        carTraces.shouldContain(carName)
        val dashCount = carTraces.count { it == '⎼' }
        dashCount.shouldBe(2)
    }

    @DisplayName("자동차가 트랙 5칸 중에 5칸을 달렸을때")
    @Test
    fun shouldReturnsFiveDash() {
        val carName = "tim"
        val moveCount = 5
        val car = Car(0, carName, InstantEngine(5))
        val track = Track(moveCount)

        car.raceOn(track, moveCount)
        val carTraces = CarTrackView(car, track, moveCount).toString()

        carTraces.shouldContain(carName)
        val dashCount = carTraces.count { it == '⎼' }
        dashCount.shouldBe(5)
    }
}

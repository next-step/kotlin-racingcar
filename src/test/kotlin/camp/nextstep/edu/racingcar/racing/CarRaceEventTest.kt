package camp.nextstep.edu.racingcar.racing

import camp.nextstep.edu.racingcar.racing.CarRaceEvent.Companion.merge
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarRaceEventTest {

    @DisplayName("자동차가 움직인 이벤트는 움직임 여부를 알 수 있다.")
    @Test
    fun movedCarRaceEventTest() {
        val movedEvent = CarRaceEvent(0, 0, true)
        assertTrue(movedEvent.moved)
    }

    @DisplayName("자동차가 움직이지 않은 이벤트는 움직임 여부를 알 수 있다.")
    @Test
    fun notMovedCarRaceEventTest() {
        val notMovedEvent = CarRaceEvent(0, 0, false)
        assertFalse(notMovedEvent.moved)
    }

    @DisplayName("여러 이벤트를 합치면 자동차가 달린 흔적을 알 수 있다.")
    @Test
    fun mergeCarRaceEventsTest() {
        val track = listOf(
            CarRaceEvent(0, 1, true),
            CarRaceEvent(1, 1, true),
            CarRaceEvent(2, 1, false),
            CarRaceEvent(3, 1, true),
            CarRaceEvent(4, 1, false),
            CarRaceEvent(5, 1, true),
        ).merge()

        assertEquals(4, track.marks())
    }

    @DisplayName("서로 다른 자동차의 이벤트는 합칠 수 없다.")
    @Test
    fun shouldFailMergeOtherCarsEventTest() {
        assertThrows<IllegalStateException> {
            listOf(
                CarRaceEvent(0, 1, true),
                CarRaceEvent(1, 2, true),
            ).merge()
        }
    }

    @DisplayName("이벤트가 없으면 합칠 수 없다.")
    @Test
    fun shouldFailMergeEmptyEvents() {
        assertThrows<IllegalArgumentException> {
            listOf<CarRaceEvent>().merge()
        }
    }
}

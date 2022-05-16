package camp.nextstep.edu.racingcar.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarTest {

    @DisplayName("자동차가 움직이면 이벤트가 발생한다.")
    @Test
    fun movedCarRaceEvent() {
        val id = 1
        val moveTwiceEngine = InstantEngine(1)
        val car = Car(id, "twice", moveTwiceEngine)

        val movedEvent = car.race()
        assertEquals(id, movedEvent.carId)
        assertTrue(movedEvent.moved)

        val notMovedEvent = car.race()
        assertEquals(id, notMovedEvent.carId)
        assertFalse(notMovedEvent.moved)
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없습니다.")
    @Test
    fun illegalCarNameTest() {
        val id = 1
        val moveTwiceEngine = InstantEngine(2)

        assertThrows<IllegalArgumentException> {
            Car(id, "다섯글자넘는자동차", moveTwiceEngine)
        }
    }
}

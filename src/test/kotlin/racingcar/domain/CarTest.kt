package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarTest {

    @Test
    internal fun `history에 CarAction이 잘 쌓이는지 테스트`() {
        val car = Car("test")
        car.moveOrStop(shouldMove = true)
        assertThat(car.history).isEqualTo(listOf(CarAction.MOVE))
        car.moveOrStop(shouldMove = false)
        assertThat(car.history).isEqualTo(listOf(CarAction.MOVE, CarAction.STOP))
    }

    @Test
    internal fun `각 자동차에 이름을 부여할 수 있다`() {
        val car = Car("김수현")
        assertThat(car.name).isEqualTo("김수현")
    }

    @Test
    internal fun `이름은 5글자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException> { Car("가나다라마바") }
    }

    @Test
    internal fun `자동차는 포지션이 있어야한다`() {
        val car = Car("test")
        car.moveOrStop(shouldMove = true)
        car.moveOrStop(shouldMove = false)
        car.moveOrStop(shouldMove = true)
        assertAll(
            { assertEquals(1, car.currentPosition(1)) },
            { assertEquals(1, car.currentPosition(2)) },
            { assertEquals(2, car.currentPosition(3)) },
        )
    }
}

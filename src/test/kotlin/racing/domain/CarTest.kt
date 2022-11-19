package racing.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @Test
    fun `자동차 생성 테스트(초기 위치는 0, 지정된 이름 확인)`() {
        // given
        val name = "name"

        // when
        val car = Car(name, forwardByOneMoveStrategy)

        // then
        assertEquals(name, car.name)
        assertEquals(0, car.position)
    }

    @ParameterizedTest(name = "name = \"{0}\"")
    @ValueSource(strings = ["", "   ", "name12", "name123"])
    fun `자동차 생성 예외 테스트(이름이 공백이거나 5자를 초과할 경우)`(wrongName: String) {
        // when & then
        assertThatThrownBy {
            Car(wrongName, forwardByOneMoveStrategy)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `앞으로 1씩 이동하는 자동차 테스트`() {
        // given
        val car = Car("name", forwardByOneMoveStrategy)

        // when
        car.move()

        // then
        assertEquals(1, car.position)
    }

    @Test
    fun `절대 이동하지 않는 자동차 테스트`() {
        // given
        val car = Car("name", stopMoveStrategy)

        // when
        car.move()

        // then
        assertEquals(0, car.position)
    }

    companion object {
        val forwardByOneMoveStrategy = MoveStrategy { 1 }

        val stopMoveStrategy = MoveStrategy { 0 }
    }
}

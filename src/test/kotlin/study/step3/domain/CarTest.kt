package study.step3

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.step3.domain.Car
import study.step3.domain.Moving
import study.step3.view.view

internal class CarTest {

    @MockK
    lateinit var moving: Moving

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `Car 초기 값 테스트`() {
        val car = Car(moving)

        assertThat(car.view.moved).isEqualTo(0)
        assertThat(car.view.state).isEqualTo("")
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `Move 할 수 있다`(isMovable: Boolean) {
        val car = Car(moving)

        every { moving.isMovable() } returns isMovable

        val moved = car.move()

        assertThat(moved).isEqualTo(isMovable.toInt())
    }

    @Test
    fun `Movable이 false일 때, 움직이지 않는다`() {
        val car = Car(moving)

        every { moving.isMovable() } returns false

        val moved = car.move()

        assertThat(moved).isEqualTo(0)
    }

    @Test
    fun `Movable이 true일 때, 움직인다`() {
        val car = Car(moving)

        every { moving.isMovable() } returns true

        val moved = car.move()

        assertThat(moved).isEqualTo(1)
    }

    @Test
    fun `움직인 후 State를 가져올 수 있다`() {
        val car = Car(moving)

        every { moving.isMovable() } returns true

        val moved = car.move()
        val state = car.view.state

        assertThat(moved).isEqualTo(1)
        assertThat(state).isEqualTo("-")
    }

    private fun Boolean.toInt() = if (this) 1 else 0
}

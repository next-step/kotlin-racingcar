package study.step3

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingCarTest {

    @MockK
    lateinit var moving: Moving

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `RacingCar 초기 값 테스트`() {
        val racingCar = RacingCar(moving)

        assertThat(racingCar.view.moved).isEqualTo(0)
        assertThat(racingCar.view.state).isEqualTo("")
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `Move 할 수 있다`(isMovable: Boolean) {
        val racingCar = RacingCar(moving)

        every { moving.isMovable() } returns isMovable

        val moved = racingCar.move()

        assertThat(moved).isEqualTo(isMovable.toInt())
    }

    @Test
    fun `Movable이 false일 때, 움직이지 않는다`() {
        val racingCar = RacingCar(moving)

        every { moving.isMovable() } returns false

        val moved = racingCar.move()

        assertThat(moved).isEqualTo(0)
    }

    @Test
    fun `Movable이 true일 때, 움직인다`() {
        val racingCar = RacingCar(moving)

        every { moving.isMovable() } returns true

        val moved = racingCar.move()

        assertThat(moved).isEqualTo(1)
    }

    @Test
    fun `움직인 후 State를 가져올 수 있다`() {
        val racingCar = RacingCar(moving)

        every { moving.isMovable() } returns true

        val moved = racingCar.move()
        val state = racingCar.view.state

        assertThat(moved).isEqualTo(1)
        assertThat(state).isEqualTo("-")
    }

    private fun Boolean.toInt() = if (this) 1 else 0
}

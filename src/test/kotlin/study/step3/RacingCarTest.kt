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
    fun `Moved 초기 값은 0이다`() {
        val racingCar = RacingCar(moving)

        assertThat(racingCar.getMoved()).isEqualTo(0)
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

    private fun Boolean.toInt() = if (this) 1 else 0
}

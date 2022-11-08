package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assumptions.assumingThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import racing.domain.strategy.RandomMovingStrategy

internal class CarTest {

    private lateinit var car: Car

    companion object {
        private val RANDOM_STRATEGY = RandomMovingStrategy()
        private const val ONE_MOVE_VALUE = Car.ONE_MOVE_VALUE
        private const val POSITION_MARK = Car.POSITION_MARK
    }

    @BeforeEach
    fun setUp() {
        car = Car(RANDOM_STRATEGY)
    }

    @RepeatedTest(5)
    fun `자동차 최초 정상 움직임`() {
        val initPosition = car.getPosition()
        val isMove = car.move()
        assumingThat(isMove) {
            assertThat(car.getPosition()).isEqualTo(ONE_MOVE_VALUE)
        }

        assumingThat(!isMove) {
            assertThat(car.getPosition()).isEqualTo(initPosition)
        }
    }

    @Test
    fun `이동에 따른 마크 정상 출력`() {
        (0..10).forEach { _ -> car.move() }
        assertThat(car.getPositionMark()).isEqualTo(POSITION_MARK.repeat(car.getPosition()))
    }
}

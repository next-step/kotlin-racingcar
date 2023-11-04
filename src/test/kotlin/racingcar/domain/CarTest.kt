package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarTest {

    private lateinit var strategy: StubRandomMovingStrategy
    private lateinit var car: Car

    @Test
    @DisplayName("값이 4이상이면 전진한다")
    fun move() {
        // given
        strategy.setCondition(4)

        // when
        car.move()

        // then
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    @DisplayName("값이 3이하면 전진하지 않는다")
    fun stop() {
        // given
        strategy.setCondition(3)

        // when
        car.move()

        // then
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @BeforeEach
    fun setUp() {
        strategy = StubRandomMovingStrategy()
        car = Car(movingStrategy = strategy)
    }
}

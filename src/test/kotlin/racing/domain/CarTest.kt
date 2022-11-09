package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racing.domain.strategy.RandomMovingStrategy

internal class CarTest {

    private lateinit var car: Car

    companion object {
        private val RANDOM_STRATEGY = RandomMovingStrategy()
    }

    @BeforeEach
    fun setUp() {
        car = Car(RANDOM_STRATEGY)
    }

    @Test
    fun `자동차 최초 position은 0이다`() {
        assertThat(car.position).isEqualTo(0)
    }
}

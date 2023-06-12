package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {

    private lateinit var car: Car
    private val RANDOM_MINIMUM = 0
    private val RANDOM_MAXIMUM = 9

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @Test
    fun `0부터 9사이 랜덤값 생성`() {
        assertThat(car.generateRandomNum())
            .isGreaterThanOrEqualTo(RANDOM_MINIMUM)
            .isLessThanOrEqualTo(RANDOM_MAXIMUM)
    }
}

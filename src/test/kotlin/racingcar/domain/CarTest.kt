package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assumptions.assumeTrue
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
    fun `자동차는 위치가 0으로 초기화`() {
        assertThat(car.getLocation()).isEqualTo(0)
    }

    @Test
    fun `자동차 이동 조건 숫자는 0부터 9사이 랜덤값 생성`() {
        assertThat(car.generateRandomNum())
            .isBetween(RANDOM_MINIMUM, RANDOM_MAXIMUM)
    }

    @Test
    fun `자동차 이동 조건을 만족하면 0에서 1로 이동한다`() {
        assumeTrue(car.isMoveOrStop())

        assertThat(car.getLocation()).isEqualTo(1)
    }
}

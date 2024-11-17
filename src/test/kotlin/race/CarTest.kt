package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @ParameterizedTest
    @CsvSource(value = ["0,1", "2,3"], delimiter = ',')
    fun `자동차 전진 가능`(
        position: Int,
        expected: Int,
    ) {
        val car = Car("a", position)

        car.move()

        assertThat(car).isEqualTo(Car("a", expected))
    }

    @Test
    fun `movedPosition 으로 위치 확인 가능`() {
        val car = Car("a", 1)

        assertThat(car.progress).isEqualTo(1)
    }
}

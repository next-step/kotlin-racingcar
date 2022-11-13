package step3.input.value

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NumberOfCarsTest {
    @DisplayName("NumberOfCars 생성 테스트")
    @Test
    fun `NumberOfCars 생성 테스트`() {
        val numberOfCars = NumberOfCars(3)
        assertThat(numberOfCars).isEqualTo(NumberOfCars(3))
    }

    @DisplayName("NumberOfCars 생성 예외처리 테스트")
    @Test
    fun `NumberOfCars 생성 예외처리 테스트`() {
        assertThatThrownBy { NumberOfCars(1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 대수는 1보다 커야 합니다.")
    }
}

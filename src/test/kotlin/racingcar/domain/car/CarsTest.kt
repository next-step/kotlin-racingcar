package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {
    @DisplayName("Cars 생성 테스트")
    @Test
    fun `Cars 생성 테스트`() {
        val cars = Cars(listOf(Car("pobi"), Car("crong"), Car("honux")))
        assertThat(cars).isEqualTo(Cars(listOf(Car("pobi"), Car("crong"), Car("honux"))))
    }

    @DisplayName("Cars 생성 예외처리 테스트")
    @Test
    fun `Cars 생성 예외처리 테스트`() {
        assertThatThrownBy { Cars(listOf()) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}

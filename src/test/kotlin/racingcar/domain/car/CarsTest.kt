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

    @DisplayName("입력된 자동차 대수가 1대 이하인 경우 예외처리")
    @Test
    fun `입력된 자동차 대수가 1대 이하인 경우`() {
        assertThatThrownBy { Cars(listOf(Car("pobi"))) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 2개 이상 입력해주세요.")
    }

    @DisplayName("입력된 자동차 이름이 중복인 경우 예외처리")
    @Test
    fun `입력된 자동차 이름이 중복인 경우`() {
        assertThatThrownBy { Cars(listOf(Car("pobi"), Car("crong"), Car("honux"), Car("pobi"))) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 중복될 수 없습니다.")
    }
}

package step3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarFactoryTest {
    @Test
    fun `입력 개수만큼 자동차 개수를 만들어내는지 확인`() {
        // given
        val cars = CarFactory.create(10)

        // then
        assertThat(cars.getCarDistances()).hasSize(10)
    }

    @ValueSource(ints = [0, -1])
    @ParameterizedTest
    fun `자동차를 0개 이하로 만드려는 경우 Exception`(amount: Int) {
        // then
        assertThatThrownBy { CarFactory.create(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차의 개수는 반드시 1개 이상입니다. 입력 값 : $amount")
    }
}

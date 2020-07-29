package step3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import step3.domain.CarFactory

class CarFactoryTest {
    @Test
    fun `입력 개수만큼 자동차 개수를 만들어내는지 확인`() {
        // given
        val cars = CarFactory.create(listOf("a", "b", "c"))

        // then
        assertThat(cars.getCurrentRacingRecords()).hasSize(3)
    }

    @Test
    fun `자동차를 0개로 만드려는 경우 Exception`() {
        // then
        assertThatThrownBy { CarFactory.create(listOf()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차의 개수는 반드시 1개 이상입니다. 입력 자동차 수 : 0")
    }
}

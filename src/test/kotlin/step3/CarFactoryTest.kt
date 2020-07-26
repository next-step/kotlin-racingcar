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
    // 이 테스트는 Cars 일급컬렉션에서 자동차 개수를 직접 알아올 수 없어서 간접적으로
    // Cars::getCarDistances 를 호출해서 개수를 비교했습니다. 이렇게 간접적으로 테스트하는것은
    // 좋지 않은 방법일까요? CarFactory를 테스트하려했는데 Cars를 테스트한 기분이라 영 찜찜합니다.
    // 그렇다고 테스트를 위한 코드를 넣고싶지는 않습니다. 테스트하기 힘든 구조가 된거라고 생각해야할까요?

    @ValueSource(ints = [0, -1])
    @ParameterizedTest
    fun `자동차를 0개 이하로 만드려는 경우 Exception`(amount: Int) {
        // then
        assertThatThrownBy { CarFactory.create(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차의 개수는 반드시 1개 이상입니다. 입력 값 : $amount")
    }
}

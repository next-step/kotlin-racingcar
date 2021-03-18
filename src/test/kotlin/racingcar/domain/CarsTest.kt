package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    internal fun `자동차 이름들로 Cars 객체를 생성할 수 있다`() {
        val cars = Cars(listOf("가", "나", "다"))
        assertThat(cars).containsAnyElementsOf(
            listOf(Car("가"), Car("나"), Car("다"))
        )
    }
}

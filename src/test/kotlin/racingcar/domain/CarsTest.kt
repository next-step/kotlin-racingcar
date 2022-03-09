package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    internal fun `자동차 이름들로 Cars 객체를 생성할 수 있다`() {
        val cars = Cars(listOf("가", "나", "다"))
        assertThat(cars).containsAnyOf(Car("가"), Car("나"), Car("다"))
    }

    @Test
    internal fun `가장 멀리 간 자동차가 우승자고 우승자는 한 명 이상일 수 있다`() {
        val cars = Cars(listOf("가", "나", "다"))
        cars[0].moveOrStop(shouldMove = true)
        cars[1].moveOrStop(shouldMove = true)
        cars[2].moveOrStop(shouldMove = false)
        assertThat(cars.winners())
            .containsExactly(Car("가"), Car("나"))
    }

    @Test
    internal fun `moveOrStopAll 테스트`() {
        val cars = Cars(listOf("가", "나", "다"))
        assertThat(cars.apply { moveOrStopAll { false } })
            .allSatisfy {
                assertThat(it.position(1)).isEqualTo(0)
            }
        assertThat(cars.apply { moveOrStopAll { true } })
            .allSatisfy {
                assertThat(it.position(2)).isEqualTo(1)
            }
    }
}

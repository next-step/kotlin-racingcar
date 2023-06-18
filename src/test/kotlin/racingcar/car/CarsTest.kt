package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차들을 생성할 수 있다`() {
        assertThatCode {
            Cars(ManualMoveStrategy(), 3)
        }.doesNotThrowAnyException()
    }

    @Test
    fun `자동차들의 이동경로를 문자열로 반환한다`() {
        val cars = Cars(ManualMoveStrategy(), 3)
        cars.move()
        assertThat(cars.getPathStrings())
            .containsExactly("--", "--", "--")
    }
}

package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 객체가 올바르게 생성되는지 확인한다`() {
        assertThat(Car("pobi")).isNotNull
    }
}

package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarFactoryTest {
    @Test
    fun `이름 목록을 입력받아 자동차를 만든다`() {
        val names = listOf("김씨", "이씨", "박씨")

        val cars = CarFactory.create(names)

        assertThat(cars).hasSize(names.size)
    }
}

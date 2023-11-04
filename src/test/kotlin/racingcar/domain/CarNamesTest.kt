package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarNamesTest {

    @Test
    fun `List가 주어지면 자동차이름 컬렉션을 생성한다`() {
        val input = listOf("일", "이", "삼", "사", "오")
        val carNames = CarNames(input)
        assertThat(carNames.size).isEqualTo(input.size)
    }
}

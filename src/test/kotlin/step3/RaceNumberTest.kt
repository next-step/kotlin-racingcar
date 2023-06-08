package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RaceNumberTest() {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `0부터 9까지의 정수는 RaceNumber로 생성`(givenNumber: Int) {
        assertThat(RaceNumber.from(givenNumber) is RaceNumber)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    fun `0부터 9까지의 정수가 아니면 IllegalArgumentException throw`(givenNumber: Int) {
        assertThrows<IllegalArgumentException> {
            RaceNumber.from(givenNumber)
        }
    }
}

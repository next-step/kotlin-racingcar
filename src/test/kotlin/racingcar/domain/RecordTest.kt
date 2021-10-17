package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RecordTest {

    @Test
    fun `자동차 목록을 기록하고 크기를 리턴한다`() {
        val record = Record(mapOf(1 to Cars.EMPTY))

        val actual = record.add(Pair(2, Cars.EMPTY))

        assertThat(actual.getSize()).isEqualTo(2)
    }

    @Test
    fun `자동차 목록의 데이터를 리턴한다`() {
        // given
        val givenCars = Cars.EMPTY
        val record = Record(mapOf(1 to givenCars))

        // when
        val actual = record[1]

        // then
        assertThat(actual).isEqualTo(givenCars)
    }
}

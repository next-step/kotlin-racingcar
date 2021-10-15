package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RecordTest {

    private lateinit var record: Record

    @BeforeEach
    internal fun setUp() {
        record = Record()
    }

    @Test
    fun `자동차 목록을 기록하고 크기를 리턴한다`() {
        record.add(1, Cars())
        record.add(2, Cars())

        assertThat(record.getSize()).isEqualTo(2)
    }

    @Test
    fun `자동차 목록의 데이터를 리턴한다`() {
        // given
        val givenCars = Cars()
        record.add(1, givenCars)

        // when
        val actual = record.getRecord(1)

        // then
        assertThat(actual).isEqualTo(givenCars)
    }
}

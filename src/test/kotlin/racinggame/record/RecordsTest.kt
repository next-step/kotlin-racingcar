package racinggame.record

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racinggame.record.domain.Records
import racinggame.record.dto.Record
import java.lang.IllegalArgumentException

internal class RecordsTest {

    @Test
    fun `현재 기록된 시간을 구한다`() {
        // given
        val records = Records(
            listOf(
                Record(1, "test1", 1)
            )
        )

        // when
        val time = records.getTime()

        // then
        assertThat(time).isEqualTo(1)
    }

    @Test
    fun `1등의 기록을 찾는다`() {
        // given
        val records = Records(
            listOf(
                Record(1, "test1", 1),
                Record(1, "test2", 2),
                Record(1, "test3", 3),
                Record(1, "test3", 3)
            )
        )

        // when
        val winners = records.findWinners()

        // then
        assertThat(winners).isEqualTo(
            listOf(
                Record(1, "test3", 3),
                Record(1, "test3", 3)
            )
        )
    }

    @Test
    fun `기록이 없으면 exception 발생`() {
        // given

        // when

        // then
        assertThatThrownBy { Records(emptyList()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("기록이 존재하지 않습니다.")
    }
}

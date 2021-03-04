package racinggame.record

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racinggame.record.domain.Recorder
import racinggame.record.domain.Records
import racinggame.record.dto.Record

internal class RecorderTest {
    @Test
    fun `우승한 기록을 찾는다`() {
        // given
        val records1 = Records(
            listOf(
                Record(1, "test1", 1),
                Record(1, "test2", 2),
                Record(1, "test3", 3),
                Record(1, "test3", 3)
            )
        )
        val records2 = Records(
            listOf(
                Record(2, "test1", 2),
                Record(2, "test2", 3),
                Record(2, "test3", 4),
                Record(2, "test3", 4)
            )
        )

        val recorder = Recorder(
            mutableListOf(
                records1,
                records2
            )
        )

        // when
        val winners = recorder.getWinners()

        // then
        assertThat(winners).isEqualTo(
            listOf(
                Record(2, "test3", 4),
                Record(2, "test3", 4)
            )
        )
    }

    @Test
    fun `기록이 없는데 우승자를 찾으려고 하면 exception`() {
        // given
        val emptyList = mutableListOf<Records>()

        // when
        val recorder = Recorder(emptyList)

        // then
        assertThatThrownBy { recorder.getWinners() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("녹화된 기록이 없습니다.")
    }
}

package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import support.Support.fixture

class RecordTest {

    @Test
    fun `Record에 차량 등록 성공`() {
        val carNames: List<String> = fixture<List<String>> { repeatCount { 3 } }
            .map { it.slice(0..4) }
        val record = Record.from(carNames)

        assertThat(carNames.sorted()).isEqualTo(record.raceRecords.keys.sorted())
    }
}
package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.RecordRepository.gameRecords
import racingcar.RecordRepository.recordDataSet
import racingcar.RecordRepository.save

class RecordRepositoryTest {
    private val cars = listOf(Car("a"), Car("b"))
    private val firstRecord = Record(cars)
    private val secondRecord = Record(cars)

    @Test
    fun `save a record and check recordDataSet and gameRecords`() {
        save(0, firstRecord)
        save(1, secondRecord)
        assertThat(recordDataSet.size).isEqualTo(2)
        assertThat(gameRecords.size).isEqualTo(2)
        assertThat(gameRecords[0].keys).containsOnly("a", "b")
        assertThat(gameRecords[1].keys).containsOnly("a", "b")

        // TODO random value 관련 : 각 차의 distance 확인해야 함
        // assertThat(gameRecords[0].values).isEqualTo()
        // assertThat(gameRecords[1].values).isEqualTo()
    }

    // TODO 메소드 내에 있는 변수들 테스트
    //  - 예: winners, finalCarNamesAndDistances, ...
    @Test
    fun `find winner`() {
    }
}

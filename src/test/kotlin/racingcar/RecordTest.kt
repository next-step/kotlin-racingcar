package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RecordTest {

    @Test
    fun `car names and distances`() {
        val cars = listOf(Car("a"), Car("b"))
        val record = Record(cars)
        Assertions.assertThat(record.carNamesAndDistances.keys).containsOnly("a", "b")

        // TODO random value test 관련 : 각 차의 distance 확인해야 함
        // Assertions.assertThat(record.carNamesAndDistances.values).isEqualTo()
    }
}

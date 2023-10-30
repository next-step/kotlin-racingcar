package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RaceManagerTest {
    @ParameterizedTest
    @ValueSource(strings = ["car1,car2", "car1,car2,", "car1,  car2", "car1, ,car2"])
    fun `자동차 목록 csv 파싱테스트`(input: String) {
        val moves = 1
        val manager = RaceManager(input, moves)
        assertThat(manager.carList.size).isEqualTo(2)
    }
}

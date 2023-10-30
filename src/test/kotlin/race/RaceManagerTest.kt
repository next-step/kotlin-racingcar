package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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

    @Test
    fun `우승자 판별 테스트`() {
        val manager = RaceManager("t1, t2, t3", 0)

        assertThat(manager.findWinners()).isEqualTo(manager.carList)

        manager.carList[0].move(SimpleCar.MOVE_THRESHOLD)
        assertThat(manager.findWinners().size).isEqualTo(1)
        assertThat(manager.findWinners().first().name).isEqualTo("t1")

        manager.carList[2].move(SimpleCar.MOVE_THRESHOLD)
        assertThat(manager.findWinners().size).isEqualTo(2)
        assertThat(manager.findWinners().joinToString(", ") { it.name }).isEqualTo("t1, t3")
    }
}

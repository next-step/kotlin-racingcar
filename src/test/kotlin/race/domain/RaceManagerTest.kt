package race.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceManagerTest {
    @Test
    fun `가장 멀리 이동한 자동차들이 공동우승한다`() {
        val manager = RaceManager(listOf("t1", "t2", "t3"), 0)

        assertThat(manager.findWinners()).isEqualTo(manager.carList)

        manager.carList[0].move(SimpleCar.MOVE_THRESHOLD)
        assertThat(manager.findWinners().size).isEqualTo(1)
        assertThat(manager.findWinners().first().name).isEqualTo("t1")

        manager.carList[2].move(SimpleCar.MOVE_THRESHOLD)
        assertThat(manager.findWinners().size).isEqualTo(2)
        assertThat(manager.findWinners().joinToString(", ") { it.name }).isEqualTo("t1, t3")
    }
}

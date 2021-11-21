package step4.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 *
 * @author Leo
 */
class MovingHistoryTest {

    val dummyOwnerName = CarName("car")

    @Test
    fun `이동 이력 제대로 쌓이는지 검증`() {

        // given
        val movingHistory = MovingHistory(dummyOwnerName)

        // when
        movingHistory.log(true)
        movingHistory.log(false)
        movingHistory.log(true)

        // then
        assertThat(movingHistory.getProgressBars().size).isEqualTo(3)
    }

    @Test
    fun `이동 이력 진행상태로 잘 변환되는지 검증`() {

        // given
        val movingHistory = MovingHistory(dummyOwnerName)

        // when
        movingHistory.log(true)  // "-"
        movingHistory.log(false) // "-"
        movingHistory.log(true)  // "--"

        // then
        assertThat(
            movingHistory.getProgressBars()[2].replace(
                "${movingHistory.owner.name}${MovingHistory.SEPERATOR}",
                MovingHistory.EMPTY
            )
        ).isEqualTo("--")
    }
}

package domain.step3.domain.game

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class GameRecordTest {

    @Test
    fun `GameRecord 생성시 빈 콜렉션이 들어오면 안 된다`() {
        assertThatThrownBy { GameRecord(listOf()) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("빈 List<RacingCars>는 들어올 수 없습니다.")
    }
}
package domain.step3.domain.game

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class GameRecordTest {

    @Test
    fun `GameRecord 생성시 빈 콜렉션이 들어오면 안 된다`() {
        assertThatThrownBy { GameRecord(listOf()) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("비어있는 값은 들어올 수 없습니다.")
    }
}
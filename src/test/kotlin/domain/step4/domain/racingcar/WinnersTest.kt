package domain.step4.domain.racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinnersTest {

    @Test
    fun `빈 컬렉션을 입력하면 예외를 발생한다`() {
        assertThatThrownBy { Winners.of(listOf()) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("비어있는 값은 들어올 수 없습니다.")
    }

}
package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun `Position 객체 생성 테스트`() {
        assertThatCode { Position(0) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `Position 객체 생성 시 음수를 입력하면 예외가 발생한다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Position(-1) }
            .withMessageContaining("음수는 입력할 수 없습니다.")
    }

    @Test
    fun `포지션을 증가 시킨다`() {
        val position = Position(0)
        position.add()
        assertThat(position.getPosition()).isEqualTo(1)
    }
}

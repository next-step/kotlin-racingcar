package racingcar.domain.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.exception.InvalidDriverNameException

class NameStrategyTest {
    @Test
    fun `string이 다섯글자를 초과하면 익셉션을 발생시킨다`() {
        val strategy = NameLengthLimitStrategy()

        val validName1 = "네글자다"
        val validName2 = "다섯글자임"
        val invalidName = "여섯글자작성"

        assertThat(strategy.validateName(validName1))
        assertThat(strategy.validateName(validName2))
        assertThrows<InvalidDriverNameException> { strategy.validateName(invalidName) }
    }
}

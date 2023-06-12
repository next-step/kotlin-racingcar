package racingcar.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.util.InputParser

class InputParserTest {
    @Test
    fun `쉼표 파싱 테스트`() {
        val carNames = "a,b,c"
        Assertions.assertThat(InputParser.parseCarNames(carNames).size).isEqualTo(3)
    }

    @Test
    fun `다른 구분자 파싱 테스트`() {
        val carNames = "a;b;c;d"
        Assertions.assertThat(InputParser.parseCarNames(carNames, separator = ";").size).isEqualTo(4)
    }
}

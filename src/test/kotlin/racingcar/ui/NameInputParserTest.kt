package racingcar.ui

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class NameInputParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["123456", "가나다, 가나다라마바사아"])
    fun `이름은 6글자보다 적어야 한다`(input: String) {
        Assertions.assertThatThrownBy {
            NameInputParser().parse(
                input
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}

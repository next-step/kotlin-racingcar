package domain.step2.strategy.split

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SingleBlankSplitStrategyTest {

    @DisplayName("SingleBlankSplitStrategy 인스턴스의 split() 기능 테스트")
    @ParameterizedTest(name = "문자열 : {0}, 예상 결과값: {1}")
    @CsvSource(value = ["a:1", "a b:2", "a b c:3"], delimiter = ':')
    fun split_test(expression: String, expected: Int) {
        val singleBlankSplitStrategy = SingleBlankSplitStrategy()
        val words = singleBlankSplitStrategy.split(expression)

        assertThat(words.size).isEqualTo(expected)
    }
}

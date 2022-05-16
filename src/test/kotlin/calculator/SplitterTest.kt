package calculator

import org.assertj.core.api.ListAssert
import org.junit.jupiter.api.Test

class SplitterTest {
    @Test()
    fun `전달받은 값에서 공백을 제외하고 숫자인 값들을 리스트 형태로 반환한다`() {
        ListAssert(Splitter.getNumbers("1 + 2 / 3 - 4 * 10")).isEqualTo(listOf(1, 2, 3, 4, 10))
    }

    @Test()
    fun `전달받은 값에서 공백을 제외하고 숫자가 아닌 값들을 리스트 형태로 반환한다`() {
        ListAssert(Splitter.getSymbols("1 + 2 / 3 - 4 * 10")).isEqualTo(listOf("+", "/", "-", "*"))
    }
}

package stringcalculator.splitter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("BlankSplitter 클래스")
class BlankSplitterTest {

    @Test
    fun `split 메서드는 공백을 기준으로 분리한 리스트를 반환한다`() {
        val actual = BlankSplitter.split("1 2 3 4 5   6  0")

        assertThat(actual).containsExactly("1", "2", "3", "4", "5", "6", "0")
    }
}

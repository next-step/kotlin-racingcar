package stringcalculator.extractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import stringcalculator.Number as Number

@DisplayName("OperandListExtractor 클래스")
class OperandListExtractorTest {

    @Test
    fun `extract 메서드는 짝수 번째 인덱스 정보를 추출한다`() {
        val items = listOf("1", "2", "3", "4", "5", "6")

        val actual = OperandListExtractor.extract(items)
        assertThat(actual).containsExactly(Number(1.0), Number(3.0), Number(5.0))
    }
}

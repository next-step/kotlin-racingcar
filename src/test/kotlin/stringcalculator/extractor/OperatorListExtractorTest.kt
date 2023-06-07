package stringcalculator.extractor

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import stringcalculator.Operator

@DisplayName("OperatorListExtractor 클래스")
class OperatorListExtractorTest {
    @Test
    fun `extract 메서드는 홀수 번째 인덱스 정보를 추출한다`() {
        val items = listOf("1", "+", "3", "-", "5")

        val actual = OperatorListExtractor.extract(items)
        Assertions.assertThat(actual).containsExactly(Operator.PLUS, Operator.MINUS)
    }
}

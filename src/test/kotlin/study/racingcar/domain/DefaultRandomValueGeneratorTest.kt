package study.racingcar.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.RepeatedTest

class DefaultRandomValueGeneratorTest {
    private val randomValueGenerator = DefaultRandomValueGenerator()

    @RepeatedTest(100) // 여러 번 반복 실행하여 랜덤성 검증
    fun `should generate a value between 0 and 9`() {
        // when
        val result = randomValueGenerator.invoke()

        // then
        assertTrue(result in 0..9, "Generated value should be between 0 and 9")
    }
}

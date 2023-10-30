package study.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import racing.Validate

class ValidateInputDataTest {

    @ParameterizedTest
    @MethodSource("validateInputTestData")
    fun `,검증 로직에 잘못된 입력값을 넣었을 때, 오류를 발생시킨다`(carCnt: String, racingCnt: String, expected: Exception) {
        // given

        // when : 검증로직에 잘못된 입력값을 넣는다.
        val actual = runCatching { Validate.validateInputData(carCnt, racingCnt) }.exceptionOrNull()

        // then : 오류가 발생한다
        assertThat(actual).isInstanceOf(expected::class.java)
    }

    companion object {
        @JvmStatic
        fun validateInputTestData() = listOf(
            arrayOf("", "", IllegalArgumentException()),
            arrayOf("d", "12", NumberFormatException()),
            arrayOf("3", "0", IllegalArgumentException()),
        )
    }
}

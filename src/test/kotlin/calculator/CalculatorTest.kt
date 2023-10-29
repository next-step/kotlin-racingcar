package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class `계산기 테스트(JUnit 5)` {

    @Nested
    class `정상적인 입력값일 경우` {

        @ParameterizedTest
        @CsvSource(
            value = [
                "2 + 3 * 4 / 2 = 10",
                "23 + 227 * 2 / 10 = 50"
            ],
            delimiter = '='
        )
        fun `사칙 연산 우선 순서 상관 없이 입력 값 순서대로 계산되어 반환한다`(input: String, expected: Int) {
            val actual = execute(input)
            assertThat(actual).isEqualTo(expected)
        }
    }

    @Nested
    class `비정상적인 입력값일 때` {

        @Nested
        class `입력값이 null이거나 빈 공백 문자일 경우` {

            @ParameterizedTest
            @NullAndEmptySource
            fun `IllegalArgumentException 예외를 던진다`(input: String?) {
                assertThrows<IllegalArgumentException> {
                    execute(input)
                }
            }
        }

        @Nested
        class `사칙연산 기호가 아닌 경우` {

            @ParameterizedTest
            @ValueSource(strings = ["2 & 7", "2 ^ 7", "2 \\ 3"])
            fun `IllegalArgumentException 예외를 던진다`(input: String) {
                assertThrows<IllegalArgumentException> {
                    execute(input)
                }
            }
        }

        @Nested
        class `첫번째 입력값이 숫자가 아닌 경우` {

            @ParameterizedTest
            @ValueSource(strings = ["/ 3", "^ 7", "\\ 3"])
            fun `IllegalArgumentException 예외를 던진다`(input: String) {
                assertThrows<IllegalArgumentException> {
                    execute(input)
                }
            }
        }
    }
}

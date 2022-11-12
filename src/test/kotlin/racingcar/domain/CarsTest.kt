package racingcar.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.NonNegative

class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `자동차 댓수 숫자를 입력 받아 컬렉션 생성 - 성공`(input: Int) {
        assertDoesNotThrow {
            Cars(NonNegative(input))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -2, -3, -4, -5])
    fun `자동차 댓수 숫자를 입력 받아 컬렉션 생성 - 실패`(input: Int) {
        assertThrows<IllegalArgumentException> {
            Cars(NonNegative(input))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5"])
    fun `자동차 댓수 문자열을 입력 받아 컬렉션 생성 - 성공`(input: Int) {
        assertDoesNotThrow {
            Cars(NonNegative(input))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "ㅁ", " ", "a", "b"])
    @EmptySource
    fun `자동차 댓수 문자열을 입력 받아 컬렉션 생성 - 실패`(input: String) {
        assertThrows<IllegalArgumentException> {
            Cars(NonNegative(input))
        }
    }
}

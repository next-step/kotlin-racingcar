package study.racingcar.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import study.racingcar.dto.Number

class NumberTest {

    @Test
    fun `입력받은 문자열로 Number 객체를 선언하고 정수형 숫자인지 검증 후 반환한다`() {
        //given
        val inputString = "1"

        // when
        val number = Number(inputString).toInt()

        // then
        assertEquals(1, number)
    }

    @Test
    fun `정수형 타입이 아닌 문자열을 입력 받았을 경우, 예외를 반환한다`() {
        //given
        val inputString = "가나라다"

        // when
        // then
        assertThrows<IllegalArgumentException> { Number(inputString).toInt() }
    }
}

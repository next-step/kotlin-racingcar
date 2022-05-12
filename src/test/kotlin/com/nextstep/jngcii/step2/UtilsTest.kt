package com.nextstep.jngcii.step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UtilsTest {
    @Test
    fun `string to requests converting 값 확인 테스트 (성공케이스)`() {
        val requests = "1 + 2 / 3 * -4 - 5".convertToRequests()

        assertEquals(
            listOf(1, 2, 3, -4, 5),
            requests.numbers.map { it.value }
        )

        assertEquals(
            listOf(Operator.PLUS, Operator.DIVIDE, Operator.MULTIPLY, Operator.MINUS),
            requests.operators
        )

        for (index in 0..3) {
            assertFalse(requests.numbers[index].isEnd)
        }
        assertTrue(requests.numbers[4].isEnd)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "- 1 + 2 / 3 * 4 - 5", // 연산자가 먼저 나오는 경우
            " 4 + -3 * -1", // 공백으로 시작하는 경우
            "4 + -3 * -1 ", // 공백으로 끝나는 경우
            "4 3 * -1", // 숫자가 연속하여 나오는 경우
            "- + -3 * -1", // 연산자가 연속하여 나오는 경우
            "a + -3 * -1", // 숫자가 아닌 것이 포함된 경우
        ]
    )
    fun `string to requests converting 실패 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { input.convertToRequests() }
    }
}

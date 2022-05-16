package com.nextstep.jngcii.step3.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RecordTest {

    @ParameterizedTest
    @CsvSource("3, 0", "3, 1", "3, 2")
    fun `write 성공 테스트`(carCount: Int, writeIndex: Int) {
        val record = Record(carCount)

        assertDoesNotThrow { record.write(writeIndex, true) }
    }

    @ParameterizedTest
    @CsvSource("3, -1", "3, 3")
    fun `write 실패 테스트`(carCount: Int, writeIndex: Int) {
        val record = Record(carCount)

        assertThrows<IllegalArgumentException>("0 <= n < $carCount 의 숫자만 입력 가능합니다.") {
            record.write(writeIndex, true)
        }
    }
}

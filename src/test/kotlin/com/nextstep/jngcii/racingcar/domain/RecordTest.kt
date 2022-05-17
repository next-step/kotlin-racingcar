package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RecordTest {

    @ParameterizedTest
    @CsvSource("3, 0", "3, 1", "3, 2")
    fun `write 성공 테스트`(carCount: Int, writeIndex: Int) {
        val record = Record(carCount, 5)

        assertDoesNotThrow { record.write(writeIndex, true) }
    }

    @ParameterizedTest
    @CsvSource("3, -1", "3, 3")
    fun `write 실패 테스트 - carIndex 오류`(carCount: Int, writeIndex: Int) {
        val record = Record(carCount, 5)

        assertThrows<IllegalArgumentException>("0 <= n < $carCount 의 숫자만 입력 가능합니다.") {
            record.write(writeIndex, true)
        }
    }

    @Test
    fun `write 실패 테스트 - 최대 전진 횟수 초과`() {
        val trialCount = 2
        val record = Record(5, trialCount)

        repeat(trialCount) {
            record.write(3, true)
        }

        assertThrows<IllegalStateException>("최대 전진 횟수는 시도 횟수보다 클 수 없습니다.") {
            record.write(3, true)
        }
    }

    @Test
    fun `canGo=false 일 때 goCount 추가되지 않는것 테스트`() {
        val trialCount = 3
        val record = Record(5, trialCount)

        assertThat(record.getGoCount(3)).isEqualTo(0)
        repeat(trialCount) { record.write(3, false) }
        assertThat(record.getGoCount(3)).isEqualTo(0)
    }

    @Test
    fun `canGo=true 호출 횟수만큼 goCount 적재되는것 테스트`() {
        val trialCount = 3
        val record = Record(5, trialCount)

        repeat(2) { record.write(3, true) }
        assertThat(record.getGoCount(3)).isEqualTo(2)
    }
}

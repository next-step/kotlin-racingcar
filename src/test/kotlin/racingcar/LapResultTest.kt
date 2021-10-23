package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.LapResult

class LapResultTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `LapResult의 movedDistance가 longestMovedDistance 미만일시 isNotWinner가 True 반환`(movedDistance: Int) {
        val longestMovedDistance = 10
        val lapResult = LapResult("TEST", movedDistance)
        assertThat(lapResult.isNotWinner(longestMovedDistance)).isTrue
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 11, 12, 13])
    fun `LapResult의 movedDistance가 longestMovedDistance 이상일시 isNotWinner가 False 반환`(movedDistance: Int) {
        val longestMovedDistance = 10
        val lapResult = LapResult("TEST", movedDistance)
        assertThat(lapResult.isNotWinner(longestMovedDistance)).isFalse
    }

    @ParameterizedTest
    @CsvSource(value = ["car10, 10", "car11, 11", "car12, 12", "car13, 13"])
    fun `LapResult의 toString호출시 '이름 이동거리' 형태로 String 반환`(carName: String, movedDistance: Int) {
        val lapResult = LapResult(carName, movedDistance)
        assertThat(lapResult.toString()).isEqualTo("$carName : ${"-".repeat(movedDistance)}")
    }
}

package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.LapResult

class LapResultTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `이동거리가 가장멀리 이동한 거리가 아닌경우 isNotWinner가 True 반환`(movedDistance: Int) {
        val longestMovedDistance = 10
        val lapResult = LapResult("TEST", movedDistance)
        assertThat(lapResult.isNotWinner(longestMovedDistance)).isTrue
    }

    @Test
    fun `이동거리가 가장멀리 이동한 거리인 경우 isNotWinner가 False 반환`() {
        val longestMovedDistance = 10
        val movedDistance = 10
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

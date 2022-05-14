package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * 클래스에 대한 설명을 적어주세요.
 * Created by Jaesungchi on 2022.05.12..
 */
class RaceResultTest {
    @Test
    fun `여러 차량중에서 유일한 승자를 제대로 판단하는가`() {
        val result = RaceResult(listOf(Car("hello").apply { advanceOnce() }, Car("good")))
        assertThat(result.winners[0]).isEqualTo("hello")
    }

    @Test
    fun `1등이 둘 이상인 상황에서 승자를 제대로 판단하는가`() {
        val result = RaceResult(listOf(Car("hello").apply { advanceOnce() }, Car("good").apply { advanceOnce() }))
        assertThat(result.winners.size).isEqualTo(2)
    }
}

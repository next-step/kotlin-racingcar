package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * 클래스에 대한 설명을 적어주세요.
 * Created by Jaesungchi on 2022.05.12..
 */
class RaceResultTest {
    @Test
    fun `승자가 제대로 정해졌는가`() {
        val result = RaceResult(listOf(Car("hello").apply { advanceOnce() }, Car("good")))
        assertThat(result.winners[0]).isEqualTo("hello")
    }

    @Test
    fun `승자가 둘 이상 제대로 정해졌는가`() {
        val result = RaceResult(listOf(Car("hello").apply { advanceOnce() }, Car("good").apply { advanceOnce() }))
        assertThat(result.winners.size).isEqualTo(2)
    }
}

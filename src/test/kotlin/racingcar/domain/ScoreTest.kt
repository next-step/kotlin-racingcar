package racingcar.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScoreTest {
    @Test
    fun `차의 위치(점수)를 확인 할 수 있다`() {
        val car = Car(7)
        val score = Score(car)
        score.point shouldBe 7
    }

    @Test
    fun `차의 움직이면 변경된 점수를 확인 할 수 있다`() {
        val car = Car(1)
        car.move()
        val score = Score(car)
        score.point shouldBe 2
    }

    @Test
    fun `생성된 자동차의 초기 위치는 0이다`() {
        val car = Car()
        val score = Score(car)
        score.point shouldBe 0
    }

    @Test
    fun `동일한 스코어 인지 확인 할 수 있다`() {
        val score = Score(7)
        assertThat(score.isSameScore(7)).isTrue
    }
}

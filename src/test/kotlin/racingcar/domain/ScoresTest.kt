package racingcar.domain

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ScoresTest {
    @Test
    fun `자동차 스코어 목록을 추가 할 수 있다`() {
        val score1 = Score(7)
        val score2 = Score(10)
        val score3 = Score(5)
        val scores = Scores(listOf(score1, score2, score3))
        scores.run {
            findAllScores()[0].point shouldBe 7
            findAllScores()[1].point shouldBe 10
            findAllScores()[2].point shouldBe 5
        }
    }

    @Test
    fun `자동차 스코어 목록을 추가한 횟수와 스코어 사이즈는 같다`() {
        val score1 = Score(7)
        val score2 = Score(10)
        val scores = Scores(listOf(score1, score2))
        scores.run {
            size() shouldBe 2
        }
    }

    @Test
    fun `자동차 경주 우승자 이름을 확인 할 수 있다`() {
        val score1 = Score(Car(5, CarName("aa")))
        val score2 = Score(Car(10, CarName("bb")))
        val score3 = Score(Car(33, CarName("cc")))
        val scores = Scores(listOf(score1, score2, score3))
        val winner = scores.findWinner()
        val nameList = winner.names.map { it.name }
        nameList[0] shouldBe "cc"
    }

    @Test
    fun `자동차 경주 우승자는 두명 이상 일 수 있다`() {
        val score1 = Score(Car(5, CarName("aa")))
        val score2 = Score(Car(10, CarName("bb")))
        val score3 = Score(Car(33, CarName("cc")))
        val score4 = Score(Car(33, CarName("dd")))
        val scores = Scores(listOf(score1, score2, score3, score4))
        val winner = scores.findWinner()
        winner.names.shouldContainExactly(
            CarName("cc"),
            CarName("dd"),
        )
    }
}

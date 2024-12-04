package racingcar.controller

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.dto.GameCondition
import racingcar.strategy.RandomNumberGeneratorStrategy

class RacingCarGameTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "9", "25"])
    fun `스코어의 결과 사이즈는 게임 라운드 수와 동일하다`(round: String) {
        val carNames = "a,b,c"
        val gameCondition = GameCondition(carNames, round)
        val racingCarGame = RacingCarGame(gameCondition, RandomNumberGeneratorStrategy())
        val scores = racingCarGame.startGame()
        scores.size shouldBe round.toInt()
    }
}

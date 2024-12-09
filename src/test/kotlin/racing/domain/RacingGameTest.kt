package racing.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatIllegalStateException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racing.view.GameInfo

class RacingGameTest {
//  [x] getCarCount : 자동차 댓수 테스트
//  [x] getCar : 자동차 생성 여부 테스트
//  [x] hasNextRound/nextRound -> 라운드 완료 테스트
//  [x] getWinners -> 우승자 테스트 (복수 가능)
//  [x] getWinnerNames -> 우승자 이름 테스트(복수 가능)
//  [x] getWinner -> 게임 중 테스트 (우승자 확인으로)

    @ParameterizedTest
    @CsvSource(
        "'pobi,crong,honux', 3",
        "'3,4', 2",
        "'a,6,_', 3",
    )
    fun `생성된 참여 자동차 댓수 테스트`(
        input: String,
        expected: Int,
    ) {
        val rounds = 5
        val racingGame = RacingGame(GameInfo(input, rounds))
        racingGame.getCarCount() shouldBe expected
    }

    @ParameterizedTest
    @CsvSource(
        "'pobi,crong,honux', 'pobi'",
        "'3,4', '3'",
        "'a,6,_', 'a'",
    )
    fun `생성한 첫번째 자동차 이름 확인`(
        input: String,
        expected: String,
    ) {
        val rounds = 5
        val racingGame = RacingGame(GameInfo(input, rounds))
        racingGame.getCar(0)?.name shouldBe expected
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4, 5])
    fun `라운드 완료 테스트`(input: Int) {
        val carNames = "pobi,crong,honux"
        val racingGame = RacingGame(GameInfo(carNames, input))
        repeat(input) {
            racingGame.nextRound()
        }
        racingGame.hasNextRound() shouldBe false
    }

    @Test
    fun `모든 참가자 공동 우승자 테스트`() {
        // controller 를 통해 여러 우승자를 만든다, position 0 / max
        val carNames = "pobi,crong,honux"
        val carNumber = 3
        val rounds = 5
        val doneMoveNumber = 3

        val racingGame = RacingGame(GameInfo(carNames, rounds), { doneMoveNumber })
        repeat(rounds) {
            racingGame.nextRound()
        }
        racingGame.getWinners().size shouldBe carNumber
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,crong,honux", "3,4", "1,2", "a,6,i,_"])
    fun `모든 참가자 공동 우승자 이름 테스트`(input: String) {
        // controller 를 통해 여러 우승자를 만든다, position 0 / max
        val carNames = input
        val rounds = 5
        val doneMoveNumber = 3

        val racingGame = RacingGame(GameInfo(carNames, rounds), { doneMoveNumber })
        repeat(rounds) {
            racingGame.nextRound()
        }
        racingGame.getWinnerNames() shouldBe carNames
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 3])
    fun `게임 중 테스트`(input: Int) {
        val carNames = "pobi,crong,honux"
        val racingGame = RacingGame(GameInfo(carNames, input))
        racingGame.nextRound()
        racingGame.nextRound()

        assertThatIllegalStateException().isThrownBy { racingGame.getWinners() }
    }
}

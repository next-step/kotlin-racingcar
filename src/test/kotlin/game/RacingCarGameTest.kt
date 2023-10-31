package game

import game.domain.History
import game.domain.MoveConditionGenerator
import game.view.UserInputHandler
import game.view.UserOutputHandler
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.mockito.Mockito.mock
import org.mockito.kotlin.given

class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource(value = ["4:3:5:5:pobi,honux", "3:4:5:4:crong,honux", "4:3:3:4:pobi"], delimiter = ':')
    fun `레이싱 게임이 시작하면 자동차 이름과 시도 회수를 입력받고 매 라운드 마다 기록하고 우승자를 기록한다`(
        pobiCondition: Int,
        crongCondition: Int,
        honuxCondition: Int,
        retryCount: Int,
        expect: String
    ) {
        // given
        val userInputHandler = mock(UserInputHandler::class.java)
        given(userInputHandler.askForCarNames()).willReturn("pobi,crong,honux")
        given(userInputHandler.askForRetryCount()).willReturn(retryCount.toString())

        var expectHistory = History()
        val userOutputHandler = UserOutputHandler { history -> expectHistory = history }

        val moveConditionGenerator = CyclingMoveConditionGenerator(pobiCondition, crongCondition, honuxCondition)

        val racingCarGame = RacingCarGame(userInputHandler, userOutputHandler, moveConditionGenerator)

        // when
        racingCarGame.start()

        // then
        assertAll(
            { Assertions.assertThat(expectHistory.rounds.size).isEqualTo(retryCount) },
            { Assertions.assertThat(expectHistory.winners).usingRecursiveComparison().isEqualTo(expect.split(",")) }
        )
    }

    class CyclingMoveConditionGenerator(condition1: Int, condition2: Int, condition3: Int) : MoveConditionGenerator {
        private val conditions = listOf(condition1, condition2, condition3)
        private var currentIndex = 0

        override fun generate(): Int {
            val condition = conditions[currentIndex]
            currentIndex = (currentIndex + 1) % conditions.size
            return condition
        }
    }
}

package racinggame.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RacingGameControllerTest : BehaviorSpec({

    val mockRacingGameInputView = MockRacingGameInputView()
    val mockRacingGameOutputView = MockRacingGameOutputView()
    val mockRacingGame = MockRacingGame()

    beforeTest {
        mockRacingGameInputView.clear()
        mockRacingGameOutputView.clear()
        mockRacingGame.clear()
    }

    Given("화면에 진입하면") {
        Then("자동차 이름들을 입력 받기 위한 안내 메시지가 출력된다") {
            RacingGameController(
                mockRacingGameInputView.apply { setUp("1", "1") },
                mockRacingGameOutputView,
                mockRacingGame
            ).start()

            mockRacingGameOutputView.fixedMessagesCapture[0] shouldBe RacingGameFixedMessage.CAR_NAMES_INPUT
        }
    }

    Given("자동차 이름들을 입력 받기 위한 안내 메시지 출력 후") {
        When("빈칸이거나 5자르 초과하는 이름이 한개라도 입력되면") {
            forAll(
                row(",a,a"),
                row("a,,a"),
                row("a,a,"),
                row("123456,a,a"),
                row("a,123456,a"),
                row("a,a,123456"),
            ) { userNames ->
                Then("에러로 인한 종료 메시지가 출력된다") {
                    RacingGameController(
                        mockRacingGameInputView.apply { setUp(userNames) },
                        mockRacingGameOutputView,
                        mockRacingGame
                    ).start()

                    mockRacingGameOutputView.fixedMessagesCapture[1] shouldBe RacingGameFixedMessage.FINISH_WITH_INVALID_NAME
                }
            }
        }

        When("빈칸도 아니며 5자 이내인 이름으로 모두 입력되면") {
            Then("게임 횟수를 입력 받기 위한 안내 메시지가 출력된다") {
                RacingGameController(
                    mockRacingGameInputView.apply { setUp("a,b", "1") },
                    mockRacingGameOutputView,
                    mockRacingGame
                ).start()

                mockRacingGameOutputView.fixedMessagesCapture[1] shouldBe RacingGameFixedMessage.GAME_PLAY_COUNT_INPUT
            }
        }
    }

    Given("게임 횟수를 입력 받기 위한 안내 메시지 출력 후") {
        When("양의 정수가 아닌 문자를 입력하면") {
            forAll(
                row("a,b", "a"),
                row("a,b", "-1"),
                row("a,b", "0"),
            ) { userNames, noPositiveInteger ->
                Then("에러로 인한 종료 메시지가 출력된다") {
                    RacingGameController(
                        mockRacingGameInputView.apply { setUp(userNames, noPositiveInteger) },
                        mockRacingGameOutputView,
                        mockRacingGame
                    ).start()

                    mockRacingGameOutputView.fixedMessagesCapture[2] shouldBe RacingGameFixedMessage.FINISH_WITH_NOT_POSITIVE_INTEGER
                }
            }
        }

        When("양의 정수를 입력하면") {
            forAll(
                row("a,b", "1"),
                row("a,b", "2"),
                row("a,b", "3"),
            ) { userNames, gamePlayCount ->
                Then("입력된 데이터로 게임에 입장한다") {
                    RacingGameController(
                        mockRacingGameInputView.apply { setUp(userNames, gamePlayCount) },
                        mockRacingGameOutputView,
                        mockRacingGame
                    ).start()

                    mockRacingGame.gameGuideCapture?.users?.map { it.carName.value } shouldBe listOf("a", "b")
                    mockRacingGame.gameGuideCapture?.gameRule?.playCount shouldBe gamePlayCount.toInt()
                }
            }
        }
    }
})

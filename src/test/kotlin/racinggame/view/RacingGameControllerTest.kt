package racinggame.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RacingGameControllerTest : BehaviorSpec({

    val testRacingGameInputView = TestRacingGameInputView()
    val testRacingGameOutputView = TestRacingGameOutputView()
    val testRacingGame = TestRacingGame()

    beforeTest {
        testRacingGameInputView.clear()
        testRacingGameOutputView.clear()
        testRacingGame.clear()
    }

    Given("화면에 진입하면") {
        Then("자동차 수를 입력 받기 위한 안내 메시지가 출력된다") {
            RacingGameController(
                testRacingGameInputView.apply { setUp("1", "1") },
                testRacingGameOutputView,
                testRacingGame
            ).start()

            testRacingGameOutputView.fixedMessagesCapture[0] shouldBe RacingGameFixedMessage.PARTICIPANTS_INPUT
        }
    }

    Given("자동차 수를 입력 받기 위한 안내 메시지 출력 후") {
        When("양의 정수가 아닌 문자를 입력하면") {
            forAll(
                row("a"),
                row("-1"),
                row("0"),
            ) { noPositiveInteger ->
                Then("에러로 인한 종료 메시지가 출력된다") {
                    RacingGameController(
                        testRacingGameInputView.apply { setUp(noPositiveInteger) },
                        testRacingGameOutputView,
                        testRacingGame
                    ).start()

                    testRacingGameOutputView.fixedMessagesCapture[1] shouldBe RacingGameFixedMessage.FINISH_WITH_NOT_POSITIVE_INTEGER
                }
            }
        }

        When("양의 정수를 입력하면") {
            Then("게임 횟수를 입력 받기 위한 안내 메시지가 출력된다") {
                RacingGameController(
                    testRacingGameInputView.apply { setUp("1", "1") },
                    testRacingGameOutputView,
                    testRacingGame
                ).start()

                testRacingGameOutputView.fixedMessagesCapture[1] shouldBe RacingGameFixedMessage.GAME_PLAY_COUNT_INPUT
            }
        }
    }

    Given("게임 횟수를 입력 받기 위한 안내 메시지 출력 후") {
        When("양의 정수가 아닌 문자를 입력하면") {
            forAll(
                row("1", "a"),
                row("1", "-1"),
                row("1", "0"),
            ) { positiveInteger, noPositiveInteger ->
                Then("에러로 인한 종료 메시지가 출력된다") {
                    RacingGameController(
                        testRacingGameInputView.apply { setUp(positiveInteger, noPositiveInteger) },
                        testRacingGameOutputView,
                        testRacingGame
                    ).start()

                    testRacingGameOutputView.fixedMessagesCapture[2] shouldBe RacingGameFixedMessage.FINISH_WITH_NOT_POSITIVE_INTEGER
                }
            }
        }

        When("양의 정수를 입력하면") {
            forAll(
                row("1", "1"),
                row("2", "2"),
                row("3", "3"),
            ) { participantsCount, gamePlayCount ->
                Then("입력된 데이터로 게임에 입장한다") {
                    RacingGameController(
                        testRacingGameInputView.apply { setUp(participantsCount, gamePlayCount) },
                        testRacingGameOutputView,
                        testRacingGame
                    ).start()

                    testRacingGame.gameGuideCapture?.users?.size shouldBe participantsCount.toInt()
                    testRacingGame.gameGuideCapture?.gameRule?.playCount shouldBe gamePlayCount.toInt()
                }
            }
        }
    }
})

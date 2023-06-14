package racinggame.domain.game

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racinggame.domain.car.CarName
import racinggame.domain.car.engine.MockNotMoveEngine
import racinggame.domain.car.engine.MockOneSpaceMovementEngine
import racinggame.domain.car.factory.MockRacingCarFactory
import racinggame.domain.player.User
import racinggame.domain.player.UserUniqueId

class RealRacingGameTest : BehaviorSpec({

    Given("참가자들과 게임 룰이 준비 되었을 때") {
        val users = List(3) { index ->
            User(
                id = UserUniqueId.create(),
                carName = CarName("test"),
                ordinal = index,
            )
        }
        val playCount = 2
        val gameGuide = GameGuide(
            users = users,
            gameRule = GameRule(playCount = 2),
        )
        When("레이싱 게임을 실행하면") {
            Then("게임 룰 만큼의 경주 기록을 반환한다") {
                val racingGame = RealRacingGame(MockRacingCarFactory(MockNotMoveEngine()))
                val result = racingGame.execute(gameGuide)
                result.racingRecordBook.totalRacingRecordPaperList.size shouldBe playCount
            }
            Then("참가한 참가자들의 순서대로 경주 기록을 반환한다") {
                val racingGame = RealRacingGame(MockRacingCarFactory(MockNotMoveEngine()))
                val result = racingGame.execute(gameGuide)
                result.racingRecordBook
                    .totalRacingRecordPaperList
                    .forEach { racingRecordPaperList ->
                        val actual = racingRecordPaperList.list
                            .map { racingRecordPaper -> racingRecordPaper.user }
                        actual shouldBe users
                    }
            }
            forAll(
                row(setOf(users[0])),
                row(setOf(users[0], users[1])),
                row(setOf(users[0], users[2])),
                row(setOf(users[1], users[2])),
                row(setOf(users[0], users[1], users[2])),
            ) { winners ->
                Then("우승자들을 반환한다") {
                    val racingGame = RealRacingGame(
                        MockRacingCarFactory(
                            getEngine = { user ->
                                if (winners.contains(user)) {
                                    MockOneSpaceMovementEngine()
                                } else {
                                    MockNotMoveEngine()
                                }
                            }
                        )
                    )
                    val result = racingGame.execute(gameGuide)
                    result.winners shouldBe winners
                }
            }
        }
    }
})

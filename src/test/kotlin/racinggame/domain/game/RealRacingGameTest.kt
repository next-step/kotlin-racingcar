package racinggame.domain.game

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racinggame.domain.car.RacingCar
import racinggame.domain.car.engine.MockOneSpaceMovementEngine
import racinggame.domain.car.factory.RacingCarFactory
import racinggame.domain.player.User
import racinggame.domain.player.UserUniqueId

class RealRacingGameTest : BehaviorSpec({

    Given("참가자들과 게임 룰이 준비 되었을 때") {
        val users = List(2) { index ->
            User(id = UserUniqueId.create(), ordinal = index)
        }
        val playCount = 2
        When("레이싱 게임을 실행하면") {
            val racingGame = RealRacingGame(object : RacingCarFactory {
                override fun create(user: User): RacingCar {
                    return RacingCar(
                        user = user,
                        engine = MockOneSpaceMovementEngine(),
                    )
                }
            })
            val result = racingGame.execute(
                gameGuide = GameGuide(
                    users = users,
                    gameRule = GameRule(playCount = playCount),
                )
            )
            Then("게임 룰 만큼의 경주 기록을 반환한다") {
                result.racingRecordBook.totalRacingRecordPaperList.size shouldBe playCount
            }
            Then("참가한 참가자들의 순서대로 경주 기록을 반환한다") {
                result.racingRecordBook
                    .totalRacingRecordPaperList
                    .forEach { racingRecordPaperList ->
                        val actual = racingRecordPaperList.list
                            .map { racingRecordPaper -> racingRecordPaper.user }
                        actual shouldBe users
                    }
            }
        }
    }
})

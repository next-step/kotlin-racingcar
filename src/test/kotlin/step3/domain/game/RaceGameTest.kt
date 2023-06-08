package step3.domain.game

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import step3.model.RaceGameErrorCode

class RaceGameTest : DescribeSpec({

    describe(name = "레이스 게임 시작할 때") {
        context(name = "자동차 개수가 지정된 개수보다 낮으면") {
            val raceGameInfo = RaceGameInfo(
                carCount = 0,
                round = 5,
            )

            val exception = shouldThrow<IllegalArgumentException> {
                RaceGame(raceGameInfo = raceGameInfo)
            }

            it(name = "시작할 수 없다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.INVALID_CAR_COUNT.message("1 ${raceGameInfo.carCount}")
            }
        }
    }

    describe(name = "레이스 게임 시작한 후") {
        context(name = "라운드가 모두 소진되었으면") {
            val raceGameInfo = RaceGameInfo(
                carCount = 3,
                round = 0,
            )

            val raceGame = RaceGame(raceGameInfo = raceGameInfo)

            val exception = shouldThrow<IllegalStateException> {
                raceGame.race()
            }

            it(name = "게임을 시작하면 남은 라운드 수가 없다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.NOT_REMAINING_ROUND.message("${raceGameInfo.round}")
            }

            val progress = raceGame.isProgress()

            it(name = "진행 여부를 호출하면 진행 중이지 않음을 반환한다.") {
                progress shouldBe false
            }
        }

        context(name = "라운드가 남아있는 상태에서") {
            val raceGameInfo = RaceGameInfo(
                carCount = 10,
                round = 10,
            )

            val raceGame = RaceGame(raceGameInfo = raceGameInfo)

            val currentPosition = raceGame.race()

            it(name = " 게임을 시작하면 자동차 숫자만큼 현재 위치를 반환한다.") {
                currentPosition.size shouldBe raceGameInfo.carCount
            }

            val progress = raceGame.isProgress()

            it(name = "진행 여부를 호출하면 진행 중임을 반환한다.") {
                progress shouldBe true
            }
        }
    }
})

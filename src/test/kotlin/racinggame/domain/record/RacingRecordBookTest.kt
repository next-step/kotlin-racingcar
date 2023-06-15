package racinggame.domain.record

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racinggame.domain.car.CarName
import racinggame.domain.field.MoveDistance
import racinggame.domain.player.User
import racinggame.domain.player.UserUniqueId

class RacingRecordBookTest : BehaviorSpec({

    Given("레이싱 기록들로 객체를 생성하면") {
        fun mockRacingRecordPaperList(size: Int): RacingRecordPaperList {
            val racingRecordPapers = List(size) { index ->
                RacingRecordPaper(
                    user = User(
                        id = UserUniqueId.create(),
                        carName = CarName("test"),
                        ordinal = index,
                    ),
                    moveDistance = MoveDistance(0)
                )
            }
            return RacingRecordPaperList(
                list = racingRecordPapers,
            )
        }

        val racingRecordPapers1 = mockRacingRecordPaperList(size = 1)
        val racingRecordPapers2 = mockRacingRecordPaperList(size = 2)
        val racingRecordPapers3 = mockRacingRecordPaperList(size = 3)

        forAll(
            row(racingRecordPapers1, racingRecordPapers2, racingRecordPapers3),
            row(racingRecordPapers1, racingRecordPapers3, racingRecordPapers2),
            row(racingRecordPapers3, racingRecordPapers2, racingRecordPapers1),
        ) { firstRound, secondRound, thirdRound ->
            val racingRecordBook = RacingRecordBook(
                totalRacingRecordPaperList = listOf(
                    firstRound,
                    secondRound,
                    thirdRound
                ),
            )

            Then("가장 마지막 라운드를 갖고 있다") {
                racingRecordBook.finalRound shouldBe thirdRound
            }
        }
    }
})

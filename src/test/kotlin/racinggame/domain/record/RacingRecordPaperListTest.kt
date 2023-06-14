package racinggame.domain.record

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racinggame.domain.car.CarName
import racinggame.domain.field.MoveDistance
import racinggame.domain.player.User
import racinggame.domain.player.UserUniqueId

class RacingRecordPaperListTest : BehaviorSpec({

    Given("레이싱 기록들로 객체를 생성하면") {
        val mockUsers = List(3) { index ->
            User(
                id = UserUniqueId.create(),
                carName = CarName("test"),
                ordinal = index
            )
        }

        forAll(
            row(mockUsers, listOf(mockUsers[0])),
            row(mockUsers, listOf(mockUsers[1])),
            row(mockUsers, listOf(mockUsers[2])),
            row(mockUsers, listOf(mockUsers[0], mockUsers[1])),
            row(mockUsers, listOf(mockUsers[0], mockUsers[2])),
            row(mockUsers, listOf(mockUsers[1], mockUsers[2])),
            row(mockUsers, listOf(mockUsers[0], mockUsers[1], mockUsers[2])),
        ) { users, moveUsers ->
            val moveUserSet = moveUsers.toSet()
            val racingRecordPapers = users.map { user ->
                RacingRecordPaper(
                    user = user,
                    moveDistance = MoveDistance(if (moveUserSet.contains(user)) 1 else 0)
                )
            }
            val racingRecordPaperList = RacingRecordPaperList(racingRecordPapers)

            Then("객체는 가장 멀리 이동한 유저들을 갖고 있다") {
                racingRecordPaperList.maxMoveDistanceUsers shouldBe moveUsers
            }
        }
    }
})

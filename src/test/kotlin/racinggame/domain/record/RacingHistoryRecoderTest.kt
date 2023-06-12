package racinggame.domain.record

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racinggame.domain.car.RacingCar
import racinggame.domain.car.engine.DrivableDistance
import racinggame.domain.car.engine.MockEngine
import racinggame.domain.car.factory.RacingCarUniqueKey
import racinggame.domain.field.Field
import racinggame.domain.field.MoveDistance
import racinggame.domain.field.RacingFieldMiniMap
import racinggame.domain.player.User

class RacingHistoryRecoderTest : BehaviorSpec({

    Given("레이싱 필드 맵에 데이터가 존재할 때") {
        val racingCars = List(2) { index ->
            RacingCar(
                uniqueKey = RacingCarUniqueKey(index.toString()),
                user = User(
                    id = index.toString(),
                    ordinal = index,
                ),
                engine = MockEngine(fixedDrivableDistance = DrivableDistance(0)),
            )
        }
        val fixedMoveDistance = MoveDistance(
            startPosition = 0,
            currentPosition = 1
        )
        val racingFieldMiniMap = object : RacingFieldMiniMap {
            override val racingFieldMap: Map<RacingCarUniqueKey, Field> = buildMap {
                racingCars.forEach { racingCar ->
                    put(
                        key = racingCar.uniqueKey,
                        value = Field(
                            racingCar = racingCar,
                            moveDistance = fixedMoveDistance
                        )
                    )
                }
            }
        }

        When("레이싱 기록자가 맵을 촬영한 뒤 책을 만들면") {
            val racingHistoryRecoder = RacingHistoryRecoder()
            racingHistoryRecoder.capture(racingFieldMiniMap)

            Then("필드 맵에 존재하는 데이터로 레이싱 기록 책이 만들어진다") {
                val actual = racingHistoryRecoder.createBook()
                val expected = RacingRecordBook(
                    totalRacingRecordPaperList = listOf(
                        RacingRecordPaperList(
                            list = racingCars.map { racingCar ->
                                RacingRecordPaper(
                                    user = racingCar.user,
                                    moveDistance = fixedMoveDistance
                                )
                            }
                        )
                    )
                )
                actual shouldBe expected
            }
        }
    }
})

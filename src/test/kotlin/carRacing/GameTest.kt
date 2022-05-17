package carRacing

import carRacing.controller.Game
import carRacing.controller.Game.Companion.INVALID_CAR_LIST
import carRacing.controller.Game.Companion.INVALID_NUM_MOVEMENT
import carRacing.model.Car
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class GameTest : FreeSpec({

    "init" - {

        "유효하지 않은 자동차 이름 입력이 들어올 경우 IllegalArgumentException" {
            val carNameList: List<String> = listOf()
            val numMovement = 5
            val exception = shouldThrow<IllegalArgumentException> {
                Game(carNameList, numMovement)
            }
            exception.message shouldBe INVALID_CAR_LIST
        }

        "유효하지 않은 시도 횟수가 들어올 경우 IllegalArgumentException" {
            val carNameList = listOf("uju")
            val numMovement = 0
            val exception = shouldThrow<IllegalArgumentException> {
                Game(carNameList, numMovement)
            }
            exception.message shouldBe INVALID_NUM_MOVEMENT
        }
    }

    "move" - {

        "랜덤 값이 4 이상일 경우 자동차의 포지션 +1이 되어야한다." {
            val carName = "test"
            val car = Car(carName)
            val game = Game(listOf(carName), 1)

            game.move(car, 5)

            car.position shouldBe 1
        }

        "랜덤 값이 4 미만일 경우 자동차는 움직이지 않아야한다." {
            val carName = "test"
            val car = Car(carName)
            val game = Game(listOf(carName), 1)

            game.move(car, 1)

            car.position shouldBe 0
        }
    }

    "run" - {

        "오류 없이 실행되어야한다." {
            // given
            val carNameList = listOf("uju", "test")
            val numMovement = 5
            val game = Game(carNameList, numMovement)

            // when
            game.run()

            // then
            game.recordList.size shouldBe numMovement
            game.recordList.forEach {
                it.positions.size shouldBe carNameList.size
            }
        }
    }

    "winner" - {

        "우승한 자동차 리스트를 반환한다." {
            val carNameList = listOf("uju", "test")
            val numMovement = 3
            val game = Game(carNameList, numMovement)
            game.run()

            val carList = game.winner()
            print(carList)

            carList[0].shouldBeInstanceOf<Car>()
        }
    }
})

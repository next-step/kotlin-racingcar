package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

internal class CarRecorderTest : BehaviorSpec({
    Given("게임 1 turn이 진행될 때 마다") {
        val carRecorder = CarRecorder()
        When("게임 결과가 정상적이라면") {
            val cars = listOf(
                Car(id = 0, currentPosition = 0, name = "car1"),
                Car(id = 1, currentPosition = 0, name = "car2")
            )
            carRecorder.recording(1, cars)
            Then("게임 기록을 저장할 수 있다.") {
                shouldNotThrowAny { carRecorder.recording(1, cars) }
            }
        }

        When("게임 결과가 비정상적이라면") {
            Then("게임 기록을 저장할 수 없고 예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> { carRecorder.recording(1, emptyList()) }
            }
        }
    }

    Given("게임 각 turn에 대한") {
        When("게임 기록이 있다면") {
            val carRecorder = CarRecorder()
            val cars = listOf(
                Car(id = 0, currentPosition = 0, name = "car1"),
                Car(id = 1, currentPosition = 0, name = "car2")
            )
            carRecorder.recording(1, cars)
            Then("조회할 수 있다.") {
                shouldNotThrowAny { carRecorder.findWinners(1) }
            }
        }

        When("게임 기록이 없다면") {
            val carRecorder = CarRecorder()
            Then("조회할 수 없고 예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> { carRecorder.findWinners(1) }
            }
        }
    }
})

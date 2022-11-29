package carrace

import carrace.logic.GameRound
import carrace.logic.car.Car
import carrace.logic.car.CarName
import carrace.logic.car.Cars
import carrace.view.InputView
import carrace.view.ResultViewImpl
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec

/**
 * @see Controller
 */
internal class ControllerTest : FunSpec({

    context("컨트롤러 테스트") {
        val testCarName = CarName("car1")
        val testCar = Car(testCarName)

        val controller = Controller(
            inputView = object : InputView {
                override fun inputCars(): Cars {
                    return Cars(listOf(testCar))
                }

                override fun inputGameRound(): GameRound {
                    return GameRound(1)
                }
            },
            resultView = ResultViewImpl
        )

        test("startGame") {
            shouldNotThrowAny {
                controller.startGame()
            }
        }
    }
})

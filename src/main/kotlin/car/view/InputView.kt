package car.view

import car.view.input.CarNamesInput
import car.view.input.PrettyPrinterInput
import car.view.input.TryCountInput

class InputView {
    fun inputNames(): CarNamesInput {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return CarNamesInput(readLine())
    }
    fun inputTryCount(): TryCountInput {
        println("시도할 횟수는 몇 회인가요?")
        return TryCountInput(readLine())
    }
    fun inputPrettyString(): PrettyPrinterInput {
        println("어떤 문자로 이쁘게 표기할까요?")
        return PrettyPrinterInput(readLine())
    }
}

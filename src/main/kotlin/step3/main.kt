package step3

import step3.component.CarInputComponent
import step3.component.InputComponent

fun main() {
    CarInputComponent().render()
    InputComponent(label = "시도할 횟수는 몇 회인가요?").render()
}

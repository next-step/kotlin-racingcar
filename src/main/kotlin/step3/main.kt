package step3

import step3.impl.InputViewImpl

fun main() {
    val carFactory = CarFactory()
    val inputView = InputViewImpl()
    val resultView = ResultView()
    val promptService = PromptService(
        inputView = inputView,
        resultView = resultView
    )

    val carRacing = CarRacing(carFactory, promptService)
    carRacing.run()
}

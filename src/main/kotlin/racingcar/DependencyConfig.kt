package racingcar

object DependencyConfig {
    val inputProvider: InputProvider = ConsoleInputView()

    val outputProvider: CarResultProvider = ConsoleCarResultView()

    val carFactory : CarFactory = CarFactory()
}

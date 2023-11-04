package racingcar

object DependencyConfig {
    val carInputProvider: CarInputProvider = ConsoleCarInputView()

    val outputProvider: CarResultProvider = ConsoleCarResultView()

    val carFactory : CarFactory = CarFactory()
}

package racingcar

object DependencyConfig {
    val inputProvider: InputProvider by lazy {
        ConsoleInputView
    }

    val outputProvider: ResultProvider by lazy {
        ConsoleResultView
    }
}

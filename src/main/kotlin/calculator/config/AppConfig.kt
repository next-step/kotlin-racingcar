package calculator.config

import calculator.adapter.`in`.console.Console
import calculator.application.service.Engine
import calculator.application.service.Tokenizer

class AppConfig {
    fun console(): Console {
        return Console(engine())
    }

    private fun engine(): Engine {
        return Engine(tokenizer())
    }

    private fun tokenizer(): Tokenizer {
        return Tokenizer()
    }
}

package calculator.config

import calculator.application.Calculator
import calculator.application.Console
import calculator.application.Converter
import calculator.application.Engine
import calculator.application.Tokenizer

class AppConfig {
    fun calculator(): Calculator {
        return Calculator(engine = engine(), console = console())
    }

    private fun engine(): Engine {
        return Engine(tokenizer = tokenizer(), converter = converter())
    }

    private fun console(): Console {
        return Console()
    }

    private fun tokenizer(): Tokenizer {
        return Tokenizer()
    }

    private fun converter(): Converter {
        return Converter()
    }
}

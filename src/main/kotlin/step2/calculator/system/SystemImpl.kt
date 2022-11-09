package step2.calculator.system

import step2.calculator.system.component.Component
import step2.calculator.system.component.LazyFunction
import step2.calculator.system.component.Numeric

class SystemImpl : System {

    override fun compute(previousResult: Numeric, previousInput: Component, request: Component): Memory {
        return if (previousInput is Numeric && request is Numeric) {
            overwriteMemory(request)
        } else if (previousInput is Numeric && request is LazyFunction) {
            wait(previousResult, request)
        } else if (previousInput is LazyFunction && request is Numeric) {
            evaluate(previousResult, previousInput, request)
        } else if (previousInput is LazyFunction && request is LazyFunction) {
            overwriteMemory(previousResult, request)
        } else {
            throw IllegalArgumentException("지원하지 않는 입력 형태입니다.")
        }
    }

    /**
     * 이전 입력이 숫자이고 현재 입력도 숫자이면 덮어 씌움
     */
    private fun overwriteMemory(request: Numeric): Memory {
        return Memory(request.value, request)
    }

    /**
     * 이전 입력이 숫자이고 현재 입력이 lazy 함수일 때
     */
    private fun wait(previousResult: Numeric, request: LazyFunction): Memory {
        return Memory(previousResult.value, request)
    }

    /**
     * 이전 입력이 lazy 함수이고 현재 입력이 숫자일 때
     */
    private fun evaluate(previousResult: Numeric, previousInput: LazyFunction, request: Numeric): Memory {
        return Memory(
            previousInput.evaluate(previousResult.value, request.value),
            request
        )
    }

    /**
     * 이전 입력이 lazy 함수이고 현재 입력도 lazy 함수이면 최신 함수로 바꿈
     */
    private fun overwriteMemory(previousResult: Numeric, request: LazyFunction): Memory {
        return Memory(previousResult.value, request)
    }
}

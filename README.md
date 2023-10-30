# kotlin-racingcar

# 2단계 - 문자열 계산기

## 🎯 기능 요구사항

- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 "2 + 3 -> 5 * 4 -> 20 / 2 -> 10" 와 같이 순서대로 계산하여야 한다.

### ✨ Challenge

- 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 💻 Step 2, Feedback

#### 1. Expression.kt
```kotlin
package calculator

data class Expression(
    val left: Long?,
    val operator: Operator,
    val right: Long,
) {
    fun calculate(): Long {
        require(left != null) { throw IllegalArgumentException("left 값이 없습니다. 앞선 계산식의 결과를 매개변수로 포함해주세요.") }

        return operator.operate(left, right)
    }

    fun calculate(expressionResult: Long): Long = operator.operate(expressionResult, right)
}
```
##### Problem
* 좌항이 없는 수식은 논리적으로 존재할 수 없음. -> 좌항이 없을 경우, Exception을 던지도록 하였지만 신뢰 보장 측면에서는 아쉬움.

##### Solution
* 객체 생성에서 막는 방안을 고민.

##### effect
* 좌항이 없는 수식이 생성되는 것을 막을 수 있음.
* calculate() 함수를 호출할 때 **Exception이 발생하지 않을 것이라는 신뢰 보장** 가능.

#### ~~2. ExpressionParser.kt~~
```kotlin
package calculator

class ExpressionParser {

    fun parse(parseTarget: String): List<Expression> {
        try {
            val splitParseTarget: List<String> = parseTarget.split(" ")
            val expressionList: MutableList<Expression> = mutableListOf<Expression>(
                Expression(
                    splitParseTarget[0].toLong(),
                    findOperator(splitParseTarget[1]),
                    splitParseTarget[2].toLong()
                )
            )

            for (idx: Int in 3 until splitParseTarget.size step 2) {
                val operator: Operator = findOperator(splitParseTarget[idx])
                val right: Long = splitParseTarget[idx + 1].toLong()

                expressionList.add(Expression(null, operator, right))
            }

            return expressionList
        } catch (formatException: NumberFormatException) {
            throw IllegalArgumentException("숫자 형식이 아닙니다.")
        }
    }

    private fun findOperator(operator: String): Operator {
        return Operator.values().find { it.operator == operator }
            ?: throw IllegalArgumentException("사칙연산 기호만 입력 가능합니다.")
    }
}
```

##### Problem
* 객체 내부에서 사이드 이펙트를 발생시키는 요소가 없는 순수 함수만을 포함하고 있으나, 일반 클래스임.
* 예외 메시지에 입력 값이 어떤 것인지에 대한 정보가 없음.

##### Solution
* object로 변경.
* 예외 메시지에 입력 값에 대한 정보를 포함.

##### effect
* Singleton으로 변경되어, 객체 생성에 대한 부담이 사라짐.
* 예외 메시지에 입력 값에 대한 정보를 포함하여, 디버깅에 용이.

#### ~~3. Operator.kt~~
```kotlin
package calculator

enum class Operator(val operator: String, val operation: (Long, Long) -> Long) {
    PLUS("+", { left: Long, right: Long -> left + right }),
    MINUS("-", { left: Long, right: Long -> left - right }),
    MULTIPLY("*", { left: Long, right: Long -> left * right }),
    DIVIDE("/", { left: Long, right: Long -> left / right });

    fun operate(left: Long, right: Long): Long = operation(left, right)
}
```

##### Problem
* 멤버변수인 operation이 공개되어 있음. -> 외부에서 직접 접근 가능. But, operate() layer가 필요한가?

##### Solution
* **공개된 operation을 외부에서 멤버변수를 접근해 람다를 호출하도록 변경** or operation을 private으로 변경.

##### effect
* **불필요 layer 제거.** or 외부에서 직접 접근할 수 없도록 변경


#### ~~4. StringCalculator.kt~~
```kotlin
package calculator

class StringCalculator {

    fun calculate(input: String?): Long {
        require(!input.isNullOrBlank()) { throw IllegalArgumentException("입력값이 없습니다.") }

        if (input.toLongOrNull() != null) {
            return input.toLong()
        }

        if (input[0].toString().toLongOrNull() == null) {
            throw IllegalArgumentException("첫번째 입력값이 숫자가 아닙니다.")
        }

        val expressionList: List<Expression> = ExpressionParser().parse(input)
        val firstExpression: Expression = expressionList.first()
        val withOutFirstExpression: List<Expression> = expressionList.drop(1)

        return withOutFirstExpression.fold(firstExpression.calculate()) { expressionResult: Long, expression: Expression ->
            expression.calculate(expressionResult)
        }
    }
}
```

##### Problem
* require() 함수는 조건을 충족하지 못할 경우, IllegalArgumentException을 던짐. -> IllegalArgumentException 메시지는 람다로부터 가져오기에, throw로 Exception을 던질 필요가 없음.

##### Solution
* require() 함수 람다 식에 throw가 아닌 메시지만 전달.

##### effect
* require() 함수 람다식에서 throw를 하게 되면 require의 Exception이 아닌 Exception이 나타나 불필요한 중복 로직이 발생함.

#### ~~5. OperatorTest.kt~~
```kotlin
package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OperatorTest {

    private var left: Long = 0
    private var right: Long = 0

    @BeforeEach
    fun setUp() {
        left = 1
        right = 2
    }

    @Test
    fun `연산자가 더하기라면 두 수를 더한 결과를 반환합니다`() {
        val operator: Operator = Operator.PLUS

        val result: Long = operator.operate(left, right)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `연산자가 빼기라면 두 수를 뺀 결과를 반환합니다`() {
        val operator: Operator = Operator.MINUS

        val result: Long = operator.operate(left, right)

        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `연산자가 곱하기라면 두 수를 곱한 결과를 반환합니다`() {
        val operator: Operator = Operator.MULTIPLY

        val result: Long = operator.operate(left, right)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `연산자가 나누기라면 두 수를 나눈 결과를 반환합니다`() {
        val operator: Operator = Operator.DIVIDE

        val result: Long = operator.operate(left, right)

        assertThat(result).isEqualTo(0)
    }
}
```

##### Problem
* ParameterizedTest를 사용하지 않고, 중복된 테스트 코드를 작성함.

##### Solution
* ParameterizedTest를 사용하여 중복된 테스트 코드를 제거.

##### effect
* 테스트 코드의 가독성이 향상됨.

#### 6. StringCalculatorTest.kt
```kotlin
package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {

    private val stringCalculator: StringCalculator = StringCalculator()

    @Test
    fun `입력값이 Null이라면 IllegalArgumentException이 발생합니다`() {
        val input: String? = null

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `입력값이 빈 문자열이라면 IllegalArgumentException이 발생합니다`() {
        val input: String = ""

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `입력값이 공백이라면 IllegalArgumentException이 발생합니다`() {
        val input: String = " "

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `입력값이 숫자 하나라면 해당 숫자를 반환합니다`() {
        val input: String = "1"

        assertThat(stringCalculator.calculate(input)).isEqualTo(1)
    }

    @Test
    fun `처음 입력값이 숫자가 아니라면 IllegalArgumentException이 발생합니다`() {
        val input: String = "+ 1"

        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    @Test
    fun `입력값이 숫자 두개와 덧셈 기호라면 두 숫자를 더한 값을 반환합니다`() {
        val input: String = "1 + 2"

        assertThat(stringCalculator.calculate(input)).isEqualTo(3)
    }

    @Test
    fun `입력값에 계산식이 여러개라면 모든 계산식을 계산한 결과를 반환합니다 1`() {
        val input: String = "1 + 2 * 3 / 3"

        assertThat(stringCalculator.calculate(input)).isEqualTo(3)
    }

    @Test
    fun `입력값에 계산식이 여러개라면 모든 계산식을 계산한 결과를 반환합니다 2`() {
        val input: String = "1 + 2 - 3"

        assertThat(stringCalculator.calculate(input)).isEqualTo(0)
    }
}
```

##### Problem
* ParameterizedTest & NullorEmptySource 를 사용하지 않고, 중복된 테스트 코드를 작성함.

##### Solution
* ParameterizedTest & NullorEmptySource를 사용하여 중복된 테스트 코드를 제거.

##### effect
* 테스트 코드의 가독성이 향상됨.
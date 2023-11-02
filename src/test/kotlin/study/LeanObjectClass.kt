package study

import io.kotest.core.spec.style.StringSpec

class LeanObjectClass : StringSpec({

    "공부를 해야한다" {
        """
            # Object expressions and declarations
            : https://kotlinlang.org/docs/object-declarations.html
            
            - 새 하위 클래스를 명시적으로 선언하지 않고 일부 클래스를 약간 수정한 개체를 만들어야 하는 경우도 있습니다.
            - Kotlin은 객체 표현식과 객체 선언을 통해 이를 처리할 수 있습니다.
            
            ## Object expression (객체 표현식?)
            - Object expressions 는 익명 클래스를 만듬
            - 명시적으로 선언되지않음 코드에서 생성자를 호출하지 않음
            - one-time use 용도로 적절
        """.trimIndent()

        println(helloWorld.toString())
    }
})

val helloWorld = object {
    val hello = "Object "
    val world = "expressions"
    override fun toString() = "$hello $world"
}

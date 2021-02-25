package study

// 코틀린은 프로퍼티 기반의 언어고 프로퍼티는 getter와 setter가 관행적으로 붙는다.
data class Person(val name: String, val age: Int, var nickname: String? = "김수현") // 필드가 아닌 프로퍼티

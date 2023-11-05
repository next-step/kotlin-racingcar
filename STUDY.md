# Mission with Kotlin in Action

Kotlin in Action 을 읽으면서 학습한 내용이 미션에 어떻게 적용됐는지 기록합니다.

## 정적인 멤버 선언하기

매직 넘버를 상수로 정의해야 할 경우가 존재합니다.
코틀린은 클래스 안에 정적인 멤버를 정의할 수 없으며 static 키워드를 지원하지 않습니다.
코틀린에서 정적인 멤버를 선언하는 방법에 대해 배워봅니다.

### 최상위 함수

- 코틀린에서는 패키지 수준의 최상위 함수, 프로퍼티를 사용할 수 있습니다.
- 최상위 함수는 자바의 정적 메서드 역할을 거의 대신할 수 있습니다.
- 최상위 프로퍼티를 활용해 코드에 상수를 추가할 수 있습니다.
  - 최상위 프로퍼티도 다른 모든 프로퍼티처럼 접근자 메서드를 통해 자바 코드에 노출됩니다.
  - 상수답게 사용하려면 const 변경자를 추가하여 public static final 필드로 컴파일 할 수 있습니다.

```kotlin
@file:JvmName("MyFunctions")

package example

var opCount = 0 // getter 메서드가 노출된다

const val UNIX_LINE_SEPARATOR = "\n" // public static final 필드로 컴파일된다

fun performOperation() {
    opCount++
}
```

### 동반 객체(Companion Object)

- 정적인 멤버를 선언해야 할 경우, 대부분 최상위 함수를 활용하는 편을 더 권장합니다.
- 하지만, 최상위 함수는 private으로 표시된 클래스 비공개 멤버에 접근할 수 없으므로, 클래스 내부 정보에 접근해야 하는 함수가 필요할 때는 클래스에 중첩된 객체 선언을 활용해야 합니다.

```kotlin
class A {
    private val foo = "foo"

    companion object {
        fun inner(a:A) {
            a.foo // ok...! (private 멤버 접근 가능)
        }
    }
}

fun top(a: A) {
    a.foo // error...! (private 멤버 접근 불가)
}
```

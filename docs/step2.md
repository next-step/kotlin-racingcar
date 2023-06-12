# 🚀 2단계 - 문자열 계산기

## 문자열 사칙 연산 계산기 구현
---

### 기능 요구 사항
- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정

### 구현 목록
#### 입력
- [x] 사용자로부터 문자열 입력 받기
    - [x] 입력 받은 문자열이 `null`이거나 빈 공백 문자일 경우 `IllegalArgumentException` 발생 
    - [x] 입력 받은 문자열에 사칙연산 기호가 없는 경우 `IllegalArgumentException` 발생

#### 기능
- [x] 입력 받은 문자열을 사칙연산 기호 기준으로 분리
    - [x] 사칙연산 기호가 아닌 경우 `IllegalArgumentException` 발생 
    - [x] 연속된 사칙연산 기호가 있는 경우 `IllegalArgumentException` 발생
- [x] 분리된 문자열을 숫자로 변환
    - [x] 숫자 변환 실패 시 `IllegalArgumentException` 발생
- [x] 사칙연산 기호에 따라 계산
    - [x] 덧셈
    - [x] 뺄셈
    - [x] 곱셈
    - [x] 나눗셈
      - [x] 0으로 나누는 경우 `IllegalArgumentException` 발생

#### 출력
- [x] 계산 결과 출력

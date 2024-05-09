package main.kotlin.variable


fun variable() {
    // 1. 변수 선언 기본
    // val (Immutable) -> 초기에 값을 할당하면 더이상 값 변경 불가
    // var (Mutable) -> 값의 변경은 가능 그치만, 다른 타입의 값으로는 변경 불가 / 읽기, 쓰기가 가능한 변수

    // 변수명으로 이미 사용하고 있는 예약어X (굳이 쓰고 싶으면 변수명 앞뒤에 '' (따옴표) 붙여주면 가능함)
    // ex) val 'in' : Int = 0
    // 변수명 젤 앞에 숫자부터 시작 못 함

    // 2. 변수 타입
    // - 정수형 -
    // 정수형을 표현하는 변수타입은 총 4가지가 있다.
    // Byte(8bits), Short(16bits), Int(32bits), Long(64bits)
    // Long 타입을 쓸 때는 변수선언 뒤에 L 를 붙여주면 된다.
    val one = 1     // Int
    val threeBillion = 3000000000   // Long
    val oneLong = 1L    // Long
    val oneByte: Byte = 1   // Byte
    val threeBillion2 = 3_000_000_000   // 언더바(_) 넣어주어도 값에는 영향을 주지 않음, 오로지 가독성을 위함

    // - 실수형 -
    // 실수형을 표현하는 변수타입은 총 2가지가 있다.
    // Float(32bits), Double(64bits)
    // Float 타입을 쓸 때는 뒤에 f 를 붙여주면 된다.
    val pi = 3.14   // Double
    val e = 2.12341234  // Double
    val eFloat = 2.12341234f    // Float

    // Boolean
    val isAlive: Boolean = false

    // String
    // Dart 와 똑같이 ${} 사이에 변수 첨부 가능
    val name: String = "오지명"
    val age: Int = 20
    println("이름은 ${name}이고 나이는 ${age}입니다.")

    val result: String = "이름은 ${name}이고 나이는 ${age}입니다."
    println(result)
    println(name[0])
    println(name[2])

    val trimStr = """
        ABC
        DEF
        $name
        $age
    """.trimIndent()

    println(trimStr)

    ///////////////////////////////////////

    // 3. Null Safety
    // Dart 와 얼추 비슷함  ? 를 사용함
    var name2: String = "오지명"
    var nullableName1: String = "오지명"
    var nullableName2: String? = null


    println(nullableName1)  // 오지명 출력
    println(nullableName2)  // null 출력, 만약 null safety 가 없다면 error 가 뜨겠죠?

        // 3-1. 조건문을 통해 null 확인하고 거르기
    if (nullableName2 != null) {
        println(nullableName2)
    }
        // 3-2. ?. 연산자를 통해서 안전하게 호출
//    var length = nullableName2.length     null safety 때문에 컴파일 에러뜸
    var length = nullableName2?.length
    println(length)

        // 3-3. ?: 엘비스 연산자
        // Dart 에서 ?? 와 똑같음, null 일 경우에 값을 지정해줄 수가 있음
    var length2 = nullableName2?.length ?: 3  // nullableName2.length 가 null 이면 3

    fun startWithA(str: String?): Boolean {
        return str?.startsWith('A')
            ?: throw IllegalArgumentException("null이 들어왔습니다.")
    }

        // 3-4. !! 연산자
        // Dart 에서 ! 와 똑같음,  !! 를 붙여주면 이 친구는 절대 null 이 아니야 라고 선언
    println(nullableName2!!.length)     // null 인데 null 이 아니야 라고 했으니 실행하면 NullPointException 에러 발생함.
                                        // 그래서 !! 연산자를 사용할 때는 유의해서 사용할 필요가 있음.

}
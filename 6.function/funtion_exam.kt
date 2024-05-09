package main.kotlin.function

import java.util.*
import kotlin.concurrent.timerTask

fun gameMain() {

    var monsterHp: Int?

    println("----------------------------------------------")
    println("몬스터 때려잡기 게임에 오신것을 환영합니다.")
    println("게임 방법은 간단합니다.")
    println("보통펀치 와 진심펀치 2가지의 공격이 있으며 확률 게임입니다.")
    println("50% 확률이며, 보통펀치는 10, 진심펀치는 30의 데미지를 입힙니다.")
    println("더 짧은 라운드 안에 몬스터를 무찌르는 사람이 강한자가 될 것 입니다.")

    var scHp = Scanner(System.`in`)

    println("----------------------------------------------")

    Timer().schedule(timerTask {
        println("")
        print("먼저 최소 30 이상으로 몬스터 HP를 입력하여 설정해주세요 : ")
    }, 1000)
    while (true) {
        if (scHp.hasNextInt()) {
            monsterHp = scHp.nextInt()
            if (monsterHp >= 30) {
                println("몬스터 HP가 정상적으로 등록되었습니다 -> 몬스터 HP : $monsterHp")
                break
            } else {
                print("최소 30 이상으로 다시 입력해주세요 : ")
            }
        } else {
            scHp = Scanner(System.`in`)
            println("숫자만 입력가능합니다.")
            print("최소 30 이상으로 다시 입력해주세요 : ")
        }

    }

    println("----------------------------------------------")
    println("자 이제 게임을 시작합니다 :)")

    val result: Int = gameRoundMethod(monsterHp ?: 100)

    println("최종 라운드 수 : $result")
    println("게임이 종료되었습니다.")
}

fun hpAfterAttackStructure(select: Int, hp: Int): Int {
    var monsterHp: Int = hp
    val simplePunch = 10
    val realPunch = 30
    val isAttack = Random().nextInt(100)

//    println("isAttack : $isAttack")

    if (select == 1) {
        println("보통 펀치 !!!!!")
        if (isAttack <= 50) {
            monsterHp -= simplePunch
            print("Attack !! (damage 10)")
        } else {
            print("Miss ㅠㅠ ")
        }
    } else if (select == 2) {
        println("진심 펀치 !!!!!")
        if (isAttack > 50) {
            monsterHp -= realPunch
            print("Attack !!! (damage 30)")
        } else {
            print("Miss ㅠㅠ ")
        }
    } else {
        println("잘못된 공격을 선택하셨습니다. 다시 선택해주세요.")
    }

    return monsterHp
}

fun gameRoundMethod(hp: Int): Int {
    var round: Int = 1
    var attack: Int = 0
    var scAttack = Scanner(System.`in`)

    var monsterHp = hp
    while (true) {
        println("Round$round")
        print("1. 보통펀치 / 2. 진심펀치  두 가지중 공격 하나를 선택해주세요 : ")
        if (scAttack.hasNextInt()) {
            attack = scAttack.nextInt()
            if (attack == 1 || attack == 2) {
                monsterHp = hpAfterAttackStructure(attack, monsterHp)
                if (monsterHp <= 0) {
                    monsterHp = 0
                    println()
                    println("===============================")
                    println("======== 몬스터의 체력 $monsterHp =========")
                    println("===============================")
                    println("====== 몬스터를 무찔렀습니다!! ======")
                    println("===============================")
                    println()
                    break
                }
                round++
                println(" => 몬스터의 현재 체력 : $monsterHp")
            } else {
                println("잘못된 공격을 선택하셨습니다. 다시 선택해주세요.")
            }
        } else {
            scAttack = Scanner(System.`in`)
            println("숫자만 입력가능합니다.")
        }

        println("----------------------------------------------")

    }

    return round
}
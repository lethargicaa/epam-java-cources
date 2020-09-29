package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        List<VampireNumber> vampireNumbers = new ArrayList<>();
        int n, n1, n2;

        for (int d11 = 1; d11 <= 9; d11++) // перебираем старшую цифру первого "клыка" (идем от 1 к 9)
            toNextNumber1:
                    for (int d12 = 0; d12 <= 9; d12++) // перебираем младшую цифру первого "клыка" (от 0 до 9)
                        for (int d21 = 9; d21 > 0; d21--) // перебираем старшую цифру второго "клыка" (от 9 до 1)
                            for (int d22 = 9; d22 >= 0; d22--) { // перебираем младшую цифру второго "клыка" (от 9 до 0)
                                if (d12 == 0 && d22 == 0) continue; // отсеиваем случаи, когда оба числа оканчиваются 0
                                n1 = d11 * 10 + d12; // вычисляем первый потенциальный клык
                                n2 = d21 * 10 + d22; // вычисляем второй потенциальный клык
                                n = n1 * n2;
                                if (n < 1000 || n1 > n2) continue toNextNumber1; // если произведение не 4-значное, пропускаем
// Второе условие гарантирует отсутствие повтора из-за перемены мест клыков

// Собственно, главная проверка, является ли число вампиром,
// т.е. для любой цифры количества её вхождений в исходное число и в клыки должны быть равными
                                if (digitsInNumber(n, d11) == digitsInNumber(n1, d11) + digitsInNumber(n2, d11)
                                        && digitsInNumber(n, d12) == digitsInNumber(n1, d12) + digitsInNumber(n2, d12)
                                        && digitsInNumber(n, d21) == digitsInNumber(n1, d21) + digitsInNumber(n2, d21)
                                        && digitsInNumber(n, d22) == digitsInNumber(n1, d22) + digitsInNumber(n2, d22)) {
                                    vampireNumbers.add(new VampireNumberImpl(n, n1, n2));
                                }
                            }
        return vampireNumbers;
    }
    static int digitsInNumber(int number, int digit) {
        int total = 0;
        while (number > 0) {
            if (number % 10 == digit)
                total++;
            number /= 10;
        }
        return total;
    }
}


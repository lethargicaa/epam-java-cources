package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        int len = sourceString.length();
        List<Integer> listok = new ArrayList<>();

        // if there is only 1 number
        // in the string then
        // it is not possible to split it
        if (len == 1) {
            return listok;
        }

        String s1 = "";
        String s2 = "";
        String sAll = "";
        String stringresult = "";
        long num1;
        long num2;

        for (int i = 0; i <= len / 2; i++) {
            // int flag = 0;
            // storing the substring from
            // 0 to i+1 to form initial
            // number of the increasing sequence
            s1 = sourceString.substring(0, i + 1);
            if (s1.equals("0")) {
                return listok;
            }
            num1 = Long.parseLong((s1));
            num2 = num1 + 1;

            // convert string to integer
            // and add 1 and again convert
            // back to string s2
            s2 = Long.toString(num2);
            int k = i + 1;
            int flag = 0;
            while (flag == 0) {
                int l = s2.length();

                // if s2 is not a substring
                // of number than not possile
                if (k + l > len) {
                    flag = 1;
                    break;
                }

                // if s2 is the next substring
                // of the numeric string
                if ((sourceString.substring(k, k + l).equals(s2))) {
                    flag = 0;
                    listok.add(Integer.parseInt(s2));
                    sAll += s2;
                    // Incearse num2 by 1 i.e the
                    // next number to be looked for
                    num2++;
                    k = k + l;

                    // check if string is fully
                    // traversed then break
                    if (k == len) {
                        break;
                    }
                    s2 = Long.toString(num2);
                    l = s2.length();
                    if (k + 1 > len) {
                        // If next string doesnot occurs
                        // in a given numeric string
                        // then it is not possible
                        flag = 1;
                        break;
                    }
                } else {
                    flag = 1;
                }
            }

            // if the string was fully traversed
            // and conditions were satisfied
            if (flag == 0) {
                listok.add(0, Integer.parseInt(s1));
                List<Integer> result = listok;
                break;
            } else if (flag == 1 && i > len / 2 - 1) {         // if conditions failed to hold
                break;
            }
        }
        stringresult = s1 + sAll;
        if (listok.size() == 1 || !stringresult.equals(sourceString)) {
            listok.clear();
        }
        return listok;
    }
}

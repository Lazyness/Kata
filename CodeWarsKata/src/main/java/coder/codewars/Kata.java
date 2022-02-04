package coder.codewars;

import java.util.ArrayList;
import java.util.Arrays;

public class Kata {

    public int sum(int a, int b) {
        return a + b;
    }

    public static int[] arrayDiff(int[] list1, int[] list2) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if (list2.length == 0) return list1;
        else if (list1.length == 0) return list1;
        Arrays.sort(list2);
        boolean flag = false;

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i] == list2[j]) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                temp.add(list1[i]);
            }
        }

        int[] arr = new int[temp.size()];
        int i = 0;
        for (int elem : temp) {
            arr[i++] = elem;
        }
        return arr;
    }

    public static int summation(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static int countPassengers(ArrayList<int[]> stops) {
        int count = stops.get(0)[0];
        for (int i = 0, j = 0; i < stops.size(); i++) {
            if (i > 0) {
                count += stops.get(i)[j];
            }
            count -= stops.get(i)[j + 1];
        }
        return count;
    }

    public static String accum(String s) {
        char[] sArray = s.toUpperCase().toCharArray();
        String newStr = "";
        for (int i = 0; i < sArray.length; i++) {
            if (i == 0) newStr += sArray[i];
            else newStr += sArray[i] + addLetters(s, i);
            if (i < sArray.length - 1) newStr += "-";
        }

        return newStr;
    }

    private static String addLetters(String s, int count) {
        String str = "";
        for (int i = 0; i < count; i++) {
            str += s.toLowerCase().charAt(count) + "";
        }
        return str;
    }

    public static String reverseWords(final String original) {
        int start = 0, end = 0;
        String result = "";
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == ' ') {
                result += reverseSE(start, end, original) + ' ';
                start = i + 1;
                end = start;
                continue;
            } else if (original.charAt(i) != ' ') {
                end++;
            }
            if (end == original.length()) {
                result += reverseSE(start, original.length(), original);
            }
        }
        return result;
    }

    private static String reverseSE(int start, int end, String original) {
        char[] dst = new char[end - start];
        String tempStr = "";
        original.getChars(start, end, dst, 0);
        for (int i = dst.length - 1; i >= 0; i--) {
            tempStr += dst[i];
        }
        return tempStr;
    }

    public int squareDigits(int n) { //9119
        int expression = (n / 10 % 10) * (n / 10 % 10);

        if (n == 0) return 0;
        else if (n >= 1 && n <= 9) {
            return n * n;
        } else if (n >= 10 && n <= 99) {
            return Integer.parseInt((n / 10) * (n / 10) + "" + (n % 10) * (n % 10));
        } else if (n >= 100 && n <= 999) {

            return Integer.parseInt((n / 100) * (n / 100) + "" + expression + "" + (n % 10) * (n % 10));
        }
        if (n >= 1000) {
            return Integer.parseInt((n / 1000) * (n / 1000) + "" + (n / 100 % 10) * (n / 100 % 10) + ""
                    + expression + "" + (n % 10) * (n % 10));
        } else return 0;

    }

    public static int persistence(long n) {
        //39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
        int count = 0;
        if (n < 10) return 0;
        for (; n >= 10; ) {
            n = mul(n);
            count++;
        }
        return count;
    }

    private static int mul(long n) {
        int mul = 1;
        while (n > 0) {
            mul *= (n % 10);
            n /= 10;
        }
        return mul;
    }

    static String toCamelCase(String str) {
        String newStr = "";
        boolean flag = false;
        if (str.length() == 0) return "";
        String[] words = str.split("[_|-]");
        for (int i = 0; i < words.length; i++) {
            int end = words[i].length(), start = 1;

            char[] dst = new char[end - start];
            words[i].getChars(start, end, dst, 0);
            if (words[0].equals(words[0].toLowerCase()) && !flag) {
                newStr += words[0];
                flag = true;
                continue;
            }
            ;
            newStr += words[i].toUpperCase().charAt(0) + new String(dst);
        }
        return newStr;
    }


    //"is2
    //Thi1s
    //T4est
    //3a"  -->  "Thi1s is2 3a T4est"
    //8 1 2 4 7
    //1 8 2 4 7

    public static String order(String words) {
        if (words.length() == 0) return "";
        String[] newWordsArray = words.split(" ");
        int num1 = 0;
        String newStr = "";

        for (int i = 0; i < newWordsArray.length; i++) {//go on words
            for (int j = 0; j < newWordsArray[i].length(); j++) {//go on symbols in a word

                num1 = tempNum(newWordsArray, i, j);// 57(9)-48(0) get number from string[]

                if (num1 > 0 && num1 < 10) {
                    newWordsArray = sortBubble(newWordsArray, i, j);
                    break;
                }
            }
        }
        for (int i = 0; i < newWordsArray.length; i++) {
            if (i == newWordsArray.length - 1) newStr += newWordsArray[i];
            else newStr += newWordsArray[i] + " ";
        }

        return newStr;
    }

    private static int indexJNext(int j, String[] newWordsArray) {
        int num2 = 0, index = 0;
        for (int i = 0; i < newWordsArray[j].length(); i++) {//go on symbols in a word
            num2 = tempNum(newWordsArray, j, i);// 57(9)-48(0)

            if (num2 > 0 && num2 < 10) {
                index = i;
                break;
            } else continue;
        }
        return index;
    }

    private static int tempNum(String[] newWordsArray, int i, int j) {
        return newWordsArray[i].charAt(j) - '0';
    }

    public static String[] sortBubble(String[] newWordsArray, int indexI, int indexJ) {
        for (int j = indexI + 1; j < newWordsArray.length; j++) {

            if (newWordsArray[indexI].charAt(indexJ) > newWordsArray[j].charAt(indexJNext(j, newWordsArray))) {
                String temp = newWordsArray[indexI];
                newWordsArray[indexI] = newWordsArray[j];
                newWordsArray[j] = temp;
                indexJ = indexJNext(indexI, newWordsArray);
            } else continue;
        }
        return newWordsArray;
    }

    //day 01.01.2022
    //For example, the string "This website is for losers LOL!"
    //would become "Ths wbst s fr lsrs LL!".
    public static String disemvowel(String str) {
        String nStr = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) != 'a' && str.charAt(i) != 'e' &&
                    str.charAt(i) != 'i' && str.charAt(i) != 'o' &&
                    str.charAt(i) != 'u') &&
                    (str.charAt(i) != 'A' && str.charAt(i) != 'E' &&
                            str.charAt(i) != 'I' && str.charAt(i) != 'O' &&
                            str.charAt(i) != 'U')) nStr += str.charAt(i);
            else continue;
        }
        return nStr;
    }

    public static long findNextSquare(long sq) {
        double foundNum = Math.sqrt(sq);
        return (foundNum - (int) (foundNum) == 0) ? (long) Math.pow((foundNum + 1), 2) : -1;
    }

    // 348597 => [7,9,5,8,4,3]
    // 0 => [0]
    public static int[] digitize(long n) {
        // Code here
        int[] arr = new int[1];
        String[] tempArr = (n + "").split("");
        for (int i = 0; i < tempArr.length; i++) {
            int[] temp = new int[arr.length + 1];

            arr[i] = Integer.parseInt(String.valueOf(tempArr[i].charAt(0)));

            for (int j = 0; j < arr.length; j++) {
                temp[j] = arr[j];
            }
            arr = temp;
        }
        //reverse
        int[] newTempArr = new int[tempArr.length];
        for (int i = tempArr.length - 1, j = 0; i > -1; i--, j++) {
            newTempArr[j] = arr[i];
        }
        return newTempArr;
    }

}

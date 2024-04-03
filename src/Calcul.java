import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class Calcul {

    static int Convert(String number){

        if(number.equals("1")){
            return 1;
        }
        if(number.equals("2")){
            return 2;
        }
        if(number.equals("3")){
            return 3;
        }
        if(number.equals("4")){
            return 4;
        }
        if(number.equals("5")){
            return 5;
        }
        if(number.equals("6")){
            return 6;
        }
        if(number.equals("7")){
            return 7;
        }
        if(number.equals("8")){
            return 8;
        }
        if(number.equals("9")){
            return 9;
        }
        if(number.equals("10")){
            return 10;
        }
        else {
            return 0;
        }
    }

    static int RomeConvert(String number){
        if(number.equals("I") | number.equals("i")){
            return 1;
        }
        if(number.equals("II") | number.equals("ii")){
            return 2;
        }
        if(number.equals("III") || number.equals("iii")){
            return 3;
        }
        if(number.equals("IV") | number.equals("iv")){
            return 4;
        }
        if(number.equals("V") | number.equals("v")){
            return 5;
        }
        if(number.equals("VI") | number.equals("vi")){
            return 6;
        }
        if(number.equals("VII") | number.equals("vii")){
            return 7;
        }
        if(number.equals("VIII") | number.equals("viii")){
            return 8;
        }
        if(number.equals("IX") | number.equals("ix")){
            return 9;
        }
        if(number.equals("X") | number.equals("x")){
            return 10;
        }
        else {
            return 0;
        }
    }

    static String ArabicConvert(int number){

        String result = "Halo!";

        if (number < 11){

            result = One(number);
        }



        if (number > 10){

            int ten = number / 10;      //  Колличество десятков
            int one = number % 10;      //  Колличество едениц
            result = Ten(ten) + One(one);
        }
        return result;
    }
    static String Ten (int ten){

        if (ten == 1){
            return "X";
        }
        if (ten == 2){
            return "XX";
        }
        if (ten == 3){
            return "XXX";
        }
        if(ten == 4){
            return "XL";
        }
        if (ten == 5){
            return "L";
        }
        if (ten == 6){
            return "LX";
        }
        if (ten == 7){
            return "LXX";
        }
        if (ten == 8){
            return "LXXX";
        }
        if (ten == 9){
            return "XC";
        }
        if (ten == 10){
            return "C";
        }
        else {
            return "F";
        }

    }
    static String One (int one){
        if(one == 1){
            return "I";
        }
        if(one == 2){
            return "II";
        }
        if(one == 3){
            return "III";
        }
        if(one == 4){
            return "IV";
        }
        if(one == 5){
            return "V";
        }
        if(one == 6){
            return "VI";
        }
        if(one == 7){
            return "VII";
        }
        if(one == 8){
            return "VIII";
        }
        if(one == 9){
            return "IX";
        }
        if(one == 10){
            return "X";
        }


        else {
            return " ";
        }
    }


    public static void main(String[] args) throws NegativeNumberException {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение: ");

        String allString = scanner.nextLine();                 // всё, что ввели - вся строка

        String[] moreString = allString.split(" ");     // разбиваем строку на элементы


        String number1 = moreString[0];         //  первое числло в строчку
        boolean isRomeNumber1 = false;           // римское ли число - нет
        int num1 = Calcul.Convert(number1);


        if (num1 == 0) {
            num1 = Calcul.RomeConvert(number1);
            isRomeNumber1 = true;
        }

        if (num1 == 0) throw new NegativeNumberException();


        String number2 = moreString[2];         //  второе число в строчку
        boolean isRomeNumber2 = false;
        int num2 = Calcul.Convert(number2);

        if (num2 == 0) {
            num2 = Calcul.RomeConvert(number2);
            isRomeNumber2 = true;
        }

        if (num2 == 0) throw new NegativeNumberException();

        /**
         *          Math operation
         */


        String opiration = moreString[1];       //  математическая операция


        if (isRomeNumber1 != isRomeNumber2) throw new NegativeNumberException();
        // только римские или только арабские - не смешивать

        int result;

        if (opiration.equals("+")) {

            result = num1 + num2;
            if (isRomeNumber1 == false) {

                System.out.println(allString + " = " + result);
            } else {
                String romeResult = Calcul.ArabicConvert(result);
                System.out.println(allString + " = " + romeResult);
            }
        }
        ////////////////////////

        if (opiration.equals("-")) {

        result = num1 - num2;
        if (isRomeNumber1 == false) {

            System.out.println(allString + " = " + result);
        } else {
            if(result < 1 ) throw new NegativeNumberException();    // у римлян нет нуля и отрицательных чисел

            String romeResult = Calcul.ArabicConvert(result);
            System.out.println(allString + " = " + romeResult);
        }
    }
        //////////////////////////

        if(opiration.equals("*")) {

            result = num1 * num2;
            if (isRomeNumber1 == false) {

                System.out.println(allString + " = " + result);
            } else {
                String romeResult = Calcul.ArabicConvert(result);
                System.out.println(allString + " = " + romeResult);
            }
        }
        ////////////////////////

        if (opiration.equals("/")) {

            result = num1 / num2;
            if (isRomeNumber1 == false) {

                System.out.println(allString + " = " + result);
            } else {
                String romeResult = Calcul.ArabicConvert(result);
                System.out.println(allString + " = " + romeResult);
            }
        }

    }

}


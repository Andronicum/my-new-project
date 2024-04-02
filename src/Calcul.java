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
        if(number == 1){
            return "I";
        }
        if(number == 2){
            return "II";
        }
        if(number == 3){
            return "III";
        }
        if(number == 4){
            return "IV";
        }
        if(number == 5){
            return "V";
        }
        if(number == 6){
            return "VI";
        }
        if(number == 7){
            return "VII";
        }
        if(number == 8){
            return "VIII";
        }
        if(number == 9){
            return "IX";
        }
        if(number == 10){
            return "X";
        }
        if(number == 11){
            return "XI";
        }
        if (number == 12){
            return "XII";
        }
        if (number == 13){
            return "XIII";
        }
        if(number == 14){
            return "XIV";
        }
        if (number == 15){
            return "XV";
        }
        else {
            return "W";
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


package ru.lachesis.lesson2;

import java.util.Arrays;

public class LessonTwo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 8, -3, 4};//new int[3];
        System.out.println(Arrays.toString(arr));
        System.out.println("Задача 7");
        shiftArray(arr, -3);
        System.out.println("Задача 6");
        System.out.println(checkBalance(arr));
        System.out.println("Задача 5");
        System.out.println("min = " + min(arr));
        System.out.println("max = " + max(arr));
        System.out.println("Задача 4");
        arr2d(7);
        System.out.println("Задача 3");
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 6) arr2[i] *= 2;
        }
        System.out.println(Arrays.toString(arr2));
        System.out.println("Задача 2");
        int[] arr3 = new int[8];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr3));
        System.out.println("Задача 1");
        int[] arr4 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr4));
        for (int i = 0; i < arr4.length; i++){
            switch (arr4[i]) {
                case 1:
                    arr4[i] = 0;
                    break;
                case 0:
                    arr4[i] = 1;
                    break;
            }
        }
        System.out.println(Arrays.toString(arr4));


    }

    private static void shiftArray(int[] arr,int shift){
        for (int i=1;i<=Math.abs(shift);i++) {
            oneShift(arr, shift);
//            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int[] oneShift(int[] arr,int oneshift){
        int saving, begin,end;
        oneshift=oneshift/Math.abs(oneshift) ;
/*
        switch (oneshift) {
            case 1:
                begin = arr.length-1;
                end=0;
                break;
            case -1:
                begin = 0;
                end = arr.length-1;
                break;
            default:
                return arr;
        }

 */
        if (oneshift>0){
            begin = arr.length-1;
            end=0;
        } else if(oneshift<0){
            begin = 0;
            end = arr.length-1;
        } else return arr;

        saving=arr[begin];
        int i=begin;
        while(i!=end){
            arr[i]=arr[i-oneshift];
            i=i-oneshift;
        }
        arr[i]=saving;
        return arr;
    }

    private static boolean checkBalance(int[] arr)
    {
        int sum = 0;
        for (int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        if (sum%2!=0) return false;
        int sumi=0;
        for (int i=0;i<arr.length;i++){
            sumi+=arr[i];
            if (sum-sumi==sumi){
                return true;
            }
        }
        return false;
    }

    private static int min(int[] arr){
        int min= 0;
        for (int i=0;i<arr.length;i++){
            min=min(min,arr[i]);
        }
        return min;
    }
    private static int max(int[] arr){
        int max= 0;
        for (int i=0;i<arr.length;i++){
            max=max(max,arr[i]);
        }
        return max;
    }
    private static int min(int a, int b) {
        int min=a;
        if (b<a) min = b;
        return min;
    }
    private static int max(int a, int b) {
        int max=a;
        if (b>a) max = b;
        return max;
    }
    private static void arr2d(int dim)
    {
        int[][] arr = new int[dim][dim];
        for (int i=0; i<dim;i++){
            arr[i][i]=1;
            arr[dim-i-1][i]=1;
        }
        for (int i=0; i<arr.length;i++){
            for (int j=0; j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }

    }
}

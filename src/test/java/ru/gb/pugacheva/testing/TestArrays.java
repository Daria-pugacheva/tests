package ru.gb.pugacheva.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.gb.pugacheva.lesson6j3tests.ArraysChecking;

public class TestArrays {

// В самом классе ArraysChecking я для запуска там же psvm  и отработки кода привычным образом,
// сделала просто методы статическими.
// и Соответственно, возник вопрос: корректен такой подход, что я в тестах проверяю работу методов,
// вызывая их не у объекта класса, а прямо у класса?
// (Понятно, что при нестатическихм методах, надо объект создавать, но в домашке при варианте со
// статикой получается эдакая экономия кода.)

    @Test // задаем правильный результат - если метод работает верно, то тест будет пройден
    public void testArrayAfterFour1() {
        Assertions.assertArrayEquals(new int[]{5, 6, 7}, ArraysChecking.arrayAfterFour(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    // задаем НЕправильный результат - если метод работает верно то тест НЕ будет пройден.
// Это как-то криво, наверное, но не нашла варианта проверки НЕравенства для массивов.
// Чтобы было понятно, что все с тестом нормально, выбрала вариант с сообщением.
    @Test // здесь несовпадает длина массивов
    public void testArrayAfterFour2() {
        Assertions.assertArrayEquals(new int[]{5, 6}, ArraysChecking.arrayAfterFour(new int[]{1,
                2, 3, 4, 5, 6, 7}), "Если метод работает правильно, тест должен провалиться");
    }

    @Test // здесь та же проверка, что во втором тесте, но несовпадают значения элементов масссива
    public void testArrayAfterFour3() {
        Assertions.assertArrayEquals(new int[]{5, 6, 6}, ArraysChecking.arrayAfterFour(new int[]{1,
                2, 3, 4, 5, 6, 7}), "Если метод работает правильно, тест должен провалиться");
    }

    @Test // проверка, что будет кинуто исключение там, где мы его ожидаем.
    public void testArrayAfterFour4() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ArraysChecking.arrayAfterFour(new int[]{1, 2, 3, 5, 5, 6, 7});
        });
    }


    @Test //проверяем, что метод выдает true, если ему задан правильный массив
    public void testTrueFindFourAndOneInArray1() {
        Assertions.assertTrue(ArraysChecking.findFourAndOneInArray(new int[]{1, 4, 4, 1, 1, 1, 4, 1}));
    }

    @Test // проверяем, что метод выдает false, если задан некорректный массив (все возможные варианты)
    public void testFalseFindFourAndOneInArray2() {
        Assertions.assertAll(
                () -> {
                    Assertions.assertFalse(ArraysChecking.findFourAndOneInArray(new int[]{1, 1, 1, 1}));
                }, () -> {
                    Assertions.assertFalse(ArraysChecking.findFourAndOneInArray(new int[]{4, 4, 4, 4}));
                }, () -> {
                    Assertions.assertFalse(ArraysChecking.findFourAndOneInArray(new int[]{1, 2, 1, 1}));
                }, () -> {
                    Assertions.assertFalse(ArraysChecking.findFourAndOneInArray(new int[]{4, 3, 4, 4}));
                }
        );
    }

    //проверяем, что метод выдает true, если ему задан правильный массив (через равенство). Не самая лучшая
//идея, но в домашке надо 3-4 метода, а у меня больше фантазии не хватает, что здесь, кроме true и
// false проверить.
    @Test
    public void testTrueFindFourAndOneInArray3() {
        Assertions.assertEquals(true, ArraysChecking.findFourAndOneInArray(new int[]{1, 4, 1, 1, 1}));
    }


}











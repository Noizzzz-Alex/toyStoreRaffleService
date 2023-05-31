package controller;

import model.IdGenerate;

import java.util.Random;

public class IdGenerator implements IdGenerate {
    /**
     * метод генерирует идентификатор из символов
     * и 4 цифр (пример: HNQS-1341)
     *
     * @param lettersCount список символов
     * @param numberCount  длинная символьной строки
     * @return индентификатор из символов и цифр
     */
    @Override
    public String generateId(int lettersCount, int numberCount) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        if (!(lettersCount == 0 && numberCount == 0)) {
            {
                for (int i = 0; i < lettersCount; i++) {
                    sb.append(letters.charAt(random.nextInt(letters.length())));
                }
                sb.append("-");
                for (int i = 0; i < lettersCount; i++) {
                    sb.append(numbers.charAt(random.nextInt(numbers.length())));
                }
            }
        }
        return sb.toString();
    }
}

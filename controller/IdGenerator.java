package controller;

import model.IdGenerate;

import java.util.Random;

public class IdGenerator implements IdGenerate {
    /**
     * метод генерирует идентификатор из символов
     * и 4 цифр (пример: HNQS-1341)
     * @param letters список символов
     * @param count длинная символьной строки
     * @return индентификатор из символов и цифр
     */
    @Override
    public String generateId(String letters,int count) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        sb.append("-");
        sb.append(random.nextInt(1000, 9999));
        return sb.toString();
    }
}

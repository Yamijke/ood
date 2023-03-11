package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public void printInfo(){
        System.out.println("Активная?: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Сообщение: " + message);
    }
    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error err = new Error(true, 404, "Страница не найдена");
        err.printInfo();
    }
}

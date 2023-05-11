package ru.job4j.atests;

public class ConstructorRefMain {
    public static void main(String[] args) {
        FuncInterface name = Model::new;
        Model model = name.function("Example");
        System.out.println("Значение равно: " + model.getName());
    }
}

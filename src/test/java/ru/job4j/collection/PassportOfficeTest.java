package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenPassportNumberIsExist() {
        Citizen citizen = new Citizen("123456", "Qwerty Qwertovich");
        Citizen citizen1 = new Citizen("123456", "Ytrewq Qwertovich");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        boolean isAdd = office.add(citizen1);
        assertThat(isAdd).isEqualTo(false);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }
}
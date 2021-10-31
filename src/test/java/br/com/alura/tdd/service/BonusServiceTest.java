package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {

    @Test
    public void bonusNaoAplicado(){
        BonusService bonusService = new BonusService();
        /*Assertions.assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus((new Funcionario("David Li Zhao", LocalDate.now(), new BigDecimal("25000")))));*/

        try{
            bonusService.calcularBonus((new Funcionario("David Li Zhao", LocalDate.now(), new BigDecimal("25000"))));
            Assertions.fail("Não lançou a Exception!");
        }catch (Exception e){
            Assertions.assertEquals("Funcionário com salário maior que 10000 não pode receber bônus", e.getMessage());
        }
    }

    @Test
    public void bonusAplicado(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus((new Funcionario("David Li Zhao", LocalDate.now(), new BigDecimal("2500"))));

        Assertions.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void salarioEquivalenteARegra(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus((new Funcionario("David Li Zhao", LocalDate.now(), new BigDecimal("10000"))));

        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
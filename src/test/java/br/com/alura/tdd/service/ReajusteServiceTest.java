package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void init(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("David", LocalDate.now(), new BigDecimal("1000"));
        System.out.println("Inicializando teste");
    }

    @AfterEach
    public void end(){
        System.out.println("Teste Encerrado");
    }

    @BeforeAll
    public static void initBeforeAll(){
        System.out.println("Inciando testes");
    }

    @AfterAll
    public static void endAfterAll(){
        System.out.println("Encerrando testes");
    }

    @Test
    public void reajusteDeDesempenhoADesejar(){
        service.reajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeDesempenhoBom(){
        service.reajuste(funcionario, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeDesempenhoOtimo(){
        service.reajuste(funcionario, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1250.00"), funcionario.getSalario());
    }

}

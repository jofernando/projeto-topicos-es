import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Profile("test")
@Configuration
public class TestDataConfiguration {

    @Autowired
    private EntityManager entityManager;

    @Bean
    @Transactional
    public CommandLineRunner testDataRunner() {
        return args -> {
            Query query = entityManager.createNativeQuery("INSERT INTO vinculo(id, tipo_vinculo, carga_horaria, bolsista, data_inicio, data_fim, status) VALUES (99, 'Pibix', 20, true, '2023-05-19', '2023-08-10', false)");
            query.executeUpdate();
        };
    }
}
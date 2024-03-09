// package ufape.vinculos;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// //import org.springframework.test.annotation.DirtiesContext;
// import org.springframework.test.context.ActiveProfiles;

// import com.jayway.jsonpath.DocumentContext;
// import com.jayway.jsonpath.JsonPath;

// //import br.edu.ufape.vinculos.business.models.Vinculo;

// import static org.assertj.core.api.Assertions.assertThat;



// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @ActiveProfiles("test")
// class VinculosServiceApplicationTests {

// 	@Autowired
// 	private TestRestTemplate restTemplate;

// 	// @Test
// 	// void ShouldReturnAVinculo() {
// 	// ResponseEntity<String> response = restTemplate.getForEntity("/vinculos/99", String.class);
// 	// assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		

//  	// }

// 	// @Test
// 	// void ShouldCreateANewVinculo() {
// 	// 	 Vinculo newVinculo = new Vinculo();
//     // 		newVinculo.setId((long) 100);
//     // 		newVinculo.setTipoVinculo("PIBIT");
//     // 		newVinculo.setCargaHoraria(20);
//     // 		newVinculo.setBolsista(true);
//     // 		newVinculo.setDataInicio(Date.parse("2023-05-10"));
//     // 		newVinculo.setDataFim(LocalDate.parse("2023-08-10"));
//     // 		newVinculo.setStatus(false);
// 	// }


// 	@Test
// 	void ShouldReturnAListOfVinculos() {
// 	ResponseEntity<String> response = restTemplate.getForEntity("/vinculos", String.class);
// 	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	
// 	DocumentContext documentContext = JsonPath.parse(response.getBody());
//     int vinculosCount = documentContext.read("$.length()");
//     assertThat(vinculosCount).isEqualTo(1);

// 	}

// }

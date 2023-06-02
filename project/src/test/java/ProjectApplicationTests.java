import com.intec.project.UseCaseController.PersonRepository;
import com.intec.project.entities.person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProjectApplicationTests {

	//Default test oprettet af Spring boot
	@Test
	void contextLoads() {
	}

	//Positivt testtilfælde:
	//Test hvor create-metoden opretter en person korrekt i databasen.
	@Test
	public void testCreatePerson_Success() {
		//Opretter en instans af PersonRepository
		PersonRepository personRepositoryTest = new PersonRepository();
		//Opretter testdata i databasen
		person persontest1 = new person("John", "Doe", "1234567890", LocalDate.of(1990, 5, 15));


		boolean result = personRepositoryTest.create(persontest1);


		assertTrue(result);
	}

	//Negativt testtilfælde:
	//Test hvor create-metoden håndterer ugyldige datainput som en tom værdi for fornavn.
	@Test
	public void testCreatePerson_InvalidInput() {
		//Opretter en instans af PersonRepository
		PersonRepository personRepository = new PersonRepository();
		//Opretter testdata i databasen
		person persontest2 = new person("", "Doe", "1234567890", LocalDate.of(1990, 5, 15));


		boolean result = personRepository.create(persontest2);


		assertFalse(result);
	}

	//Validering af input hvor create-metoden håndterer validering af input af en ugyldig fødselsdato.
	@Test
	public void testCreatePerson_InvalidDateOfBirth() {
		//Opretter en instans af PersonRepository
		PersonRepository personRepository = new PersonRepository();
		//Opretter testdata i databasen
		person persontest3 = new person("John", "Doe", "1234567890", LocalDate.of(1990, 13, 45));

		try {
			personRepository.create(persontest3);
			fail("Expected DateTimeException, but no exception was thrown.");
		} catch (Exception e) {
			// Kontroller om den kastede exception er en ValidationException
			assertTrue(e instanceof java.time.DateTimeException);
		}
	}


	//Integrationstest for at sikre, at create-metoden fungerer korrekt sammen med vores MySQl database.
	//For at validere create-metodens indsættelse bliver alle personer i databasen udskrevet i konsollen vedhjælp af getAll-metoden
	@Test
	public void testGetAll() {
		//Opretter en instans af PersonRepository
		PersonRepository personRepository = new PersonRepository();

		//Opretter testdata i databasen
		createTestDataInDatabase();

		//Kald getAll-metoden for at hente alle personer
		ArrayList<person> result = personRepository.getAll();

		//Verificer mindst at en person er returneret
		assertTrue(result.size() > 0);

		//Udskriver oplysninger for hver person i databasen
		for (person p : result) {
			System.out.println();
			System.out.println("Person ID: " + p.getPerson_id());
			System.out.println("Fornavn: " + p.getFnavn());
			System.out.println("Efternavn: " + p.getEnavn());
			System.out.println("Kørerkort nummer: " + p.getKørerkort_nummer());
			System.out.println("Fødselsdato: " + p.getFødselsdato());
			System.out.println("--------------------------");
		}

		//Verificer at det er korrekt hentet fra databasen
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
			 PreparedStatement stmt = connection.prepareStatement("SELECT * FROM person");
			 ResultSet rs = stmt.executeQuery()) {

			int index = 0;
			while (rs.next()) {
				int person_id = rs.getInt("person_id");
				String fnavn = rs.getString("fnavn");
				String enavn = rs.getString("enavn");
				String kørerkort_nummer = rs.getString("kørerkort_nummer");
				LocalDate fødselsdato = rs.getObject("fødselsdato", LocalDate.class);

				//Verificer at hver person i arraylisten er korrekt
				person expectedPerson = result.get(index++);
				assertEquals(expectedPerson.getPerson_id(), person_id);
				assertEquals(expectedPerson.getFnavn(), fnavn);
				assertEquals(expectedPerson.getEnavn(), enavn);
				assertEquals(expectedPerson.getKørerkort_nummer(), kørerkort_nummer);
				assertEquals(expectedPerson.getFødselsdato(), fødselsdato);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//Hjælpefunktion til at oprette testdata i databasen
	private void createTestDataInDatabase() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/intecdatabase", "root", "root123");
			 PreparedStatement stmt = connection.prepareStatement("INSERT INTO person (fnavn, enavn, kørerkort_nummer, fødselsdato) VALUES (?, ?, ?, ?)")) {

			//Tilføj testpersoner i databasen
			stmt.setString(1, "Johnny");
			stmt.setString(2, "Bravo");
			stmt.setString(3, "hejhej");
			stmt.setDate(4, java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)));
			stmt.executeUpdate();

			stmt.setString(1, "Ib");
			stmt.setString(2, "Ibsen");
			stmt.setString(3, "HOHO");
			stmt.setDate(4, java.sql.Date.valueOf(LocalDate.of(1995, 6, 15)));
			stmt.executeUpdate();

			stmt.setString(1, "Ole");
			stmt.setString(2, "Olesen");
			stmt.setString(3, "HIHI");
			stmt.setDate(4, java.sql.Date.valueOf(LocalDate.of(1985, 3, 20)));
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}




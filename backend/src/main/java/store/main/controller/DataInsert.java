package store.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import store.main.database.Brand;
import store.main.database.BrandRepository;
import store.main.database.Post;
import store.main.database.PostRepository;
import store.main.database.Rating;
import store.main.database.RatingRepository;
import store.main.database.User;
import store.main.database.UserRepository;

@Controller
public class DataInsert implements CommandLineRunner {

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public void run(String... args) throws Exception {

		saveExamples();

	}

	public void saveExamples() {
		Brand b1 = new Brand("HP");
		Brand b2 = new Brand("MSI");
		Brand b3 = new Brand("WD");
		Brand b4 = new Brand("ASUS");
		Brand b5 = new Brand("KINGSTON");
		Brand b6 = new Brand("AMD");
		Brand b7 = new Brand("NVIDIA");
		Brand b8 = new Brand("GIGABYTE");
		Brand b9 = new Brand("SEAGATE");
		Brand b10 = new Brand("NVIDIA");
		Brand b11 = new Brand("MSI");
		Brand b12 = new Brand("INTEL");
		Brand b13 = new Brand("PIONEER");
		User user = new User("Diego", "Montoto", "dm@gmail.com", "686665758", "passw1", "Plaza de los limones 12");
		user.getRoles().add("ROLE_USER");
		User user2 = new User("Marcos", "Ruiz", "mr@gmail.com", "677453980", "1234", "Calle de la maceta 15");
		user2.getRoles().add("ROLE_USER");
		user2.getRoles().add("ROLE_ADMIN");
		User user3 = new User("Joselu", "Sierra", "josesi@gmail.com", "945543665", "doggy", "Barrio Sesamo 17");
		user3.getRoles().add("ROLE_USER");
		User user4 = new User("Destroyer", "killer2332", "KillerxXXx@gmail.com", "345755434", "headshot360",
				"Rue del Percebe 32");
		user4.getRoles().add("ROLE_USER");
		User user5 = new User("Willy", "Ramirez", "willyr@gmail.com", "654322344", "CR7HALAMADRID", "Plaza españa 123");
		user5.getRoles().add("ROLE_USER");
		User user6 = new User("Jose", "Lopes", "Joselop@gmail.com", "933224223", "19021999", "Calle de la manzana 2");
		user6.getRoles().add("ROLE_USER");
		User user7 = new User("Carlos Luis", "lozano", "Lozanito@gmail.com", "wismichu", "pass",
				"Plaza de los milicianos 34");
		user7.getRoles().add("ROLE_USER");
		User user8 = new User("Jesus", "Mendez", "mendezjesus@gmail.com", "643346342", "minombre123",
				"Avenida de Pozuelo 21");
		user8.getRoles().add("ROLE_USER");
		User user9 = new User("Elrick", "mc99", "Ricky@gmail.com", "966433543", "4321", "calle de san Marcos 47");
		user9.getRoles().add("ROLE_USER");
		User user10 = new User("Joselyn", "Martinez", "JoselynMar@gmail.com", "655433423", "cartofen",
				"Avenida de la navegacion 98");
		user10.getRoles().add("ROLE_USER");
		User user11 = new User("Laura", "Flores", "LauFl@gmail.com", "998543554", "qwertyuiop",
				"Paseo de extremadura 89");
		user11.getRoles().add("ROLE_USER");
		User user12 = new User("Enrique", "Marquez", "Enrimar@gmail.com", "643444555", "password",
				"Calle Bravo Murillo 21");
		user12.getRoles().add("ROLE_USER");

		/*
		 * 0: "Motherboards"; 1: "Storage Devices"; 2: "CPU / Processors"; 3:
		 * "Video Cards & Video Devices"; 4: "Speakers"; 5: "Headphones"; 6:
		 * "Computer Mice"; 7: "Monitors"; 8: "Ink Printers"; 9: "Laser Priter"; 10:
		 * "3D Printer"; 11: "Printer Supplies"; default: "No category"; Post("nombre",
		 * enterotag, nimagenes, precio, "detalles", "descripcion", brand, "adresss",
		 * "tags1", "tag2");
		 */

		Path path = Paths.get("/path/to/the/file.txt");
		/**
		 * String name = "file.txt"; String originalFileName = "file.txt"; String
		 * contentType = "text/plain";
		 */
		byte[] content = null;

		try {
			content = Files.readAllBytes(path);
		} catch (final IOException e) {
		}

		Post p1 = new Post("HP Printer", 8, 1, 120,
				"Hp ink printer semi-new plug-and-use, comes with almost full cartridges, driver disk included",
				"HP printer with cartridges and driver disk", b1, "Calle padre san Roman 8, Madrid, Spain", "Printer",
				"HP", "semi-new");
		Post p2 = new Post("ASUS GTX 1060 6GB", 3, 1, 230,
				"GTX 1060 6GB video memory, two fans of air cooling, gaming ready with Pascal architecture, NVidia shadowplay compatible",
				"ASUS GTX 1060 6GB video ram ideal for gaming", b4, "Calle padre san Roman 10, Madrid, Spain",
				"GTX1060", "GPU", "Gaming");
		Post p3 = new Post("MSI RX580", 3, 1, 180,
				"MSI RX580 with air cooling, ideal for gaming at 1080p, supported by MSI afterburner, not included with the graphis card, download separately",
				"MSI RX580 Air cooling Extreme", b2, "Calle padre san Roman 10, Madrid, Spain", "AMD", "AMD", "Gaming");
		Post p4 = new Post("MSI RX 480 6GB", 3, 1, 250,
				"MSI RX 480 6GB video memory, two fans of air cooling, gaming ready with Pascal architecture, NVidia shadowplay compatible",
				"MSI RX 480 6GB video memory", b2, "Elm Street 7, London UK", "AMD", "GPU", "Gaming");
		Post p5 = new Post("Seagate barracuda HDD drive", 1, 1, 40,
				"1TB seagate Barracuda HDD internal disk drive, 1GB/s transference rate", "1TB HDD Seagate", b9,
				"Elm Street 7, London UK", "HDD", "1TB");
		Post p6 = new Post("MSI RTX 2080", 2, 1, 920,
				"High end gaming GPU RTX 2080 with Ray Tracing, the latest from NVIDIA", "RTX 2080 GPU", b2,
				"Bridges Street 10, Washington USA", "GPU", "RTX", "Gaming");
		Post p7 = new Post("3D Printer", 9, 1, 520,
				"3D printer comes with golden plastic for the 3D models, cheap but durable and reliable, semi-new",
				"semi-new 3D printer", b1, "Palace Street, Moscow, Russia", "Printer", "3D","semi-new");
		Post p8 = new Post("INTEL CPU", 2, 1, 460, "Intel seventh gen 7700 CPU for gaming and high end computing",
				"Intel i7 7770 CPU", b12, "Palace Street, Moscow, Russia", "CPU", "i7");
		Post p9 = new Post("MSI GTX 1050 4GB", 3, 1, 130,
				"GTX 1050 4GB video memory, two fans of air cooling, ASUS brand, NVidia shadowplay compatible",
				"GTX 1050 4GB video memory", b2, "Palace Street, Moscow, Russia", "GTX1050", "GPU", "Gaming");
		Post p10 = new Post("MSI GTX 1070 8GB", 3, 1, 420,
				"GTX 1070 6GB video memory, three fans of air cooling, high end gaming ready",
				"GTX 1070 6GB video memory, three fans of air cooling", b2, "Park avenue 34, New York, USA", "GTX1070",
				"GPU", "Gaming");
		Post p11 = new Post("MSI GTX 1060 6GB", 3, 1, 235,
				"MSI GTX 1060 6GB video memory, two fans of air cooling, gaming ready with Pascal architecture, NVidia shadowplay compatible",
				"MSI GTX 1060 6GB video ram ideal for gaming", b2, "Plaza Urquinaona, Barcelona, Spain", "GTX1060",
				"GPU", "Gaming");
		Post p12 = new Post("Printer cartridges", 11, 1, 20,
				"new cartridges for ink printer, 3-pack, red, blue and green for rgb printers",
				"3 new ink printer cartridges", b1, "Avenida Santiago Bernabeu, Madrid, Spain", "Ink printer",
				"cartridge");
		Post p13 = new Post("GTX 1050Ti", 3, 3, 100,
				"GTX 1050Ti 4GB video RAM ideal for gaming, for budget computer builds, NVidia shadowplay compatible",
				"GTX 1050Ti 4GB gaming ready", b2, "Rue de l'oeuf 23, Paris, France", "Gaming", "1050Ti");
		Post p14 = new Post("3D Printer cartridge", 11, 1, 30, "3D printer cartridges, golden color, new",
				"3D pritner golden cartridges", b1, "Rue de l'oeuf 23, Paris, France", "3D Printer", "cartridge");
		Post p15 = new Post("WD HDD Disk", 2, 1, 30,
				"1TB HDD WD Disk semi new, may contain some suspicious data I forgot to delete", "1TB HDD WD Disk", b3,
				"Central Park Street 3, New York, USA", "HDD", "1TB");
		Post p16 = new Post("DJ Speakers", 4, 1, 220, "Good speakers to plug onto a tv or pc, the sound is good, new",
				"DJ speakers Pioneer", b13, "Calle de la montaña, Jalisco Mexico", "Speakers");
		Post p17 = new Post("MSI X470", 0, 1, 120,
				"MSI X470 gaming motherboard, 3xSATA 3.0 ports, HDMI Compatible SLI compatible",
				"MSI X470 gaming motherboard", b2, "Calle de la montaña, Jalisco Mexico", "Gaming", "Mobo");
		Post p18 = new Post("MSI RTX 2080 Ti", 3, 2, 1020,
				"High end MSI RTX 2080Ti Graphics card with Raytracing, NVIDIA, shadowplay compatible",
				"High end MSI RTX 2080Ti Graphics card", b2, "Calle de la montaña, Jalisco Mexico", "RTX", "Gaming");
		Post p19 = new Post("RTX 2060", 3, 1, 330,
				"RTX 2060 12GB video memory, ray tracing, NVidia shadowplay compatible",
				"RTX 2060 12GB video ram ideal for gaming", b2, "Calle de la montaña, Jalisco Mexico", "RTX", "GPU",
				"Gaming");
		Post p20 = new Post("AMD Vega 76 8GB", 3, 1, 630,
				"AMD Vega 76 8GB, gaming ready with Vega architecture, MSI Afterburner compatible",
				"AMD Vega 76 8GB, gaming ready", b6, "Calle del rio 24, Cuenca, España", "Vega", "GPU", "Gaming");
		Post p21 = new Post("MSI RTX 2070", 3, 1, 300,
				"MSI RTX 2070 SUPER, NVIDIA semi-used new GPU one cooling fan, may need cleaning",
				"newly released NVIDIA 2070 GPU", b2, "Calle del rio 24, Cuenca, España", "AMD", "GPU", "Gaming");
		Post p22 = new Post("AMD Vega 64 8Gb", 3, 1, 390,
				"AMD Vega 76 8GB video memory, two fans of air cooling, gaming ready with Vega architecture",
				"AMD Vega 64 8GB", b6, "Plaza del hierro 23, Toledo, España", "Vega", "GPU", "Gaming");

		Rating r1 = new Rating(2);
		Rating r2 = new Rating(3);
		Rating r3 = new Rating(5);
		Rating r4 = new Rating(1);
		Rating r5 = new Rating(0);
		Rating r6 = new Rating(2);
		Rating r7 = new Rating(4);
		Rating r8 = new Rating(5);
		Rating r9 = new Rating(3);
		Rating r10 = new Rating(2);
		Rating r11 = new Rating(3);
		Rating r12 = new Rating(0);

		r1.setSeller(user);
		r2.setSeller(user2);
		r3.setSeller(user3);
		r4.setSeller(user4);
		r5.setSeller(user5);
		r6.setSeller(user6);
		r7.setSeller(user7);
		r8.setSeller(user8);
		r9.setSeller(user9);
		r10.setSeller(user10);
		r11.setSeller(user11);
		r12.setSeller(user12);

		r1.setBuyer(user12);
		r2.setBuyer(user11);
		r3.setBuyer(user10);
		r4.setBuyer(user9);
		r5.setBuyer(user8);
		r6.setBuyer(user7);
		r7.setBuyer(user6);
		r8.setBuyer(user5);
		r9.setBuyer(user4);
		r10.setBuyer(user3);
		r11.setBuyer(user2);
		r12.setBuyer(user);

		brandRepository.save(b1);
		brandRepository.save(b2);
		brandRepository.save(b3);
		brandRepository.save(b4);
		brandRepository.save(b5);
		brandRepository.save(b6);
		brandRepository.save(b7);
		brandRepository.save(b8);
		brandRepository.save(b9);
		brandRepository.save(b10);
		brandRepository.save(b11);
		brandRepository.save(b12);
		brandRepository.save(b13);

		b1.getPosts().add(p1);
		b4.getPosts().add(p2);
		b2.getPosts().add(p3);
		b2.getPosts().add(p4);
		b9.getPosts().add(p5);
		b2.getPosts().add(p6);
		b1.getPosts().add(p7);
		b12.getPosts().add(p8);
		b2.getPosts().add(p9);
		b2.getPosts().add(p10);
		b2.getPosts().add(p11);
		b1.getPosts().add(p12);
		b2.getPosts().add(p13);
		b1.getPosts().add(p14);
		b3.getPosts().add(p15);
		b13.getPosts().add(p16);
		b2.getPosts().add(p18);
		b2.getPosts().add(p19);
		b6.getPosts().add(p20);
		b2.getPosts().add(p21);
		b6.getPosts().add(p22);

		userRepository.save(user);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
		userRepository.save(user6);
		userRepository.save(user7);
		userRepository.save(user8);
		userRepository.save(user9);
		userRepository.save(user10);
		userRepository.save(user11);
		userRepository.save(user12);

		user.getPosts().add(p1);
		user.getPosts().add(p2);
		user.getPosts().add(p3);
		user2.getPosts().add(p4);
		user2.getPosts().add(p5);
		user3.getPosts().add(p6);
		user4.getPosts().add(p7);
		user4.getPosts().add(p8);
		user4.getPosts().add(p9);
		user5.getPosts().add(p10);
		user6.getPosts().add(p11);
		user7.getPosts().add(p12);
		user8.getPosts().add(p13);
		user8.getPosts().add(p14);
		user9.getPosts().add(p15);
		user10.getPosts().add(p16);
		user10.getPosts().add(p17);
		user10.getPosts().add(p18);
		user10.getPosts().add(p19);
		user11.getPosts().add(p20);
		user11.getPosts().add(p21);
		user12.getPosts().add(p22);

		postRepository.save(p1);
		postRepository.save(p2);
		postRepository.save(p3);
		postRepository.save(p4);
		postRepository.save(p5);
		postRepository.save(p6);
		postRepository.save(p7);
		postRepository.save(p8);
		postRepository.save(p9);
		postRepository.save(p10);
		postRepository.save(p11);
		postRepository.save(p12);
		postRepository.save(p13);
		postRepository.save(p14);
		postRepository.save(p15);
		postRepository.save(p16);
		postRepository.save(p17);
		postRepository.save(p18);
		postRepository.save(p19);
		postRepository.save(p20);
		postRepository.save(p21);
		postRepository.save(p22);

		p1.setUser(user);
		p2.setUser(user);
		p3.setUser(user);
		p4.setUser(user2);
		p5.setUser(user2);
		p6.setUser(user3);
		p7.setUser(user4);
		p8.setUser(user4);
		p9.setUser(user4);
		p10.setUser(user5);
		p11.setUser(user6);
		p12.setUser(user7);
		p13.setUser(user8);
		p14.setUser(user8);
		p15.setUser(user9);
		p16.setUser(user10);
		p17.setUser(user10);
		p18.setUser(user10);
		p19.setUser(user10);
		p20.setUser(user11);
		p21.setUser(user11);
		p22.setUser(user12);

		brandRepository.save(b1);
		brandRepository.save(b2);
		brandRepository.save(b3);
		brandRepository.save(b4);
		brandRepository.save(b5);
		brandRepository.save(b6);
		brandRepository.save(b7);
		brandRepository.save(b8);
		brandRepository.save(b9);
		brandRepository.save(b10);
		brandRepository.save(b11);
		brandRepository.save(b12);
		brandRepository.save(b13);

		userRepository.save(user);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
		userRepository.save(user6);
		userRepository.save(user7);
		userRepository.save(user8);
		userRepository.save(user9);
		userRepository.save(user10);
		userRepository.save(user11);
		userRepository.save(user12);

		postRepository.save(p1);
		postRepository.save(p2);
		postRepository.save(p3);
		postRepository.save(p4);
		postRepository.save(p5);
		postRepository.save(p6);
		postRepository.save(p7);
		postRepository.save(p8);
		postRepository.save(p9);
		postRepository.save(p10);
		postRepository.save(p11);
		postRepository.save(p12);
		postRepository.save(p13);
		postRepository.save(p14);
		postRepository.save(p15);
		postRepository.save(p16);
		postRepository.save(p17);
		postRepository.save(p18);
		postRepository.save(p19);
		postRepository.save(p20);
		postRepository.save(p21);
		postRepository.save(p22);

		ratingRepository.save(r1);
		ratingRepository.save(r2);
		ratingRepository.save(r3);
		ratingRepository.save(r4);
		ratingRepository.save(r5);
		ratingRepository.save(r6);
		ratingRepository.save(r7);
		ratingRepository.save(r8);
		ratingRepository.save(r9);
		ratingRepository.save(r10);
		ratingRepository.save(r11);
		ratingRepository.save(r12);

	}

}
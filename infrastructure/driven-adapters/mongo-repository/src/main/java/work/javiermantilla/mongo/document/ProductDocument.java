package work.javiermantilla.mongo.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDocument {
	@Id
	private String id;
	private String nombre;
	private Double precio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
}

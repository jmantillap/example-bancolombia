package work.javiermantilla.model.product;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {
		
	private String id;
	private String nombre;	
	private Double precio;	
	private Date createAt;
	
	public Product(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
}

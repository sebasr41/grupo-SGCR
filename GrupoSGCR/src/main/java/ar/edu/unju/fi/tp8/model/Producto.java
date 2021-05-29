package ar.edu.unju.fi.tp8.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCTOS")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3,max=100,message="ingrese un codigo de al menos 3 digito y maximo de 100" )
	@NotNull(message="Ingrese un nombre valido")
	@Column(name = "prod_codigo", nullable = false)
	private long codigo;
	
	@Size(min=3,max=100,message="ingrese un menos 3 digito y maximo de 100" )
	@NotNull(message="Ingrese un nombre valido")
	@Column(name = "prod_nombre", length = 100)
	private String nombre;
	
	@Size(min=1,message="Debe ingresar algun valor, de al menos 1 digito")
	@Column(name = "prod_precio")
	private double precio;
	
	@Size(min=3,max=100,message="ingrese una marca de al menos 3 caracteres y maximo de 100" )
	@Column(name = "prod_marca", length = 100)
	private String marca;
	
	@Size(min=1,message="Debe ingresar algun valor, de al menos 1 digito")
	@Column(name = "prod_stock")
	private int stock;
	
	@Valid
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "com_id")
	private Compra compra;
	
	// Constructor empty
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Long id, int codigo, String nombre, double precio, String marca, int stock, Compra compra) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.compra = compra;
	}

	// Setters and getters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	// to String

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca="
				+ marca + ", stock=" + stock + ", compra=" + compra + "]";
	}
	
	
	
}

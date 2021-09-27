package com.empresa.microservicios.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.microservicios.models.Factura;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
	
	@PostMapping
	public String crearFactura(@RequestBody Factura factura) {
		
		// Recuperar los datos de la factura
		System.out.println(factura.getConcepto());
		
		// Insertar la factura en base de datos
		// ...
		
		return "Todo OK";
	}
	
	@GetMapping("/{facturaId}")
	public Factura recuperarFactura(@PathVariable String facturaId) {
		
		System.out.println(facturaId);
		// Recuperar de la base de datos la entidad asociada a facturaId
		// ...
		// Crear un objeto de prueba
		Factura f = new Factura();
		f.setConcepto("Servicio de formación");
		f.setImporte(23456);
		f.setCif("B91234565");
		
		return f;
	}

	@DeleteMapping("/{facturaId}")
	public String borrarFactura(@PathVariable String facturaId) {
		
		System.out.println(facturaId);
		
		// Borrar de la base de datos la entidad asociada a facturaId
		// ...
		
		
		return "La operación se ha realizado con éxito";
	}
	
}

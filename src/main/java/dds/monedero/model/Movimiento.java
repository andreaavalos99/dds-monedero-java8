package dds.monedero.model;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class Movimiento {
  private LocalDate fecha;
  // Nota: En ningún lenguaje de programación usen jamás doubles (es decir, números con punto flotante) para modelar dinero en el mundo real.
  // En su lugar siempre usen numeros de precision arbitraria o punto fijo, como BigDecimal en Java y similares
  // De todas formas, NO es necesario modificar ésto como parte de este ejercicio. 
  private double monto;
  private boolean esDeposito;

  public Movimiento(LocalDate fecha, double monto, boolean esDeposito) {
    this.fecha = fecha;
    this.monto = monto;
    this.esDeposito = esDeposito;
  }

  public double getMonto() {
    return monto;
  }
  
  public boolean getEsDeposito() {
	  return esDeposito;
  }
  public LocalDate getFecha() {
    return fecha;
  }

  public boolean fueDepositado(LocalDate fecha) {
    return esDeposito && esDeLaFecha(fecha);
  }

  public boolean fueExtraido(LocalDate fecha) {
    return !esDeposito && esDeLaFecha(fecha);
  }

  public boolean esDeLaFecha(LocalDate fecha) {
    return this.fecha.equals(fecha);
  }


  public void agregateA(Cuenta cuenta) {
    cuenta.setSaldo(calcularValor(cuenta));
    cuenta.agregarMovimiento(fecha, monto, esDeposito);
  }

  public double calcularValor(Cuenta cuenta) {
    if (esDeposito) {
      return cuenta.getSaldo() + getMonto();
    } else {
      return cuenta.getSaldo() - getMonto();
    }
  }
  

}

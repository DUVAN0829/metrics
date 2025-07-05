package co.micrometers.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricApplication {

    public static void main(String[] args) {

        CompositeMeterRegistry compositeMeter = Metrics.globalRegistry; //todo -> Se encarga de almacenar, registrar y publicar varias metricas.

        Counter counter = compositeMeter.counter("numero.empleados", "Oficiona", "Duván González"); //todo -> Registrar metrica.

        MeterRegistry registry = new SimpleMeterRegistry(); //todo -> Se crea una MeterRegistry

        compositeMeter.add(registry); //todo -> Se añade MeterRegistry

        counter.increment(); //todo -> Se modifica MeterRegistry
        counter.increment(200);

        System.out.println("El número de empleados es: " + counter.count());

        asignarNuevoParamGlobalRegistry();

    }

    public static void asignarNuevoParamGlobalRegistry() {

        CompositeMeterRegistry compositeMeter = Metrics.globalRegistry;

        //* Meters o Medidas
        //todo -> nota: los meters, tienen un nombre, y el tag es la clave y el elemento al lado es el valor.
        Counter counter = compositeMeter.counter("numero.empleados", "Oficiona", "Duván González");

        counter.increment(150);

        System.out.println("El número de empleados es: " + counter.count());

    }

}

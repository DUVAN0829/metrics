package co.micrometers.gauge;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GaugeApplication {

    //todo -> Valor actual de una medida, usado para monitorear estadisticas de cache, colecciones y más...
    public static void main(String[] args) {

        MeterRegistry registry = new SimpleMeterRegistry();

        List<String> list = new ArrayList<>(4);

        //todo -> No es necesario guardar el valor en una variable Gauge, ya que dará error al ser nulo
        registry.gauge("list.size", list, List::size);

        System.out.println(registry.find("list.size").gauge().value());

        list.addAll(Arrays.asList("Duván", "Hola mundo", "Devs"));

        System.out.println(registry.find("list.size").gauge().value());

    }

}

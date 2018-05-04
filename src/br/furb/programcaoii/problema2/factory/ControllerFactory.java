package br.furb.programcaoii.problema2.factory;

import br.furb.programcaoii.problema2.controller.Controller;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ariel
 */
public class ControllerFactory<C extends Controller> {
    
    private static final Map<String, Controller> map = new HashMap<>();
    
    private static <C extends Controller> String getNome(Class<C> clazz) {
        return clazz.getName();
    }
    
    public static <C extends Controller> C getController(Class<C> clazz) {
        String nomeClasse = getNome(clazz);
        
        C controller = (C) map.get(nomeClasse);
        
        if (null == controller) {
            controller = instanciarController(clazz);
            map.put(nomeClasse, controller);
        }
        
        return controller;
    }

    private static <C extends Controller> C instanciarController(Class<C> clazz) {
        Constructor<?>[] construtores = clazz.getConstructors();
        for (Constructor<?> construtor : construtores) {
            if (0 == construtor.getParameterCount()) {
                try {
                    return (C) construtor.newInstance(new Object[] {});
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }
}

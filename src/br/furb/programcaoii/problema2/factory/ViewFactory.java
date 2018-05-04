package br.furb.programcaoii.problema2.factory;

import br.furb.programcaoii.problema2.view.ClienteView;
import br.furb.programcaoii.problema2.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariel
 * @param <V>
 */
public class ViewFactory<V extends View> {
    
    private static final Map<String, View> map = new HashMap<>();
    
    private static <V extends View> String getNome(Class<V> clazz) {
        return clazz.getName();
    }
    
    public static <V extends View> V getView(Class<V> clazz, boolean cache) {
        String nomeClasse = getNome(clazz);
        
        V view = (V) map.get(nomeClasse);
        
        if (null == view || !cache) {
            view = instanciarView(clazz);
            map.put(nomeClasse, view);
        }
        
        return view;
    }

    private static <V extends View> V instanciarView(Class<V> clazz) {
        Constructor<?>[] construtores = clazz.getConstructors();
        for (Constructor<?> construtor : construtores) {
            if (0 == construtor.getParameterCount()) {
                try {
                    return (V) construtor.newInstance(new Object[] {});
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }

    public static <V extends View> V getView(Class<V> clazz) {
        return getView(clazz, true);
    }
}

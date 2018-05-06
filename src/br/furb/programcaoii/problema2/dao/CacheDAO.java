package br.furb.programcaoii.problema2.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ariel
 * @param <O>
 */
public abstract class CacheDAO<O extends Object> implements DAO<O> {
    
    private static final Map<String, Set<Object>> MAP = new HashMap<>();
    
    @Override
    public Set<O> getObjetosPersistidos() {
        //carregarCache();
        
        String nomeClasse = getNomeClasse(getEntityClass());
        Set<O> objetos = (Set<O>) MAP.get(nomeClasse);
        
        if (null == objetos) {
            objetos = new HashSet<>();
            MAP.put(nomeClasse, (Set<Object>) objetos);
        }
        
        return objetos;
    }
    
    private <O extends Object> String getNomeClasse(Class<O> clazz) {
        return clazz.getName();
    }

    @Override
    public void salvar(O obj) {
        Set<O> objetos = getObjetosPersistidos();
        
        objetos.add(obj);
        
        //salvarCache();
    }

    @Override
    public void excluir(O obj) {
        Set<O> objetos = getObjetosPersistidos();
        
        objetos.remove(obj);
        
        //salvarCache();
    }
    
    private void salvarCache() {
        Path caminho = getCaminhoCache();
        
        try {
            OutputStream os = Files.newOutputStream(caminho);
            
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.reset();
            oos.writeObject(MAP);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void carregarCache() {
        Path caminho = getCaminhoCache();
        
        try {
            InputStream is = Files.newInputStream(caminho);
            
            ObjectInputStream ois = new ObjectInputStream(is);
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                Map<String, Set<Object>> mapCache = (Map<String, Set<Object>>) obj;
                mapCache.entrySet().forEach(entry -> CacheDAO.MAP.put(entry.getKey(), entry.getValue()));
            }
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    private Path getCaminhoCache() {
        return Paths.get(new File("cache.dat").getAbsolutePath());
    }
    
    public abstract Class<O> getEntityClass();

}

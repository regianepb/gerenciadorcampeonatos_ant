package br.com.gerenciadorcampeonatos.resource;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.gerenciadorcampeonatos.resource.BairroResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.CampeonatoDespesaResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.CampeonatoJogadorResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.CampeonatoPatrocinadorResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.CampeonatoResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.DespesaResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.EnderecoResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.EstadoResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.JogadorPosicaoResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.JogadorResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.ModalidadeResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.MunicipioResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.PaisResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.PatrocinadorResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.PosicaoResource.class);
        resources.add(br.com.gerenciadorcampeonatos.resource.TimeResource.class);
        resources.add(br.com.gerenciadorcampeonatos.util.JacksonJavaTimeConfiguration.class);
    }
}
